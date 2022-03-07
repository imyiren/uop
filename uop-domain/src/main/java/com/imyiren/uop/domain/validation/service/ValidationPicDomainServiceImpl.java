package com.imyiren.uop.domain.validation.service;

import com.imyiren.uop.domain.validation.api.ValidationPicDomainService;
import com.imyiren.uop.domain.validation.event.ValidatePicKeyAndCodeEvent;
import org.springframework.stereotype.Service;

/**
 * @author yiren
 */
@Service
public class ValidationPicDomainServiceImpl implements ValidationPicDomainService {

    @Override
    public boolean validateKeyAndCode(ValidatePicKeyAndCodeEvent event) {
        return true;
    }

}
