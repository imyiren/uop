package com.imyiren.uop.domain.support.event;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class ValidateKeyAndCodeEvent implements Serializable {

    /**
     * key
     */
    private String validationKey;

    /**
     * value
     */
    private String validationCode;

}
