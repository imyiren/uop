package com.imyiren.uop.application.read.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yiren
 */
@Data
public class UserInfoDTO implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 工号
     */
    private String workNo;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮件
     */
    private String email;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 状态描述
     */
    private String stateDesc;

    /**
     * 头像
     */
    private String avatarUrl;
    private String title;

    /**
     * 角色信息
     */
    private List<String> roleList;

}
