package com.imyiren.uop.domain.user.service;

import com.imyiren.uop.client.common.UserStateEnum;
import com.imyiren.uop.domain.repository.api.UserInfoRepository;
import com.imyiren.uop.domain.repository.api.UserSessionRepository;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.entity.UserSessionDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.domain.repository.query.UserSessionQuery;
import com.imyiren.uop.domain.user.api.UserAuthDomainService;
import com.imyiren.uop.domain.user.event.CreateUserSessionEvent;
import com.imyiren.uop.domain.user.event.DeleteUserSessionEvent;
import com.imyiren.result.BizStateCodes;
import com.imyiren.result.error.BizRuntimeException;
import com.imyiren.uop.domain.user.event.UserSessionDelayEvent;
import com.imyiren.utils.common.UuidUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author yiren
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserAuthDomainServiceImpl implements UserAuthDomainService {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private final UserInfoRepository userInfoRepository;
    private final UserSessionRepository userSessionRepository;

    @Override
    public String createUserSession(CreateUserSessionEvent event) {
        // 获取用户信息
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setUsername(event.getUsername());
        UserInfoDO userInfo = userInfoRepository.get(userInfoQuery);

        // 验证密码
        if (Objects.isNull(userInfo) || !PASSWORD_ENCODER.matches(event.getPassword(), userInfo.getEncryptedPwd())) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "用户名或密码不正确！");
        }

        // 校验状态
        if (!Objects.equals(userInfo.getState(), UserStateEnum.ACTIVE.getCode())) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "当前账号不可用！");
        }

        // 创建session
        String sessionId = UuidUtils.generate();
        UserSessionDO userSessionDO = new UserSessionDO();
        userSessionDO.setSessionId(sessionId);
        userSessionDO.setUserId(userInfo.getId());
        userSessionDO.setExpireTime(LocalDateTime.now().plusHours(5));
        userSessionDO.setLoginIp(event.getLoginIp());
        userSessionRepository.save(userSessionDO);
        // create session to userInfo map.
        return sessionId;
    }

    @Override
    public boolean expireSession(DeleteUserSessionEvent event) {
        UserSessionQuery userSessionQuery = new UserSessionQuery();
        userSessionQuery.setSessionId(event.getSessionId());
        UserSessionDO userSessionDO = userSessionRepository.get(userSessionQuery);
        if (Objects.isNull(userSessionDO)) {
            return true;
        }
        userSessionDO.setExpireTime(LocalDateTime.now());
        userSessionRepository.save(userSessionDO);
        return true;
    }

    @Override
    public boolean delaySessionExpireTime(UserSessionDelayEvent event) {
        UserSessionQuery userSessionQuery = new UserSessionQuery();
        userSessionQuery.setSessionId(event.getSessionId());
        userSessionQuery.setExpireTimeEnd(LocalDateTime.now());
        UserSessionDO userSessionDO = userSessionRepository.get(userSessionQuery);
        if (Objects.isNull(userSessionDO)) {
            return false;
        }

        userSessionDO.setExpireTime(LocalDateTime.now().plusHours(5));
        userSessionRepository.save(userSessionDO);
        return true;
    }

    @Override
    public UserInfoDO saveUser(UserInfoDO userInfoDO) {
        if (!StringUtils.isEmpty(userInfoDO.getEncryptedPwd())) {
            userInfoDO.setEncryptedPwd(PASSWORD_ENCODER.encode(userInfoDO.getEncryptedPwd()));
        }
        UserInfoDO save = userInfoRepository.save(userInfoDO);
        UserInfoQuery query = new UserInfoQuery();
        query.setId(save.getId());
        return userInfoRepository.get(query);
    }

    public static void main(String[] args) {
        System.out.println(PASSWORD_ENCODER.encode("123456"));
    }

}
