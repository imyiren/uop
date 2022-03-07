package com.imyiren.uop.application.read.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserInfoGetByValidSessionQuery implements Serializable {

    private String sessionId;
}
