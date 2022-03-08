package com.imyiren.uop.application.write;

import com.imyiren.uop.application.write.api.UserInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.UserCreateCmd;
import com.imyiren.uop.application.write.cmd.UserLoginCmd;
import com.imyiren.uop.application.write.cmd.UserLogoutCmd;
import com.imyiren.uop.application.write.dto.UserCreateDTO;
import com.imyiren.uop.application.write.dto.UserLoginDTO;
import com.imyiren.uop.application.write.dto.UserLogoutDTO;
import com.imyiren.uop.domain.validation.api.ValidationPicDomainService;
import com.imyiren.uop.domain.validation.event.ValidatePicKeyAndCodeEvent;
import com.imyiren.uop.domain.user.api.UserAuthDomainService;
import com.imyiren.uop.domain.user.event.CreateUserSessionEvent;
import com.imyiren.uop.domain.user.event.DeleteUserSessionEvent;
import com.imyiren.result.BizStateCodes;
import com.imyiren.result.error.BizRuntimeException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author yiren
 */
@Slf4j
@DubboService
@AllArgsConstructor
public class UserInfoWriteAppServiceImpl implements UserInfoWriteAppService {

    private final UserAuthDomainService userAuthDomainService;

    private final ValidationPicDomainService validationPicDomainService;

    @Override
    public UserLoginDTO login(UserLoginCmd cmd) {
        // 校验验证码
        ValidatePicKeyAndCodeEvent validatePicKeyAndCodeEvent = new ValidatePicKeyAndCodeEvent();
        validatePicKeyAndCodeEvent.setValidationKey(cmd.getValidationKey());
        validatePicKeyAndCodeEvent.setValidationCode(cmd.getValidationCode());
        boolean valid = validationPicDomainService.validateKeyAndCode(validatePicKeyAndCodeEvent);
        if (!valid) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "验证码校验失败，请刷新后重试！");
        }

        // 获取用户sessionId
        CreateUserSessionEvent createUserSessionEvent = new CreateUserSessionEvent();
        createUserSessionEvent.setUsername(cmd.getUsername());
        createUserSessionEvent.setPassword(cmd.getPassword());
        String userSessionId = userAuthDomainService.createUserSession(createUserSessionEvent);
        if (StringUtils.isEmpty(userSessionId)) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "用户名或密码错误，请重试！");
        }

        // 封装结果
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setSessionId(userSessionId);
        return userLoginDTO;
    }

    @Override
    public UserLogoutDTO logout(UserLogoutCmd cmd) {
        DeleteUserSessionEvent deleteUserSessionEvent = new DeleteUserSessionEvent();
        deleteUserSessionEvent.setSessionId(cmd.getSessionId());
        boolean result = userAuthDomainService.expireSession(deleteUserSessionEvent);

        UserLogoutDTO userLogoutDTO = new UserLogoutDTO();
        userLogoutDTO.setSuccess(result);
        return userLogoutDTO;
    }

    @Override
    public UserCreateDTO createUser(UserCreateCmd cmd) {
        // 校验验证码
        ValidatePicKeyAndCodeEvent validatePicKeyAndCodeEvent = new ValidatePicKeyAndCodeEvent();
        validatePicKeyAndCodeEvent.setValidationKey(cmd.getValidationKey());
        validatePicKeyAndCodeEvent.setValidationCode(cmd.getValidationCode());
        boolean valid = validationPicDomainService.validateKeyAndCode(validatePicKeyAndCodeEvent);
        if (!valid) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "验证码校验失败，请刷新后重试！");
        }

        return null;
    }


}
