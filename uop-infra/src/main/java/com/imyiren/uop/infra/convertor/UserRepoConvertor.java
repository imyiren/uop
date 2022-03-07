package com.imyiren.uop.infra.convertor;


import com.imyiren.uop.domain.repository.entity.UserDO;
import com.imyiren.uop.domain.repository.query.UserGetQuery;
import com.imyiren.uop.domain.repository.query.UserListQuery;
import com.imyiren.uop.infra.dal.po.UserPO;
import com.imyiren.uop.infra.dal.query.UserQuery;

import java.util.Objects;

/**
 * @author yiren
 */
public abstract class UserRepoConvertor {

    public static UserDO toUserDO(UserPO user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setId(user.getId());
        userDO.setCode(user.getCode());
        userDO.setUsername(user.getUsername());
        userDO.setEncryptedPwd(user.getEncryptedPwd());
        userDO.setPhone(user.getPhone());
        userDO.setEmail(user.getEmail());
        userDO.setState(user.getState());
        userDO.setDeleted(user.getDeleted());
        userDO.setCreateTime(user.getCreateTime());
        userDO.setUpdateTime(user.getUpdateTime());
        return userDO;
    }

    public static UserQuery toUserQuery(UserGetQuery query) {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(query.getId());
        userQuery.setCode(query.getCode());
        userQuery.setUsername(query.getUsername());
        userQuery.setPhone(query.getPhone());
        userQuery.setEmail(query.getEmail());
        userQuery.setState(query.getState());
        return userQuery;
    }

    public static UserListQuery toUserQuery(UserListQuery query) {
        UserListQuery userListQuery = new UserListQuery();
        userListQuery.setCode(query.getCode());
        userListQuery.setId(query.getId());
        userListQuery.setEncryptedPwd(query.getEncryptedPwd());
        userListQuery.setUsername(query.getUsername());
        userListQuery.setEmail(query.getEmail());
        userListQuery.setPhone(query.getPhone());
        userListQuery.setDeleted(query.getDeleted());
        userListQuery.setCreateTime(query.getCreateTime());
        userListQuery.setState(query.getState());
        userListQuery.setCreateTimeEnd(query.getCreateTimeEnd());
        userListQuery.setUpdateTime(query.getUpdateTime());
        userListQuery.setUpdateTimeStart(query.getUpdateTimeStart());
        userListQuery.setCreateTimeStart(query.getCreateTimeStart());
        userListQuery.setUpdateTimeEnd(query.getUpdateTimeEnd());
        return userListQuery;

    }

}
