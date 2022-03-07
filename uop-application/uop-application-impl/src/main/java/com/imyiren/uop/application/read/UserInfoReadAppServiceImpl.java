package com.imyiren.uop.application.read;

import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.base.PageDTO;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yiren
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserInfoReadAppServiceImpl implements UserInfoReadAppService {

    @Override
    public PageDTO<UserInfoDTO> listPageByQuery(UserListPageQuery userListPageQuery) {
        return null;
    }

    @Override
    public UserInfoDTO getBySessionId(String sessionId) {
        return null;
    }

}
