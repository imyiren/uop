package com.imyiren.uop.application.read;

import com.github.pagehelper.PageInfo;
import com.imyiren.application.api.dto.PageDTO;
import com.imyiren.uop.application.convertor.UserAppConvertor;
import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.read.query.UserGetQuery;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import com.imyiren.uop.application.read.query.UserInfoGetByValidSessionQuery;
import com.imyiren.uop.application.utils.PageUtils;
import com.imyiren.uop.client.common.UserStateEnum;
import com.imyiren.uop.domain.repository.api.UserInfoRepository;
import com.imyiren.uop.domain.repository.api.UserSessionRepository;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.entity.UserSessionDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.domain.repository.query.UserSessionQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author yiren
 */
@Slf4j
@DubboService
@AllArgsConstructor
public class UserInfoReadAppServiceImpl implements UserInfoReadAppService {

    private final UserInfoRepository userInfoRepository;
    private final UserSessionRepository userSessionRepository;

    @Override
    public PageDTO<UserInfoDTO> listPageByQuery(UserListPageQuery query) {
        UserInfoQuery userInfoQuery = UserAppConvertor.toUserInfoQuery(query);
        PageInfo<UserInfoDO> pageInfo = userInfoRepository.listPage(query.getPageNum(), query.getPageSize(), userInfoQuery);
        return PageUtils.toPageDTO(pageInfo, UserAppConvertor::toUserInfoDTO);
    }

    @Override
    public UserInfoDTO get(UserGetQuery userGetQuery) {
        if (Objects.isNull(userGetQuery)) {
            return null;
        }
        UserInfoQuery userInfoQuery = UserAppConvertor.toUserInfoQuery(userGetQuery);
        UserInfoDO userInfoDO = userInfoRepository.get(userInfoQuery);
        if (Objects.isNull(userInfoDO)) {
            return null;
        }
        return UserAppConvertor.toUserInfoDTO(userInfoDO);
    }

    @Override
    public UserSessionInfoDTO getByValidSession(UserInfoGetByValidSessionQuery query) {
        // session 查询
        UserSessionQuery userSessionQuery = new UserSessionQuery();
        userSessionQuery.setSessionId(query.getSessionId());
        userSessionQuery.setExpireTimeStart(LocalDateTime.now());
        UserSessionDO userSessionDO = userSessionRepository.get(userSessionQuery);
        if (Objects.isNull(userSessionDO)) {
            return null;
        }

        // 用户信息查询
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setId(userSessionDO.getUserId());
        userInfoQuery.setState(UserStateEnum.ACTIVE.getCode());
        UserInfoDO userInfoDO = userInfoRepository.get(userInfoQuery);
        if (Objects.isNull(userInfoDO)) {
            return null;
        }

        // 填充session信息
        UserSessionInfoDTO userSessionInfoDTO = UserAppConvertor.toUserSessionInfoDTO(userInfoDO);
        userSessionInfoDTO.setSessionId(query.getSessionId());
        userSessionInfoDTO.setExpireTime(userSessionDO.getExpireTime());

        return userSessionInfoDTO;
    }

}
