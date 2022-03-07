package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * customer
 * @author
 */
@Data
public class CustomerPO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 所属组织
     */
    private Long orgId;

    /**
     * 创建人_id
     */
    private Long createUserId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 单位
     */
    private String company;

    /**
     * 来源
     */
    private Integer sourcetype;

    /**
     * QQ
     */
    private Integer qq;

    /**
     * QQ群
     */
    private Integer qqGroup;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 科室
     */
    private String medicalDeptPropCode;

    /**
     * 需求
     */
    private String requirement;

    /**
     * 客户文件
     */
    private Object customerFileList;

    /**
     * 交付文件
     */
    private Object resultFileList;

    /**
     * 创建人_姓名
     */
    private String createUserName;

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
