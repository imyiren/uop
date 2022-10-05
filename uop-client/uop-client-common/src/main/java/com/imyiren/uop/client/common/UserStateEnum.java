package com.imyiren.uop.client.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author yiren
 */
@Getter
@AllArgsConstructor
public enum UserStateEnum {
    /**
     * 100-活跃 200-停用 300-注销
     */
    ACTIVE(100, "启用中"),
    FORBIDDEN(200, "停用中"),
    LOG_OFF(300, "已注销"),
    ;

    private final Integer code;
    private final String desc;


    public static boolean contain(Integer code) {
        return Arrays.stream(values()).anyMatch(elem -> elem.getCode().equals(code));
    }

    public static UserStateEnum of(Integer code) {
        return Arrays.stream(values()).filter(elem -> elem.getCode().equals(code)).findFirst().orElse(null);
    }

}
