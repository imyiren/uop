package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * user
 * @author
 */
@Data
public class UserPO implements Serializable {
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
     * 加密后的密码
     */
    private String encryptedPwd;

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

    private static final long serialVersionUID = 1L;
}
