package com.imyiren.uop.domain.validation.service;

import com.imyiren.uop.domain.validation.api.CommonValidationDomainService;
import com.imyiren.uop.domain.validation.event.ValidateKeyAndCodeEvent;
import org.springframework.stereotype.Service;

/**
 * @author yiren
 */
@Service
public class ValidationDomainServiceImpl implements CommonValidationDomainService {

    @Override
    public boolean validateKeyAndCode(ValidateKeyAndCodeEvent event) {
        return true;
    }
}
