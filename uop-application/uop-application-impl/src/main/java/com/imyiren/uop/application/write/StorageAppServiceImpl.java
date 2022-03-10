package com.imyiren.uop.application.write;

import com.imyiren.uop.application.write.api.StorageAppService;
import com.imyiren.uop.application.write.cmd.StorageFileUploadCmd;
import com.imyiren.uop.application.write.dto.StorageFileUploadDTO;
import com.imyiren.uop.domain.repository.api.StorageRepository;
import com.imyiren.uop.domain.repository.entity.StorageUploadDO;
import com.imyiren.uop.domain.repository.entity.StorageUploadResultDO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author yiren
 */
@Slf4j
@Service
@AllArgsConstructor
public class StorageAppServiceImpl implements StorageAppService {
    private StorageRepository storageRepository;

    @Override
    public StorageFileUploadDTO upload(StorageFileUploadCmd cmd) {
        StorageUploadDO storageUploadDO = new StorageUploadDO();
        storageUploadDO.setData(cmd.getData());
        storageUploadDO.setFilename(cmd.getFilename());
        StorageUploadResultDO upload = storageRepository.upload(storageUploadDO);
        StorageFileUploadDTO result = new StorageFileUploadDTO();
        result.setCode(upload.getCode());
        result.setFilename(upload.getFilename());
        result.setUrl(upload.getUrl());
        return result;
    }

}
