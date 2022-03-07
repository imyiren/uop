package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * organization
 * @author
 */
@Data
public class OrganizationPO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 删除状态 1-删除 2-未删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}
