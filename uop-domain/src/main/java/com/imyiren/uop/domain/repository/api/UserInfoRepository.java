package com.imyiren.uop.domain.repository.api;

import com.imyiren.uop.domain.repository.entity.UserDO;
import com.imyiren.uop.domain.repository.query.UserGetQuery;

import java.util.List;

/**
 * @author yiren
 */
public interface UserInfoRepository {

    /**
     * 用户单个信息查询
     *
     * @param query 查询参数
     * @return 用户信息
     */
    UserDO getByQuery(UserGetQuery query);


    /**
     * 用户列表信息查询
     *
     * @param query 用户信息查询参数
     * @return 用户信息列表
     */
    List<UserDO> listByQuery(UserGetQuery query);
}
