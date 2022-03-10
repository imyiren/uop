package com.imyiren.uop.application.write;

import com.imyiren.uop.application.write.api.ValidationWriteAppService;
import com.imyiren.uop.application.write.cmd.ValidationPicCreateCmd;
import com.imyiren.uop.application.write.dto.ValidationPicDTO;
import com.imyiren.uop.domain.repository.entity.ValidationPicDO;
import com.imyiren.uop.domain.validation.api.ValidationPicDomainService;
import com.imyiren.uop.domain.validation.event.ValidationPicCreateEvent;
import com.imyiren.uop.domain.validation.utils.KaptchaUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yiren
 */
@Slf4j
@Service
@AllArgsConstructor
public class ValidationAppServiceImpl implements ValidationWriteAppService {

    private final ValidationPicDomainService validationPicDomainService;


    @Override
    public ValidationPicDTO createValidationPic(ValidationPicCreateCmd cmd) {
        // 1. 生成图片验证码
        KaptchaUtils.PicInfo picInfo = KaptchaUtils.newValidationPic();

        // 2. 保存到数据库
        ValidationPicCreateEvent event = new ValidationPicCreateEvent();
        event.setPicCode(picInfo.getCode());
        ValidationPicDO validationPicDO = validationPicDomainService.create(event);

        // 3. 组合结果
        ValidationPicDTO validationPic = new ValidationPicDTO();
        validationPic.setId(validationPicDO.getId());
        validationPic.setPicKey(validationPicDO.getPicKey());
        validationPic.setImgEncodeByBase64(picInfo.getImgBase64());
        return validationPic;
    }

}
