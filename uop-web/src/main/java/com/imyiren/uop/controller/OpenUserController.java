package com.imyiren.uop.controller;

import com.imyiren.uop.application.read.api.UserInfoReadAppService;
import com.imyiren.uop.application.write.api.UserInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.UserLoginCmd;
import com.imyiren.uop.application.write.dto.UserLoginDTO;
import com.imyiren.uop.convertor.UserConvertor;
import com.imyiren.uop.request.UserLoginRequest;
import com.imyiren.uop.vo.UserLoginVO;
import com.imyiren.result.BizResults;
import com.imyiren.result.base.BizResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yiren
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/open/user")
public class OpenUserController {

    private final UserInfoReadAppService userInfoReadAppService;
    private final UserInfoWriteAppService userInfoWriteAppService;

    @PostMapping("/login")
    public BizResult<UserLoginVO> login(@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginCmd userLoginCmd = UserConvertor.toUserLoginCmd(userLoginRequest);
        UserLoginDTO loginResult = userInfoWriteAppService.login(userLoginCmd);
        return BizResults.success(UserConvertor.toUserLoginVO(loginResult));
    }

}
