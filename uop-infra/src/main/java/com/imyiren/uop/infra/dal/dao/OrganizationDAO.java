package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.OrganizationPO;

public interface OrganizationDAO {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationPO record);

    int insertSelective(OrganizationPO record);

    OrganizationPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationPO record);

    int updateByPrimaryKey(OrganizationPO record);
}
