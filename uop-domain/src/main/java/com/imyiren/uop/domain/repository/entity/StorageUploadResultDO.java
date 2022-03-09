package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class StorageUploadResultDO implements Serializable {

    private Boolean success;

    private String url;

    private String filename;

    private String code;

}
