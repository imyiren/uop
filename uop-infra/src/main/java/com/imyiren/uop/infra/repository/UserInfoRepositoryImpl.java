package com.imyiren.uop.infra.repository;

import com.google.common.collect.Lists;
import com.imyiren.uop.infra.dal.dao.UserDAO;
import com.imyiren.uop.infra.enums.DeleteEnum;
import com.imyiren.uop.domain.repository.entity.UserDO;
import com.imyiren.uop.infra.convertor.UserRepoConvertor;
import com.imyiren.uop.domain.repository.query.UserGetQuery;
import com.imyiren.uop.domain.repository.api.UserInfoRepository;
import com.imyiren.uop.infra.dal.po.UserPO;
import com.imyiren.uop.infra.dal.query.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yiren
 */
@Repository
@AllArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepository {

    private final UserDAO userDAO;

    @Override
    public UserDO getByQuery(UserGetQuery query) {
        if (query == null) {
            return null;
        }
        UserQuery userQuery = UserRepoConvertor.toUserQuery(query);
        userQuery.setDeleted(DeleteEnum.NOT_DELETED.getCode());
        return UserRepoConvertor.toUserDO(userDAO.getByQuery(userQuery));
    }

    @Override
    public List<UserDO> listByQuery(UserGetQuery query) {
        if (query == null) {
            return null;
        }
        UserQuery userQuery = UserRepoConvertor.toUserQuery(query);
        userQuery.setDeleted(DeleteEnum.NOT_DELETED.getCode());
        List<UserPO> userList = userDAO.listByQuery(userQuery);
        if (CollectionUtils.isEmpty(userList)) {
            return Lists.newArrayList();
        }
        return userList.stream().map(UserRepoConvertor::toUserDO).collect(Collectors.toList());
    }

}
