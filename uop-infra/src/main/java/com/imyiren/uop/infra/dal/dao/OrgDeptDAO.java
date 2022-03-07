package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.OrgDeptPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yiren
 */
@Mapper
public interface OrgDeptDAO {

    int deleteByPrimaryKey(Long id);

    int insert(OrgDeptPO record);

    int insertSelective(OrgDeptPO record);

    OrgDeptPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrgDeptPO record);

    int updateByPrimaryKey(OrgDeptPO record);
}
