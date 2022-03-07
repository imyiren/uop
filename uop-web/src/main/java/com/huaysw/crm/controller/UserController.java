package com.huaysw.crm.controller;

import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.base.PageDTO;
import com.imyiren.uop.application.write.api.UserInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.UserLogoutCmd;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.write.dto.UserLogoutDTO;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import com.huaysw.crm.convertor.PageConvertor;
import com.huaysw.crm.convertor.UserConvertor;
import com.huaysw.crm.vo.UserInfoVO;
import com.huaysw.crm.vo.UserLogoutVO;
import com.imyiren.result.BizResults;
import com.imyiren.result.base.BizPageResult;
import com.imyiren.result.base.BizResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yiren
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserInfoWriteAppService userInfoWriteAppService;
    private final UserInfoReadAppService userInfoReadAppService;

    @PostMapping("/logout")
    public BizResult<UserLogoutVO> logout(@RequestHeader("session-id") String sessionId) {
        UserLogoutCmd userLogoutCmd = new UserLogoutCmd();
        userLogoutCmd.setSessionId(sessionId);
        UserLogoutDTO logoutResult = userInfoWriteAppService.logout(userLogoutCmd);
        UserLogoutVO userLogoutVO = new UserLogoutVO();
        userLogoutVO.setSuccess(logoutResult.getSuccess());
        return BizResults.success(userLogoutVO);
    }

    @GetMapping("/page")
    public BizPageResult<UserInfoVO> page(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String realName
    ) {
        UserListPageQuery userListPageQuery = new UserListPageQuery();
        userListPageQuery.setPageNum(pageNum);
        userListPageQuery.setPageSize(pageSize);
        userListPageQuery.setUsername(username);
        userListPageQuery.setPhone(phone);
        userListPageQuery.setEmail(email);
        userListPageQuery.setRealName(realName);
        PageDTO<UserInfoDTO> pageResult = userInfoReadAppService.listPageByQuery(userListPageQuery);
        return PageConvertor.toBizPageResult(pageResult, UserConvertor::toUserInfoVO);
    }

    @GetMapping("/session")
    public BizResult<UserInfoVO> getBySessionId(
            @RequestHeader("session-id") String sessionId
    ) {
        return BizResults.success(UserConvertor.toUserInfoVO(userInfoReadAppService.getBySessionId(sessionId)));
    }

}
