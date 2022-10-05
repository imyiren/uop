package com.imyiren.uop.controller;

import com.imyiren.application.api.dto.PageDTO;
import com.imyiren.result.BizStateCodes;
import com.imyiren.result.base.Result;
import com.imyiren.result.state.StateCode;
import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.read.dto.UserInfoDTO;
import com.imyiren.uop.application.read.dto.UserSessionInfoDTO;
import com.imyiren.uop.application.read.query.UserInfoGetByValidSessionQuery;
import com.imyiren.uop.application.read.query.UserListPageQuery;
import com.imyiren.uop.application.write.api.UserInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.UserLogoutCmd;
import com.imyiren.uop.application.write.dto.UserLogoutDTO;
import com.imyiren.uop.client.common.UserContext;
import com.imyiren.uop.convertor.UserConvertor;
import com.imyiren.uop.utils.PageUtils;
import com.imyiren.uop.vo.UserInfoVO;
import com.imyiren.uop.vo.UserLogoutVO;
import com.imyiren.result.BizResults;
import com.imyiren.result.base.BizResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public Result getBySessionId() {
        log.info("验证web上下问传递参数 UserContext.get(): {}", UserContext.get());
        UserInfoGetByValidSessionQuery query = new UserInfoGetByValidSessionQuery();
        query.setSessionId(UserContext.get().getSessionId());
        UserSessionInfoDTO userSessionInfoDTO = userInfoReadAppService.getByValidSession(query);
        if (Objects.isNull(userSessionInfoDTO)) {
            BizResults.failed(BizStateCodes.BIZ_ERROR, "session会话过期，请重新登录！");
        }
        return BizResults.success(UserConvertor.toUserInfoVO(userSessionInfoDTO));
    }

    @GetMapping()
    public Result listPage(
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) Integer state
    ) {
        UserListPageQuery pageQuery = new UserListPageQuery();
        pageQuery.setPageNum(pageNum);
        pageQuery.setPageSize(pageSize);
        pageQuery.setCode(code);
        pageQuery.setUsername(username);
        pageQuery.setState(state);
        pageQuery.setNickname(nickname);

        PageDTO<UserInfoDTO> pageDTO = userInfoReadAppService.listPageByQuery(pageQuery);
        return PageUtils.toBizPageResult(pageDTO, UserConvertor::toUserInfoVO);
    }
}
