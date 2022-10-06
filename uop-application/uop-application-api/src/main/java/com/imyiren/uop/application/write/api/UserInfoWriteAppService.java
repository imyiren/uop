package com.imyiren.uop.application.write.api;

import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.write.cmd.*;
import com.imyiren.uop.application.write.dto.UserCreateDTO;
import com.imyiren.uop.application.write.dto.UserDelaySessionDTO;
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
     * @param cmd 登录命令
     * @return 登录结果
     */
    UserLoginDTO login(@Valid UserLoginCmd cmd);

    /**
     * 登出
     *
     * @param cmd sessionId
     * @return 是否成功
     */
    UserLogoutDTO logout(@Valid UserLogoutCmd cmd);


    /**
     * 初期创建用户需要 启用后才可以登录
     *
     * @param cmd 用户创建请求
     * @return 创建结果信息
     */
    UserCreateDTO createUser(UserCreateCmd cmd);


    /**
     * 延迟session过期时间
     *
     * @param cmd 延迟session过期
     * @return 延迟过期
     */
    UserDelaySessionDTO delaySessionExpire(UserDelaySessionExpireTimeCmd cmd);


    /**
     * 保存用户
     * @param userSaveCmd 用户保存
     * @return 用户信息
     */
    UserInfoDTO saveUser(UserSaveCmd userSaveCmd);
}
