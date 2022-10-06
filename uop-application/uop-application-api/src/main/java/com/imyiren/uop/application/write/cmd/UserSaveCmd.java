package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import java.util.List;

/**
 * @author yiren
 * @date 2022/10/6
 **/
@Data
public class UserSaveCmd {
    /**
     * ID
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;
    private String password;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 角色信息
     */
    private List<String> roleList;

}
