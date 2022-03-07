package com.imyiren.uop.application.read.api;

import com.imyiren.uop.application.base.PageDTO;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.query.UserListPageQuery;

/**
 * @author yiren
 */
public interface UserInfoReadAppService {

    /**
     * 分页查询用户信息
     *
     * @param userListPageQuery 用户信息查询
     * @return 用户信息分页信息
     */
    PageDTO<UserInfoDTO> listPageByQuery(UserListPageQuery userListPageQuery);

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    UserInfoDTO getBySessionId(String sessionId);

}
