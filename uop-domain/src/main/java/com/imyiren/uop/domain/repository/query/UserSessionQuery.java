package com.imyiren.uop.domain.repository.query;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class UserSessionQuery implements Serializable {

    /**
     * sessionId
     */
    private String sessionId;

    /**
     * 用户ID
     */
    private String userId;

    private LocalDateTime expireTimeStart;

    private LocalDateTime expireTimeEnd;

    /**
     * 是否删除
     */
    private Integer deleted;

}
