package com.imyiren.uop.controller;

import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.base.PageDTO;
import com.imyiren.uop.application.write.api.UserInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.UserLogoutCmd;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.write.dto.UserLogoutDTO;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import com.imyiren.uop.convertor.PageConvertor;
import com.imyiren.uop.convertor.UserConvertor;
import com.imyiren.uop.vo.UserInfoVO;
import com.imyiren.uop.vo.UserLogoutVO;
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
@RequestMapping("/user")
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

    @GetMapping("/session")
    public BizResult<UserInfoVO> getBySessionId(
            @RequestHeader("session-id") String sessionId
    ) {
        return BizResults.success(UserConvertor.toUserInfoVO(userInfoReadAppService.getBySessionId(sessionId)));
    }

}