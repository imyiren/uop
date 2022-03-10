package com.imyiren.uop.domain.validation.api;

import com.imyiren.uop.domain.repository.entity.ValidationPicDO;
import com.imyiren.uop.domain.validation.event.ValidatePicKeyAndCodeEvent;
import com.imyiren.uop.domain.validation.event.ValidationPicCreateEvent;

/**
 * @author yiren
 */
public interface ValidationPicDomainService {


    /**
     * 校验验证码和code
     *
     * @param event 验证码Key和code事件
     * @return 是否成功
     */
    boolean validateKeyAndCode(ValidatePicKeyAndCodeEvent event);


    /**
     * 创建图片验证码
     *
     * @param event 验证图片创建事件
     * @return 验证码创建结果
     */
    ValidationPicDO create(ValidationPicCreateEvent event);

}
