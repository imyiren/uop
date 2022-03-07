package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author yiren
 */
@Data
public class UserLogoutCmd implements Serializable {

    @NotEmpty(message = "当前会话信息不能为空！")
    private String sessionId;

}
