package com.imyiren.uop.domain.repository.api;

import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;

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
    UserInfoDO get(UserInfoQuery query);


    /**
     * 用户列表信息查询
     *
     * @param query 用户信息查询参数
     * @return 用户信息列表
     */
    List<UserInfoDO> list(UserInfoQuery query);


    /**
     * 保存 带ID就update 不带就insert
     *
     * @param userInfoDO 保存
     * @return 保存结果 如果是insert就返回带ID带对象
     */
    UserInfoDO save(UserInfoDO userInfoDO);

}
