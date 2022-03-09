package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class StorageFileUploadCmd implements Serializable {

    private byte[] data;

    private String filename;

}
