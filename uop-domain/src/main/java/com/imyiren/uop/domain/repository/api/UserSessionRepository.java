package com.imyiren.uop.domain.repository.api;

import com.imyiren.uop.domain.repository.entity.UserSessionDO;
import com.imyiren.uop.domain.repository.query.UserSessionQuery;

public interface UserSessionRepository {

    /**
     * 获取用户session
     *
     * @param query 查询信息
     * @return session结果
     */
    UserSessionDO get(UserSessionQuery query);


    /**
     * 保存session
     *
     * @param userSession 保存session
     * @return session
     */
    UserSessionDO save(UserSessionDO userSession);


}
