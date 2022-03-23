package com.imyiren.uop.controller;

import com.imyiren.result.BizResults;
import com.imyiren.result.base.Result;
import com.imyiren.uop.application.write.api.StorageAppService;
import com.imyiren.uop.application.write.cmd.StorageFileUploadCmd;
import com.imyiren.uop.application.write.dto.StorageFileUploadDTO;
import com.imyiren.uop.client.common.UserContext;
import com.imyiren.uop.vo.StorageUploadVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yiren
 */
@Slf4j
@RestController
@AllArgsConstructor
public class StorageController {
    private final StorageAppService storageAppService;

    @RequestMapping("/storage/upload")
    public Result upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        log.info("upload: filename: {}, userId: {}", multipartFile.getOriginalFilename(), UserContext.getUserId());
        InputStream inputStream = multipartFile.getInputStream();
        byte[] bytes = toByteArray(inputStream);
        StorageFileUploadCmd storageFileUploadCmd = new StorageFileUploadCmd();
        storageFileUploadCmd.setData(bytes);
        storageFileUploadCmd.setFilename(multipartFile.getOriginalFilename());
        StorageFileUploadDTO upload = storageAppService.upload(storageFileUploadCmd);

        // 结果转换
        StorageUploadVO storageUploadVO = new StorageUploadVO();
        storageUploadVO.setCode(upload.getCode());
        storageUploadVO.setName(upload.getFilename());
        storageUploadVO.setUrl(upload.getUrl());
        return BizResults.success(storageUploadVO);
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

}
