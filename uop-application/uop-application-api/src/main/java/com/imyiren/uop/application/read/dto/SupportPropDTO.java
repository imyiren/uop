package com.imyiren.uop.application.read.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class SupportPropDTO implements Serializable {

    /**
     * 参数编码
     */
    private String code;

    /**
     * KEY 会有一对多的场景
     */
    private String key;

    /**
     * 值
     */
    private String value;



}
