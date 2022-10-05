package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.infra.dal.po.UopUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UopUserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UopUser record);

    int insertSelective(UopUser record);

    UopUser selectByPrimaryKey(Long id);

    List<UopUser> selectByQuery(UserInfoQuery query);

    UopUser selectOneByQuery(UserInfoQuery query);

    int updateByPrimaryKeySelective(UopUser record);

    int updateByPrimaryKey(UopUser record);
}