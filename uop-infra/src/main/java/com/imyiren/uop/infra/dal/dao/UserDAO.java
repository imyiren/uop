package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.infra.dal.po.UserPO;
import com.imyiren.uop.infra.dal.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yiren
 */
@Mapper
public interface UserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    UserPO getByQuery(UserQuery query);

    List<UserPO> listByQuery(UserQuery query);


    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);

}
