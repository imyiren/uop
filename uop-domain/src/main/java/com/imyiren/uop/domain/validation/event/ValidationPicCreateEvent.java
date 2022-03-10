package com.imyiren.uop.domain.validation.event;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class ValidationPicCreateEvent implements Serializable {

    /**
     * 校验码
     */
    private String picCode;

}
