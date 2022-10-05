package com.imyiren.uop.application.convertor;

import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.read.query.UserGetQuery;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import com.imyiren.uop.client.common.UserStateEnum;
import com.imyiren.uop.domain.repository.entity.UserExtraInfoDO;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;

import java.util.Optional;

/**
 * @author yiren
 */
public class UserAppConvertor {

    public static UserInfoQuery toUserInfoQuery(UserGetQuery query) {
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setId(query.getId());
        userInfoQuery.setCode(query.getCode());
        userInfoQuery.setUsername(query.getUsername());
        userInfoQuery.setPhone(query.getPhone());
        userInfoQuery.setEmail(query.getEmail());
        userInfoQuery.setState(query.getState());
        return userInfoQuery;
    }


    public static UserInfoDTO toUserInfoDTO(UserInfoDO user) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(user.getId());
        userInfoDTO.setCode(user.getCode());
        userInfoDTO.setUsername(user.getUsername());
        userInfoDTO.setPhone(user.getPhone());
        userInfoDTO.setEmail(user.getEmail());
        userInfoDTO.setEncryptedPwd(user.getEncryptedPwd());
        userInfoDTO.setNickname(user.getNickname());
        userInfoDTO.setState(user.getState());
        userInfoDTO.setStateDesc(UserStateEnum.of(user.getState()).getDesc());
        Optional.ofNullable(user).map(UserInfoDO::getExtraInfo).map(UserExtraInfoDO::getRoleList).ifPresent(userInfoDTO::setRoleList);
        userInfoDTO.setDeleted(user.getDeleted());
        userInfoDTO.setCreateTime(user.getCreateTime());
        userInfoDTO.setUpdateTime(user.getUpdateTime());
        return userInfoDTO;
    }

    public static UserSessionInfoDTO toUserSessionInfoDTO(UserInfoDO userInfoDO) {
        UserSessionInfoDTO userSessionInfoDTO = new UserSessionInfoDTO();
        userSessionInfoDTO.setUserId(userInfoDO.getId());
        userSessionInfoDTO.setUsername(userInfoDO.getUsername());
        userSessionInfoDTO.setPhone(userInfoDO.getPhone());
        userSessionInfoDTO.setCode(userInfoDO.getCode());
        userSessionInfoDTO.setEncryptedPwd(userInfoDO.getEncryptedPwd());
        userSessionInfoDTO.setNickname(userInfoDO.getNickname());
        userSessionInfoDTO.setEmail(userInfoDO.getEmail());
        userSessionInfoDTO.setDeleted(userInfoDO.getDeleted());
        userSessionInfoDTO.setCreateTime(userInfoDO.getCreateTime());
        userSessionInfoDTO.setState(userInfoDO.getState());
        userSessionInfoDTO.setStateDesc(UserStateEnum.of(userInfoDO.getState()).getDesc());
        Optional.of(userInfoDO).map(UserInfoDO::getExtraInfo).map(UserExtraInfoDO::getRoleList)
                .ifPresent(userSessionInfoDTO::setRoleList);
        userSessionInfoDTO.setUpdateTime(userInfoDO.getUpdateTime());
        return userSessionInfoDTO;
    }

    public static UserInfoQuery toUserInfoQuery(UserListPageQuery query) {
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setUsername(query.getUsername());
        userInfoQuery.setCode(query.getCode());
        userInfoQuery.setPhone(query.getPhone());
        userInfoQuery.setEmail(query.getEmail());
        userInfoQuery.setState(query.getState());
        userInfoQuery.setNickname(query.getNickname());
        userInfoQuery.setCreateTime(query.getCreateTime());
        userInfoQuery.setCreateTimeStart(query.getCreateTimeStart());
        userInfoQuery.setCreateTimeEnd(query.getCreateTimeEnd());
        userInfoQuery.setUpdateTime(query.getUpdateTime());
        userInfoQuery.setUpdateTimeStart(query.getUpdateTimeStart());
        userInfoQuery.setUpdateTimeEnd(query.getUpdateTimeEnd());
        return userInfoQuery;


    }
}
