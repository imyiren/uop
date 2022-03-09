package com.imyiren.uop.client.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


/**
 * @author yiren
 */
@Data
public class UserInfo implements Serializable {

    /**
     * 会话ID
     */
    private String sessionId;

    /**
     * 主键ID
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 全局唯一编码
     */
    private String userCode;

    /**
     * 当前会话的组织
     */
    private Long currentOrgId;

    /**
     * 当前会话组织名称
     */
    private String currentOrgName;

    /**
     * 角色编码
     */
    private Set<String> roleCodeList;

}
