package com.imyiren.uop.domain.support.service;

import com.imyiren.uop.domain.support.api.CommonValidationDomainService;
import org.springframework.stereotype.Service;

/**
 * @author yiren
 */
@Service
public class CommonValidationDomainServiceImpl implements CommonValidationDomainService {

    @Override
    public boolean validateKeyAndCode(String key, String code) {
        return true;
    }
}
