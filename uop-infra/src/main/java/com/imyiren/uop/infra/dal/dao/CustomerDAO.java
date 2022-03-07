package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.CustomerPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yiren
 */
@Mapper
public interface CustomerDAO {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerPO record);

    int insertSelective(CustomerPO record);

    CustomerPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerPO record);

    int updateByPrimaryKey(CustomerPO record);
}
