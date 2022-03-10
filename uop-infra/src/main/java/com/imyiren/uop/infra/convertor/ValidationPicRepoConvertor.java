package com.imyiren.uop.infra.convertor;

import com.imyiren.uop.domain.repository.entity.ValidationPicDO;
import com.imyiren.uop.infra.dal.po.UopValidationPic;

/**
 * @author yiren
 */
public final class ValidationPicRepoConvertor {

    public static ValidationPicDO toValidationPicDO(UopValidationPic validationPic) {
        ValidationPicDO validationPicDO = new ValidationPicDO();
        validationPicDO.setId(validationPic.getId());
        validationPicDO.setPicKey(validationPic.getPicKey());
        validationPicDO.setPicCode(validationPic.getPicCode());
        validationPicDO.setState(validationPic.getState());
        validationPicDO.setDeleted(validationPic.getDeleted());
        validationPicDO.setCreateTime(validationPic.getCreateTime());
        validationPicDO.setUpdateTime(validationPic.getUpdateTime());
        return validationPicDO;
    }
    public static UopValidationPic toUopValidationPic(ValidationPicDO validationPic) {
        UopValidationPic result = new UopValidationPic();
        result.setPicKey(validationPic.getPicKey());
        result.setPicCode(validationPic.getPicCode());
        result.setId(validationPic.getId());
        result.setDeleted(validationPic.getDeleted());
        result.setCreateTime(validationPic.getCreateTime());
        result.setState(validationPic.getState());
        result.setUpdateTime(validationPic.getUpdateTime());
        return result;
    }
}
