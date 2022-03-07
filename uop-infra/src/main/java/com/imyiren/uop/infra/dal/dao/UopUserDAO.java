package com.imyiren.uop.infra.dal.dao;

import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.infra.dal.po.UopUser;

import java.util.List;

public interface UopUserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UopUser record);

    int insertSelective(UopUser record);

    UopUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UopUser record);

    int updateByPrimaryKey(UopUser record);

    /**
     * 单个查询
     *
     * @param userInfoQuery 查询参数
     * @return 单个结果
     */
    UopUser getByQuery(UserInfoQuery userInfoQuery);

    /**
     * 批量查询
     * @param userInfoQuery 查询参数
     * @return 列表结果
     */
    List<UopUser> listByQuery(UserInfoQuery userInfoQuery);
}
