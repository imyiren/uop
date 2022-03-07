package com.imyiren.uop.application.read.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserGetQuery implements Serializable {

    private String sessionId;

    private String username;

    private Long id;

    private String phone;

    private String email;

}
