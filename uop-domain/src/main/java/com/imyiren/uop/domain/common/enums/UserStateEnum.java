package com.imyiren.uop.domain.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yiren
 */
@Getter
@AllArgsConstructor
public enum UserStateEnum {
    /**
     * 100-活跃 200-停用 300-注销
     */
    ACTIVE(100),
    FORBIDDEN(200),
    LOG_OFF(300),
    ;

    private final Integer code;



}
