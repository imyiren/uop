package com.imyiren.uop.application.write.api;

import com.imyiren.uop.application.write.cmd.UserCreateCmd;
import com.imyiren.uop.application.write.cmd.UserLoginCmd;
import com.imyiren.uop.application.write.cmd.UserLogoutCmd;
import com.imyiren.uop.application.write.dto.UserCreateDTO;
import com.imyiren.uop.application.write.dto.UserLoginDTO;
import com.imyiren.uop.application.write.dto.UserLogoutDTO;

import javax.validation.Valid;

/**
 * @author yiren
 */
public interface UserInfoWriteAppService {

    /**
     * 登录
     * 支持 手机号/邮箱/账号 登录
     *
     * @param userLoginCmd 登录命令
     * @return 登录结果
     */
    UserLoginDTO login(@Valid UserLoginCmd userLoginCmd);

    /**
     * 登出
     *
     * @param userLogoutCmd sessionId
     * @return 是否成功
     */
    UserLogoutDTO logout(@Valid UserLogoutCmd userLogoutCmd);


    /**
     * 创建用户
     *
     * @param userCreateCmd 用户
     * @return 结果
     */
    UserCreateDTO createUser(UserCreateCmd userCreateCmd);
}
