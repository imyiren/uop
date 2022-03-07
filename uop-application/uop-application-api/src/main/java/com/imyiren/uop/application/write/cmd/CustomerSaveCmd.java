package com.imyiren.uop.application.write.cmd;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerSaveCmd implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 公司
     */
    private String company;
    /**
     * 来源
     */
    private Integer sourceType;
    /**
     * 电话
     */
    private String phone;
    /**
     * 微信
     */
    private String wechat;
    /**
     * qq
     */
    private String qq;
    /**
     * qq群
     */
    private String qqGroup;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 需求
     */
    private String requirement;
    /**
     * 科室
     */
    private String medicalDepartment;
    /**
     * 客户提供对文件
     */
    private String customerFileList;
    /**
     * 交付对文件
     */
    private String resultFileList;


    private Long createUserId;
}
