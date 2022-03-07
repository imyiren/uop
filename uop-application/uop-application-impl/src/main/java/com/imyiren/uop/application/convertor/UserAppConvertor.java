package com.imyiren.uop.application.convertor;

import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.read.query.UserGetQuery;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;

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
        userSessionInfoDTO.setUpdateTime(userInfoDO.getUpdateTime());
        return userSessionInfoDTO;


    }
}
