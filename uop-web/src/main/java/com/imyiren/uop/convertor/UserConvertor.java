package com.imyiren.uop.convertor;

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

    public static UserInfoVO toUserInfoVO(UserInfoDTO userInfoDTO) {
        if (Objects.isNull(userInfoDTO)) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(Objects.isNull(userInfoDTO.getId()) ? null : String.valueOf(userInfoDTO.getId()));
        userInfoVO.setRealName(userInfoDTO.getRealName());
        userInfoVO.setUsername(userInfoDTO.getUsername());
        userInfoVO.setPhone(userInfoDTO.getPhone());
        userInfoVO.setEmail(userInfoDTO.getEmail());
        userInfoVO.setState(userInfoDTO.getState());
        userInfoVO.setStateDesc(userInfoDTO.getStateDesc());
        userInfoVO.setRoleList(userInfoDTO.getRoleList());
        userInfoVO.setAvatarUrl(userInfoDTO.getAvatarUrl());
        userInfoVO.setTitle(userInfoDTO.getTitle());
        userInfoVO.setWorkNo(userInfoDTO.getWorkNo());
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
