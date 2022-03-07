package com.imyiren.uop.infra.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeleteEnum {
    /**
     * 已删除
     */
    DELETED(1),
    /**
     * 未删除
     */
    NOT_DELETED(2),

    ;

    private final Integer code;
}
