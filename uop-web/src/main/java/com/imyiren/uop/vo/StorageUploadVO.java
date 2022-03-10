package com.imyiren.uop.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class StorageUploadVO implements Serializable {
    private String code;

    private String filename;

    private String url;
}
