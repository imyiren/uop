package com.imyiren.uop.infra.repository;

import com.imyiren.uop.domain.repository.api.StorageRepository;
import com.imyiren.uop.domain.repository.entity.StorageInfoDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadResultDO;
import com.imyiren.uop.domain.repository.query.StorageInfoQuery;
import com.imyiren.uop.infra.oss.client.UopOssClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class StorageRepositoryImpl implements StorageRepository {

    private final UopOssClient uopOssClient;

    @Override
    public StorageInfoDO get(StorageInfoQuery query) {
        return null;
    }

    @Override
    public List<StorageInfoDO> list(StorageInfoQuery query) {
        return null;
    }

    @Override
    public StorageInfoDO save(StorageInfoDO storageInfo) {
        return null;
    }

    @Override
    public StorageUploadResultDO upload(StorageUploadDO storageUpload) {
        return uopOssClient.upload(storageUpload);
    }

    @Override
    public boolean deleteRemoteFile(StorageInfoDO storageInfo) {
        return uopOssClient.delete(storageInfo);
    }

}
