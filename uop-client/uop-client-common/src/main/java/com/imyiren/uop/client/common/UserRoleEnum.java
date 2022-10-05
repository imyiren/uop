package com.imyiren.uop.client.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum UserRoleEnum {
    /**
     * 权限
     */
    USER("user", "普通用户"),
    SALE("sale",  "销售人员"),
    EXPERIMENT("experiment", "实验相关人员"),

    ADMIN("admin", "管理员"),
    ;
    private final String code;
    private final String desc;

    public static boolean contain(String code) {
        return Arrays.stream(values()).anyMatch(elem -> elem.getCode().equals(code));
    }

    public static UserRoleEnum of(String code) {
        return Arrays.stream(values()).filter(elem -> elem.getCode().equals(code)).findFirst().orElse(null);
    }

    public static String title(List<String> roleList) {
        if (roleList.contains(ADMIN.getCode())) {
            return ADMIN.getDesc();
        }
        if (roleList.size() == 1) {
            return of(roleList.get(0)).getDesc();
        }
        if (roleList.contains(SALE.getCode()) && roleList.contains(EXPERIMENT.getCode())) {
            return "销售&实验人员";
        }
        return of(roleList.get(0)).getDesc();
    }

}
