package com.imyiren.uop.application.read.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yiren
 */
@Data
public class UserSessionInfoDTO implements Serializable {

    /**
     * sessionId
     */
    private String sessionId;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 全局唯一编码
     */
    private String code;

    /**
     * 用户名
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
     * 加密后的密码
     */
    private String encryptedPwd;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户账号状态 100-正常 200-停用 300-注销
     */
    private Integer state;
    private String stateDesc;

    private List<String> roleList;
    /**
     * 删除状态 1-删除 2-未删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
