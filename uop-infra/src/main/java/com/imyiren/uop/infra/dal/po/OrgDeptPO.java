package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * org_dept
 * @author
 */
@Data
public class OrgDeptPO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 父级ID -1时为根节点
     */
    private Long parentDeptId;

    /**
     * 所属组织
     */
    private Long orgId;

    /**
     * 部门名称
     */
    private String deptName;

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
