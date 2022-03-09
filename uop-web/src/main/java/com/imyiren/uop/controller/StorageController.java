package com.imyiren.uop.controller;

import com.imyiren.result.BizResults;
import com.imyiren.result.base.Result;
import com.imyiren.uop.application.write.api.StorageAppService;
import com.imyiren.uop.application.write.dto.StorageFileUploadDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

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
        log.info(multipartFile.getOriginalFilename());
        InputStream inputStream = multipartFile.getInputStream();
        byte[] bytes = toByteArray(inputStream);
        // return BizResults.success(storageAppService.upload());
        StorageFileUploadDTO storageFileUploadDTO = new StorageFileUploadDTO();
        storageFileUploadDTO.setCode(UUID.randomUUID().toString());
        storageFileUploadDTO.setFilename(UUID.randomUUID().toString() + ".txt");
        storageFileUploadDTO.setUrl("https//asfda.fsadfdasf.com/sfa.txt");

        return BizResults.success(storageFileUploadDTO);
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
