package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.OrgEmployeeInfoPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yiren
 */
@Mapper
public interface OrgEmployeeInfoDAO {
    int deleteByPrimaryKey(Long id);

    int insert(OrgEmployeeInfoPO record);

    int insertSelective(OrgEmployeeInfoPO record);

    OrgEmployeeInfoPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrgEmployeeInfoPO record);

    int updateByPrimaryKey(OrgEmployeeInfoPO record);
}
