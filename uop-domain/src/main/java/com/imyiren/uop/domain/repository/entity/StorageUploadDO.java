package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StorageUploadDO implements Serializable {

    /**
     * 字节数组
     */
    private byte[] data;

    /**
     * 文件名称
     */
    private String filename;

}
