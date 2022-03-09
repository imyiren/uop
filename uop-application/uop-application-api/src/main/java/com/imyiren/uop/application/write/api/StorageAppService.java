package com.imyiren.uop.application.write.api;

import com.imyiren.uop.application.write.cmd.StorageFileUploadCmd;
import com.imyiren.uop.application.write.dto.StorageFileUploadDTO;

/**
 * @author yiren
 */
public interface StorageAppService {

    /**
     * 文件上传
     *
     * @param cmd 上传命令
     * @return 文件上传
     */
    StorageFileUploadDTO upload(StorageFileUploadCmd cmd);
}
