package com.imyiren.uop.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserInfoVO implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;
    private String workNo;

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
    private String stateDesc;


    private String avatarUrl;
    private String title;
    /**
     * 角色信息
     */
    private List<String> roleList;


    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
