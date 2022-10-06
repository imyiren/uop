package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class UserSessionDO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * sessionId
     */
    private String sessionId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;


    private String loginIp;

    private LocalDateTime createTime;

}
