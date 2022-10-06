package com.imyiren.uop.domain.user.event;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class CreateUserSessionEvent implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    private String loginIp;
}
