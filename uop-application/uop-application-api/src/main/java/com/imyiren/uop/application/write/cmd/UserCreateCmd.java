package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserCreateCmd implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

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
