package com.imyiren.uop.convertor;

import com.google.common.collect.Lists;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.write.cmd.UserCreateCmd;
import com.imyiren.uop.application.write.cmd.UserLoginCmd;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.write.dto.UserLoginDTO;
import com.imyiren.uop.request.UserLoginRequest;
import com.imyiren.uop.request.UserRegisterRequest;
import com.imyiren.uop.vo.UserInfoVO;
import com.imyiren.uop.vo.UserLoginVO;

import java.util.Objects;

/**
 * 用户对象操作转换器
 * @author yiren
 */
public abstract class UserConvertor {


    public static UserLoginVO toUserLoginVO(UserLoginDTO userLoginDTO) {
        if (Objects.isNull(userLoginDTO)) {
            return null;
        }
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setSessionId(userLoginDTO.getSessionId());
        return userLoginVO;

    }

    public static UserLoginCmd toUserLoginCmd(UserLoginRequest userLoginRequest) {
        if (Objects.isNull(userLoginRequest)) {
            return null;
        }
        UserLoginCmd userLoginCmd = new UserLoginCmd();
        userLoginCmd.setUsername(userLoginRequest.getUsername());
        userLoginCmd.setPassword(userLoginRequest.getPassword());
        userLoginCmd.setValidationKey(userLoginRequest.getValidationKey());
        userLoginCmd.setValidationCode(userLoginRequest.getValidationCode());
        return userLoginCmd;
    }

    public static UserInfoVO toUserInfoVO(UserSessionInfoDTO userSession) {
        if (Objects.isNull(userSession)) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(Objects.isNull(userSession.getUserId()) ? null : String.valueOf(userSession.getUserId()));
        userInfoVO.setRealName(userSession.getNickname());
        userInfoVO.setUsername(userSession.getUsername());
        userInfoVO.setPhone(userSession.getPhone());
        userInfoVO.setEmail(userSession.getEmail());
        userInfoVO.setState(userSession.getState());
        // userInfoVO.setStateDesc();
        userInfoVO.setRoleList(Lists.newArrayList("admin","user"));
        userInfoVO.setAvatarUrl("https://p.qqan.com/up/2021-2/16137992359659254.jpg");
        userInfoVO.setTitle("超级管理员");
        userInfoVO.setWorkNo(userSession.getCode());
        return userInfoVO;
    }

    public static UserCreateCmd toUserCreateCmd(UserRegisterRequest request) {
        if (Objects.isNull(request)) {
            return null;
        }
        UserCreateCmd userCreateCmd = new UserCreateCmd();
        userCreateCmd.setUsername(request.getUsername());
        userCreateCmd.setNickname(request.getNickname());
        userCreateCmd.setPhone(request.getPhone());
        userCreateCmd.setEmail(request.getEmail());
        userCreateCmd.setPassword(request.getPassword());
        userCreateCmd.setValidationKey(request.getValidationKey());
        userCreateCmd.setValidationCode(request.getValidationCode());
        return userCreateCmd;
    }
}
