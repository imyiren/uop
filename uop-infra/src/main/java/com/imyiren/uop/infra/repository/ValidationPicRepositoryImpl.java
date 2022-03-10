package com.imyiren.uop.infra.repository;

import com.imyiren.uop.domain.repository.api.ValidationPicRepository;
import com.imyiren.uop.domain.repository.entity.ValidationPicDO;
import com.imyiren.uop.domain.repository.query.ValidationPicQuery;
import com.imyiren.uop.infra.convertor.ValidationPicRepoConvertor;
import com.imyiren.uop.infra.dal.dao.UopValidationPicDAO;
import com.imyiren.uop.infra.dal.po.UopValidationPic;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author yiren
 */
@Slf4j
@Repository
@AllArgsConstructor
public class ValidationPicRepositoryImpl implements ValidationPicRepository {

    private final UopValidationPicDAO uopValidationPicDAO;


    @Override
    public ValidationPicDO save(ValidationPicDO validationPicDO) {
        if (Objects.isNull(validationPicDO)) {
            return null;
        }
        UopValidationPic uopValidationPic = ValidationPicRepoConvertor.toUopValidationPic(validationPicDO);
        if (Objects.nonNull(validationPicDO.getId())) {
            uopValidationPicDAO.updateByPrimaryKeySelective(uopValidationPic);
            return validationPicDO;
        }

        uopValidationPicDAO.insertSelective(uopValidationPic);
        validationPicDO.setId(uopValidationPic.getId());
        return validationPicDO;
    }

    @Override
    public ValidationPicDO get(ValidationPicQuery query) {
        if (Objects.isNull(query)) {
            return null;
        }
        UopValidationPic uopValidationPic = uopValidationPicDAO.get(query);
        if (Objects.isNull(uopValidationPic)) {
            return null;
        }
        return ValidationPicRepoConvertor.toValidationPicDO(uopValidationPic);
    }

}
