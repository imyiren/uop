package com.imyiren.uop.convertor;

import com.google.common.collect.Lists;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.write.cmd.UserCreateCmd;
import com.imyiren.uop.application.write.cmd.UserLoginCmd;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.write.cmd.UserSaveCmd;
import com.imyiren.uop.application.write.dto.UserLoginDTO;
import com.imyiren.uop.client.common.UserRoleEnum;
import com.imyiren.uop.request.UserLoginRequest;
import com.imyiren.uop.request.UserRegisterRequest;
import com.imyiren.uop.request.UserSavePasswordRequest;
import com.imyiren.uop.request.UserSaveRequest;
import com.imyiren.uop.vo.UserInfoVO;
import com.imyiren.uop.vo.UserLoginVO;

import java.util.Objects;

/**
 * 用户对象操作转换器
 *
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
        userInfoVO.setStateDesc(userSession.getStateDesc());
        userInfoVO.setRoleList(userSession.getRoleList());
        userInfoVO.setAvatarUrl("https://p.qqan.com/up/2021-2/16137992359659254.jpg");
        userInfoVO.setTitle(UserRoleEnum.title(userSession.getRoleList()));
        userInfoVO.setWorkNo(userSession.getCode());
        userInfoVO.setCreateTime(userSession.getCreateTime());
        return userInfoVO;
    }

    public static UserInfoVO toUserInfoVO(UserInfoDTO userInfoDTO) {
        if (Objects.isNull(userInfoDTO)) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(Objects.isNull(userInfoDTO.getId()) ? null : String.valueOf(userInfoDTO.getId()));
        userInfoVO.setRealName(userInfoDTO.getNickname());
        userInfoVO.setUsername(userInfoDTO.getUsername());
        userInfoVO.setPhone(userInfoDTO.getPhone());
        userInfoVO.setEmail(userInfoDTO.getEmail());
        userInfoVO.setState(userInfoDTO.getState());
        userInfoVO.setStateDesc(userInfoDTO.getStateDesc());
        userInfoVO.setRoleList(userInfoDTO.getRoleList());
        userInfoVO.setAvatarUrl("https://p.qqan.com/up/2021-2/16137992359659254.jpg");
        userInfoVO.setTitle(UserRoleEnum.title(userInfoDTO.getRoleList()));
        userInfoVO.setWorkNo(userInfoDTO.getCode());
        userInfoVO.setCreateTime(userInfoDTO.getCreateTime());
        userInfoVO.setLoginIp(userInfoDTO.getLoginIp());
        userInfoVO.setLoginTime(userInfoDTO.getLoginTime());
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

    public static UserSaveCmd toUserSaveCmd(UserSaveRequest request) {
        UserSaveCmd userSaveCmd = new UserSaveCmd();
        userSaveCmd.setId(request.getId());
        userSaveCmd.setNickname(request.getRealName());
        userSaveCmd.setUsername(request.getUsername());
        userSaveCmd.setPassword(request.getPassword());
        userSaveCmd.setState(request.getState());
        userSaveCmd.setRoleList(request.getRoleList());
        return userSaveCmd;
    }

    public static UserSaveCmd toUserSaveCmd(UserSavePasswordRequest request) {
        UserSaveCmd userSaveCmd = new UserSaveCmd();
        userSaveCmd.setId(request.getId());
        userSaveCmd.setPassword(request.getNewPassword());
        return userSaveCmd;
    }


}
