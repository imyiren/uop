package com.imyiren.uop.infra.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;
import com.imyiren.uop.domain.repository.api.UserInfoRepository;
import com.imyiren.uop.domain.utils.PageInfoUtils;
import com.imyiren.uop.infra.convertor.UserInfoRepoConvertor;
import com.imyiren.uop.infra.dal.dao.UopUserDAO;
import com.imyiren.uop.infra.dal.po.UopUser;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
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
    public UserInfoDO get(UserInfoQuery query) {
        UopUser user = uopUserDAO.selectOneByQuery(query);
        if (Objects.isNull(user)) {
            return null;
        }
        return UserInfoRepoConvertor.toUserDO(user);
    }

    @Override
    public List<UserInfoDO> list(UserInfoQuery query) {
        List<UopUser> uopUserList = uopUserDAO.selectByQuery(query);
        if (CollectionUtils.isEmpty(uopUserList)) {
            return Lists.newArrayList();
        }
        return uopUserList.stream().map(UserInfoRepoConvertor::toUserDO).collect(Collectors.toList());
    }

    @Override
    public PageInfo<UserInfoDO> listPage(Integer pageNum, Integer pageSize, UserInfoQuery query) {
        PageInfo<UopUser> userInfoPageInfo = PageHelper.startPage(ObjectUtils.defaultIfNull(pageNum,1), ObjectUtils.defaultIfNull(pageSize, 20))
                .doSelectPageInfo(() -> uopUserDAO.selectByQuery(query));
        return PageInfoUtils.transfer(userInfoPageInfo, UserInfoRepoConvertor::toUserDO);
    }

    @Override
    public UserInfoDO save(UserInfoDO user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UopUser uopUser = UserInfoRepoConvertor.toUopUser(user);
        if (Objects.isNull(user.getId())) {
            uopUserDAO.insertSelective(uopUser);
            String code = String.format("1%05d", uopUser.getId());
            uopUser.setCode(code);
            uopUserDAO.updateByPrimaryKeySelective(uopUser);
            user.setId(uopUser.getId());
            return user;
        }
        uopUserDAO.updateByPrimaryKeySelective(uopUser);
        return user;
    }

}
