package com.imyiren.uop.application.convertor;

import com.google.common.collect.Lists;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import com.imyiren.uop.domain.repository.entity.UserInfoDO;
import com.imyiren.uop.domain.repository.query.UserInfoQuery;

/**
 * @author yiren
 */
public class UserAppConvertor {

    public static UserInfoQuery toUserInfoQuery(UserListPageQuery query) {
        UserInfoQuery userInfoQuery = new UserInfoQuery();
        userInfoQuery.setUsername(query.getUsername());
        userInfoQuery.setPhone(query.getPhone());
        userInfoQuery.setEmail(query.getEmail());
        return userInfoQuery;
    }


    public static UserInfoDTO toUserInfoDTO(UserInfoDO user) {

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setRoleList(Lists.newArrayList("admin", "user"));
        userInfoDTO.setWorkNo("12312");
        userInfoDTO.setRealName("测试用户");
        userInfoDTO.setPhone("13312341234");
        userInfoDTO.setState(1);
        userInfoDTO.setStateDesc("在用");
        userInfoDTO.setAvatarUrl("https://p.qqan.com/up/2021-2/16137992359659254.jpg");
        userInfoDTO.setTitle("CEO");

        userInfoDTO.setId(user.getId());
        // userInfoDTO.setWorkNo();
        // userInfoDTO.setRealName();
        userInfoDTO.setUsername(user.getUsername());
        userInfoDTO.setPhone(user.getPhone());
        userInfoDTO.setEmail(user.getEmail());
        userInfoDTO.setState(user.getState());
        return userInfoDTO;
    }
}
