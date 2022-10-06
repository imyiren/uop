package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
public class UserLoginCmd implements Serializable {
    /**
     * 用户名
     */
    @NotEmpty(message = "账号不能为空！")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空！")
    private String password;

    /**
     * 验证码key
     */
    @NotEmpty(message = "验证码校验错误！")
    private String validationKey;

    /**
     * 验证码Code
     */
    @NotEmpty(message = "验证码不能为空！")
    private String validationCode;


    private String loginIp;
}
