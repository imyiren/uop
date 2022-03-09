package com.imyiren.uop.domain.repository.api;

import com.imyiren.uop.domain.repository.entity.StorageInfoDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadResultDO;
import com.imyiren.uop.domain.repository.query.StorageInfoQuery;

import java.util.List;

/**
 * @author yiren
 */
public interface StorageRepository {

    /**
     * 存储文件查询
     *
     * @param query 查询
     * @return 存储信息
     */
    StorageInfoDO get(StorageInfoQuery query);

    /**
     * 存储文件查询
     *
     * @param query 查询
     * @return 存储信息
     */
    List<StorageInfoDO> list(StorageInfoQuery query);

    /**
     * 保存
     *
     * @param storageInfo 文件信息
     * @return 文件信息
     */
    StorageInfoDO save(StorageInfoDO storageInfo);


    /**
     * 上传文件
     *
     * @param storageUpload 上传文件
     * @return 上传文件结果
     */
    StorageUploadResultDO upload(StorageUploadDO storageUpload);

    /**
     * 上传文件
     *
     * @param storageInfo 上传文件
     * @return 上传文件结果
     */
    boolean deleteRemoteFile(StorageInfoDO storageInfo);
}
