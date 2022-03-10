package com.imyiren.uop.domain.validation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author yiren
 */

@Getter
@AllArgsConstructor
public enum ValidationPicStateEnum {
    /**
     * 100-已生成待验证 200-验证成功 300-失效
     */
    WAIT_VALIDATE(100, "待验证"),
    SUCCESS(200, "验证成功"),
    INVALID(300, "失效");
    private final Integer code;
    private final String desc;


    public static boolean contain(Integer code) {
        return Stream.of(values()).anyMatch(elem -> Objects.equals(code, elem.getCode()));
    }

    public static ValidationPicStateEnum of(Integer code) {
        return Stream.of(values()).filter(elem -> Objects.equals(elem.getCode(), code)).findFirst().orElse(null);
    }
}
