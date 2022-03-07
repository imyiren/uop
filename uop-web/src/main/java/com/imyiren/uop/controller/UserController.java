package com.imyiren.uop.controller;

import com.imyiren.result.BizStateCodes;
import com.imyiren.result.base.Result;
import com.imyiren.result.state.StateCode;
import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.read.query.UserInfoGetByValidSessionQuery;
import com.imyiren.uop.application.write.api.UserInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.UserLogoutCmd;
import com.imyiren.uop.application.write.dto.UserLogoutDTO;
import com.imyiren.uop.convertor.UserConvertor;
import com.imyiren.uop.vo.UserInfoVO;
import com.imyiren.uop.vo.UserLogoutVO;
import com.imyiren.result.BizResults;
import com.imyiren.result.base.BizResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public Result logout(@RequestHeader("session-id") String sessionId) {
        UserLogoutCmd userLogoutCmd = new UserLogoutCmd();
        userLogoutCmd.setSessionId(sessionId);
        UserLogoutDTO logoutResult = userInfoWriteAppService.logout(userLogoutCmd);
        UserLogoutVO userLogoutVO = new UserLogoutVO();
        userLogoutVO.setSuccess(logoutResult.getSuccess());
        return BizResults.success(userLogoutVO);
    }

    @GetMapping("/session")
    public Result getBySessionId(
            @RequestHeader(name = "session-id", required = false) String sessionId
    ) {
        if (StringUtils.isEmpty(sessionId)) {
            return BizResults.failed(BizStateCodes.BIZ_ERROR, "当前会话信息为空！请登录后重试！");
        }
        UserInfoGetByValidSessionQuery query = new UserInfoGetByValidSessionQuery();
        query.setSessionId(sessionId);
        UserSessionInfoDTO userSessionInfoDTO = userInfoReadAppService.getByValidSession(query);
        if (Objects.isNull(userSessionInfoDTO)) {
            BizResults.failed(BizStateCodes.BIZ_ERROR, "session会话过期，请重新登录！");
        }
        return BizResults.success(UserConvertor.toUserInfoVO(userSessionInfoDTO));
    }

}
