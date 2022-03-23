package com.imyiren.uop.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class StorageUploadVO implements Serializable {
    private String code;

    private String name;

    private String url;
}
