package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDelaySessionExpireTimeCmd implements Serializable {

    /**
     * 会话信息
     */
    private String sessionId;
}
