package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * uop_user
 * @author 
 */
@Data
public class UopUser implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 全局唯一编码
     */
    private Integer code;

    /**
     * 用户名
     */
    private Integer username;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 邮箱
     */
    private Integer email;

    /**
     * 加密后的密码
     */
    private Integer encryptedPwd;

    /**
     * 昵称
     */
    private Integer nickname;

    /**
     * 用户账号状态 100-正常 200-停用 300-注销
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