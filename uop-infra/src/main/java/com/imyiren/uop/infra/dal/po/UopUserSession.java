package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * uop_user_session
 * @author yiren
 */
@Data
public class UopUserSession implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * sessionId
     */
    private String sessionId;
    private String loginIp;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

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
