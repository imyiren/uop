package com.imyiren.uop.application.read.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserGetQuery implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 用户名 创建用户 默认使用手机号
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private Integer state;

}
