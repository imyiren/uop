package com.imyiren.uop.domain.validation.event;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class ValidatePicKeyAndCodeEvent implements Serializable {

    /**
     * key
     */
    private String validationKey;

    /**
     * value
     */
    private String validationCode;

}
