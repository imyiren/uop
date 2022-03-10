package com.imyiren.uop.domain.validation.service;

import com.imyiren.result.BizStateCodes;
import com.imyiren.result.error.BizRuntimeException;
import com.imyiren.uop.domain.repository.api.ValidationPicRepository;
import com.imyiren.uop.domain.repository.entity.ValidationPicDO;
import com.imyiren.uop.domain.repository.query.ValidationPicQuery;
import com.imyiren.uop.domain.validation.api.ValidationPicDomainService;
import com.imyiren.uop.domain.validation.enums.ValidationPicStateEnum;
import com.imyiren.uop.domain.validation.event.ValidatePicKeyAndCodeEvent;
import com.imyiren.uop.domain.validation.event.ValidationPicCreateEvent;
import com.imyiren.utils.common.UuidUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author yiren
 */
@Slf4j
@Service
@AllArgsConstructor
public class ValidationPicDomainServiceImpl implements ValidationPicDomainService {

    private final ValidationPicRepository validationPicRepository;

    @Override
    public boolean validateKeyAndCode(ValidatePicKeyAndCodeEvent event) {
        ValidationPicQuery query = new ValidationPicQuery();
        query.setPicKey(event.getPicKey());
        query.setState(ValidationPicStateEnum.WAIT_VALIDATE.getCode());
        ValidationPicDO validationPicDO = validationPicRepository.get(query);
        if (Objects.isNull(validationPicDO)) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "验证码失效，请重试！");
        }

        if (!Objects.equals(validationPicDO.getPicCode(), event.getPicCode())) {
            throw new BizRuntimeException(BizStateCodes.BIZ_ERROR, "验证码错误，请重试！");
        }
        return true;
    }

    @Override
    public ValidationPicDO create(ValidationPicCreateEvent event) {
        ValidationPicDO validationPicDO = new ValidationPicDO();
        validationPicDO.setPicKey(UuidUtils.generate());
        validationPicDO.setPicCode(event.getPicCode());
        validationPicDO.setState(ValidationPicStateEnum.WAIT_VALIDATE.getCode());
        return validationPicRepository.create(validationPicDO);
    }

}
