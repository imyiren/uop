package com.imyiren.uop.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserRegisterVO implements Serializable {

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
     * 用户编码
     */
    private String code;

}
