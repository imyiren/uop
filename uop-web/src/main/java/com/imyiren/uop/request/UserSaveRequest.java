package com.imyiren.uop.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserSaveRequest implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 真实姓名
     */
    private String realName;

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
