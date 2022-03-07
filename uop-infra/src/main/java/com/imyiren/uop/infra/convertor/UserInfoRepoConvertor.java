package com.imyiren.uop.infra.convertor;


import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.infra.dal.po.UopUser;

/**
 * @author yiren
 */
public abstract class UserInfoRepoConvertor {

    public static UserInfoDO toUserDO(UopUser uopUser) {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setId(uopUser.getId());
        userInfoDO.setCode(uopUser.getCode());
        userInfoDO.setUsername(uopUser.getUsername());
        userInfoDO.setPhone(uopUser.getPhone());
        userInfoDO.setEmail(uopUser.getEmail());
        userInfoDO.setEncryptedPwd(uopUser.getEncryptedPwd());
        userInfoDO.setNickname(uopUser.getNickname());
        userInfoDO.setState(uopUser.getState());
        userInfoDO.setDeleted(uopUser.getDeleted());
        userInfoDO.setCreateTime(uopUser.getCreateTime());
        userInfoDO.setUpdateTime(uopUser.getUpdateTime());
        return userInfoDO;
    }

    public static UopUser toUopUser(UserInfoDO userInfoDO) {
        UopUser uopUser = new UopUser();
        uopUser.setCode(userInfoDO.getCode());
        uopUser.setUsername(userInfoDO.getUsername());
        uopUser.setId(userInfoDO.getId());
        uopUser.setEmail(userInfoDO.getEmail());
        uopUser.setEncryptedPwd(userInfoDO.getEncryptedPwd());
        uopUser.setPhone(userInfoDO.getPhone());
        uopUser.setState(userInfoDO.getState());
        uopUser.setDeleted(userInfoDO.getDeleted());
        uopUser.setNickname(userInfoDO.getNickname());
        uopUser.setCreateTime(userInfoDO.getCreateTime());
        uopUser.setUpdateTime(userInfoDO.getUpdateTime());
        return uopUser;

    }
}
