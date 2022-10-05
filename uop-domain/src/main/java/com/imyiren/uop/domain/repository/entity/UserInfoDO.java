package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class UserInfoDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

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

    private UserExtraInfoDO extraInfo = new UserExtraInfoDO();

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
