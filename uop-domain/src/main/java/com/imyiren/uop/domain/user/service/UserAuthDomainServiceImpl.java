package com.imyiren.uop.domain.user.service;

import com.imyiren.uop.domain.repository.api.UserInfoRepository;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.domain.user.api.UserAuthDomainService;
import com.imyiren.uop.domain.user.event.CreateUserSessionEvent;
import com.imyiren.uop.domain.user.event.DeleteUserSessionEvent;
import com.imyiren.result.BizStateCodes;
import com.imyiren.result.error.BizRuntimeException;
import com.imyiren.utils.common.UuidUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yiren
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserAuthDomainServiceImpl implements UserAuthDomainService {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserInfoRepository userInfoRepository;

    @Override
    public String createUserSession(CreateUserSessionEvent event) {

        // 获取用户信息
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setUsername(event.getUsername());
        UserInfoDO userInfo = userInfoRepository.getByQuery(userInfoQuery);

        // 验证密码
        if (Objects.isNull(userInfo) || !passwordEncoder.matches(event.getPassword(), userInfo.getEncryptedPwd())) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "用户名或密码不正确！");
        }

        String sessionId = UuidUtils.generate();
        // create session to userInfo map.

        return sessionId;
    }

    @Override
    public boolean deleteSession(DeleteUserSessionEvent event) {
        String sessionId = event.getSessionId();

        return true;
    }
}
