package com.imyiren.uop.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class SupportPropVO implements Serializable {

    /**
     * 唯一code
     */
    private String code;

    /**
     * key
     */
    private String key;

    /**
     * value
     */
    private String value;

}
