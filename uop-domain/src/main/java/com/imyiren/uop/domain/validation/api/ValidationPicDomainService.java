package com.imyiren.uop.domain.validation.api;

import com.imyiren.uop.domain.validation.event.ValidatePicKeyAndCodeEvent;

/**
 * @author yiren
 */
public interface ValidationPicDomainService {


    /**
     * 校验验证码和code
     *
     * @param event  验证码Key和code事件
     * @return 是否成功
     */
    boolean validateKeyAndCode(ValidatePicKeyAndCodeEvent event);

}
