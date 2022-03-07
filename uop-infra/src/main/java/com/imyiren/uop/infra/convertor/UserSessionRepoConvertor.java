package com.imyiren.uop.infra.convertor;

import com.imyiren.uop.domain.repository.entity.UserSessionDO;
import com.imyiren.uop.infra.dal.po.UopUserSession;

/**
 * @author yiren
 */
public final class UserSessionRepoConvertor {

    public static UserSessionDO toUserSessionDO(UopUserSession userSession) {
        UserSessionDO userSessionDO = new UserSessionDO();
        userSessionDO.setId(userSessionDO.getId());
        userSessionDO.setSessionId(userSession.getSessionId());
        userSessionDO.setUserId(userSession.getUserId());
        userSessionDO.setExpireTime(userSession.getExpireTime());
        return userSessionDO;
    }

    public static UopUserSession toUopUserSession(UserSessionDO userSession) {
        UopUserSession uopUserSession = new UopUserSession();
        uopUserSession.setId(userSession.getId());
        uopUserSession.setSessionId(userSession.getSessionId());
        uopUserSession.setUserId(userSession.getUserId());
        uopUserSession.setExpireTime(userSession.getExpireTime());
        return uopUserSession;
    }

}
