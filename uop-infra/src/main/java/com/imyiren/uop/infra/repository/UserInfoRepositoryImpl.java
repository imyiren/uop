package com.imyiren.uop.infra.repository;

import com.google.common.collect.Lists;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.domain.repository.api.UserInfoRepository;
import com.imyiren.uop.infra.convertor.UserInfoRepoConvertor;
import com.imyiren.uop.infra.dal.dao.UopUserDAO;
import com.imyiren.uop.infra.dal.po.UopUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yiren
 */
@Repository
@AllArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepository {

    private final UopUserDAO uopUserDAO;

    @Override
    public UserInfoDO getByQuery(UserInfoQuery query) {
        UopUser user = uopUserDAO.getByQuery(query);
        if (Objects.isNull(user)) {
            return null;
        }
        return UserInfoRepoConvertor.toUserDO(user);
    }

    @Override
    public List<UserInfoDO> listByQuery(UserInfoQuery query) {
        List<UopUser> uopUserList = uopUserDAO.listByQuery(query);
        if (CollectionUtils.isEmpty(uopUserList)) {
            return Lists.newArrayList();
        }
        return uopUserList.stream().map(UserInfoRepoConvertor::toUserDO).collect(Collectors.toList());
    }

    @Override
    public UserInfoDO save(UserInfoDO user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UopUser uopUser = UserInfoRepoConvertor.toUopUser(user);
        if (Objects.isNull(user.getId())) {
            uopUserDAO.insertSelective(uopUser);
            user.setId(uopUser.getId());
            return user;
        }
        uopUserDAO.updateByPrimaryKeySelective(null);
        return user;
    }

}
