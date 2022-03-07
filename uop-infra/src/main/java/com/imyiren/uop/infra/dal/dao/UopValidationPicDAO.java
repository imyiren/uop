package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.UopValidationPic;

public interface UopValidationPicDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UopValidationPic record);

    int insertSelective(UopValidationPic record);

    UopValidationPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UopValidationPic record);

    int updateByPrimaryKey(UopValidationPic record);
}
