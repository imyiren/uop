package com.imyiren.uop.application.read.api;

import com.imyiren.application.api.dto.PageDTO;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.read.query.UserGetQuery;
import com.imyiren.uop.application.read.query.UserInfoGetByValidSessionQuery;
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
    UserInfoDTO get(UserGetQuery userGetQuery);


    /**
     * 通过SessionId获取用户和session信息
     * @param query 查询参数
     * @return 用户信息及session信息
     */
    UserSessionInfoDTO getByValidSession(UserInfoGetByValidSessionQuery query);

}
