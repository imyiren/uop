package com.imyiren.uop.application.write.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class StorageFileUploadDTO implements Serializable {

    private String code;

    private String filename;

    private String url;

}
