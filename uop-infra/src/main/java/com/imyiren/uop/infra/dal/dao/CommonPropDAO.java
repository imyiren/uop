package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.CommonPropPO;
import com.imyiren.uop.infra.dal.query.CommonPropQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yiren
 */
@Mapper
public interface CommonPropDAO {
    int deleteByPrimaryKey(Long id);

    int insert(CommonPropPO record);

    int insertSelective(CommonPropPO record);

    CommonPropPO selectByPrimaryKey(Long id);

    List<CommonPropPO> listByQuery(CommonPropQuery query);

    int updateByPrimaryKeySelective(CommonPropPO record);

    int updateByPrimaryKey(CommonPropPO record);
}
