package com.huaysw.crm.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginVO implements Serializable {
    private String sessionId;
}
