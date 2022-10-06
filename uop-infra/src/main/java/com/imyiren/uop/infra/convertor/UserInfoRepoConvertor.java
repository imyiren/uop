package com.imyiren.uop.infra.convertor;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.imyiren.uop.client.common.UserRoleEnum;
import com.imyiren.uop.domain.repository.entity.UserExtraInfoDO;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.infra.dal.po.UopUser;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author yiren
 */
public abstract class UserInfoRepoConvertor {

    public static UserInfoDO toUserDO(UopUser uopUser) {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setCode(uopUser.getCode());
        userInfoDO.setUsername(uopUser.getUsername());
        userInfoDO.setId(uopUser.getId());
        userInfoDO.setEmail(uopUser.getEmail());
        userInfoDO.setEncryptedPwd(uopUser.getEncryptedPwd());
        userInfoDO.setPhone(uopUser.getPhone());
        userInfoDO.setNickname(uopUser.getNickname());
        userInfoDO.setState(uopUser.getState());
        userInfoDO.setDeleted(uopUser.getDeleted());
        if (StringUtils.isEmpty(uopUser.getExtraJson())) {
            UserExtraInfoDO userExtraInfoDO = new UserExtraInfoDO();
            userExtraInfoDO.setRoleList(Lists.newArrayList(UserRoleEnum.USER.getCode()));
            userInfoDO.setExtraInfo(userExtraInfoDO);
        } else {
            userInfoDO.setExtraInfo(JSONObject.parseObject(uopUser.getExtraJson(), UserExtraInfoDO.class));
            if (CollectionUtils.isEmpty(userInfoDO.getExtraInfo().getRoleList())) {
                userInfoDO.getExtraInfo().setRoleList(Lists.newArrayList(UserRoleEnum.USER.getCode()));
            }
        }
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
        if (Objects.nonNull(userInfoDO.getExtraInfo()) && !CollectionUtils.isEmpty(userInfoDO.getExtraInfo().getRoleList())) {
            uopUser.setExtraJson(JSONObject.toJSONString(userInfoDO.getExtraInfo()));
        }
        uopUser.setDeleted(userInfoDO.getDeleted());
        uopUser.setNickname(userInfoDO.getNickname());
        uopUser.setCreateTime(userInfoDO.getCreateTime());
        uopUser.setUpdateTime(userInfoDO.getUpdateTime());
        return uopUser;
    }

}
