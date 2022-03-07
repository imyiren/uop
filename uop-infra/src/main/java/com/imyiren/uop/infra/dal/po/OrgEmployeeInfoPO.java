package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * org_employee_info
 * @author
 */
@Data
public class OrgEmployeeInfoPO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 工号
     */
    private String workNo;

    /**
     * 姓名
     */
    private String realName;

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
