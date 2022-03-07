package com.imyiren.uop.domain.support.api;

import com.imyiren.uop.domain.support.event.ValidateKeyAndCodeEvent;

/**
 * @author yiren
 */
public interface CommonValidationDomainService {


    /**
     * 校验验证码和code
     *
     * @param event  验证码Key和code事件
     * @return 是否成功
     */
    boolean validateKeyAndCode(ValidateKeyAndCodeEvent event);

}
