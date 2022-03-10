package com.imyiren.uop.controller;

import com.imyiren.result.BizResults;
import com.imyiren.result.base.Result;
import com.imyiren.uop.application.write.api.ValidationWriteAppService;
import com.imyiren.uop.application.write.cmd.ValidationPicCreateCmd;
import com.imyiren.uop.application.write.dto.ValidationPicDTO;
import com.imyiren.uop.vo.ValidationPicVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yiren
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/open/validation")
public class OpenValidationController {
    private final ValidationWriteAppService validationWriteAppService;

    @PostMapping("/pic")
    public Result get() {
        ValidationPicDTO validationPic = validationWriteAppService.createValidationPic(new ValidationPicCreateCmd());
        ValidationPicVO result = new ValidationPicVO();
        result.setPicKey(validationPic.getPicKey());
        result.setImgEncodeByBase64(validationPic.getImgEncodeByBase64());
        return BizResults.success(result);
    }

}
