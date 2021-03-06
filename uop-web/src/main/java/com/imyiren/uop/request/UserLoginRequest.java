package com.imyiren.uop.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
     * 用户名支持：用户名/手机/邮箱登录
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码键
     */
    private String validationKey;

    /**
     * 验证码值
     */
    private String validationCode;
}
