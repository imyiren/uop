package com.imyiren.uop.domain.user.api;

import com.imyiren.uop.domain.user.event.CreateUserSessionEvent;
import com.imyiren.uop.domain.user.event.DeleteUserSessionEvent;

public interface UserAuthDomainService {

    /**
     * 校验用户名密码
     *
     * @param event session创建事件
     * @return user session
     */
    String createUserSession(CreateUserSessionEvent event);


    /**
     * 校验用户名密码
     *
     * @param event session创建事件
     * @return user session
     */
    boolean expireSession(DeleteUserSessionEvent event);


}
