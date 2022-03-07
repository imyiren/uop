package com.imyiren.uop.infra.repository;

import com.imyiren.uop.domain.repository.api.UserSessionRepository;
import com.imyiren.uop.domain.repository.entity.UserSessionDO;
import com.imyiren.uop.domain.repository.query.UserSessionQuery;
import com.imyiren.uop.infra.convertor.UserSessionRepoConvertor;
import com.imyiren.uop.infra.dal.dao.UopUserSessionDAO;
import com.imyiren.uop.infra.dal.po.UopUserSession;
import com.imyiren.uop.infra.enums.DeleteEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author yiren
 */
@Slf4j
@Repository
@AllArgsConstructor
public class UserSessionRepositoryImpl implements UserSessionRepository {

    private final UopUserSessionDAO uopUserSessionDAO;

    @Override
    public UserSessionDO get(UserSessionQuery query){
        query.setDeleted(DeleteEnum.NOT_DELETED.getCode());
        UopUserSession userSession = uopUserSessionDAO.get(query);
        if (Objects.isNull(userSession)) {
            return null;
        }

        return UserSessionRepoConvertor.toUserSessionDO(userSession);
    }

    @Override
    public UserSessionDO save(UserSessionDO userSession) {
        if (Objects.isNull(userSession)) {
            return null;
        }
        UopUserSession uopUserSession = UserSessionRepoConvertor.toUopUserSession(userSession);
        if (Objects.isNull(userSession.getId())) {
            uopUserSessionDAO.insertSelective(uopUserSession);
            userSession.setId(uopUserSession.getId());
            return userSession;
        }

        uopUserSessionDAO.updateByPrimaryKeySelective(uopUserSession);
        return userSession;
    }
}
