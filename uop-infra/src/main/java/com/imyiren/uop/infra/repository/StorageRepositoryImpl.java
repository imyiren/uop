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
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.apache.commons.codec.CharEncoding.UTF_8;

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
        StorageUploadResultDO upload = uopOssClient.upload(storageUpload);
        try {
            if (!StringUtils.isEmpty(upload)) {
                String encodeName = URLEncoder.encode(upload.getFilename(), StandardCharsets.UTF_8.toString());
                upload.setUrl(upload.getUrl().replace(upload.getFilename(), encodeName));
            }
        } catch (UnsupportedEncodingException e) {
            //
            log.error("upload: error: ", e);
        }
        return upload;
    }

    @Override
    public boolean deleteRemoteFile(StorageInfoDO storageInfo) {
        return uopOssClient.delete(storageInfo);
    }

}
