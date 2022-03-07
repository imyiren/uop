package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.domain.repository.query.UserSessionQuery;
import com.imyiren.uop.infra.dal.po.UopUserSession;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UopUserSessionDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UopUserSession record);

    int insertSelective(UopUserSession record);

    UopUserSession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UopUserSession record);

    int updateByPrimaryKey(UopUserSession record);

    /**
     * 获取单条session信息
     *
     * @param userSessionQuery 查询条件
     * @return session信息
     */
    UopUserSession get(UserSessionQuery userSessionQuery);
}
