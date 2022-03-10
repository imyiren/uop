package com.imyiren.uop.domain.user.event;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserSessionDelayEvent implements Serializable {

    private String sessionId;

}
