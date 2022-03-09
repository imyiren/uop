package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class StorageInfoDO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * code
     */
    private String code;

    /**
     * 文件名
     */
    private String filename;

    /**
     * url
     */
    private String url;

    /**
     * 文件类型
     * <p>
     * 1 - uop系统用户文件 关联用户
     * <p>
     * 999 - 系统文件 关联ID为-1 不允许删除
     * <p>
     * 其他系统 请自定义使用uuid作为业务存储Code
     */
    private String fileTypeCode;

    /**
     * 关联对象ID
     */
    private Long relativeId;

    /**
     * 上传用户
     */
    private Long uploadUserId;

    /**
     * 上传用户
     */
    private String uploadUserName;

    /**
     * 状态 100-正常使用中 200-预删除 300-已删除
     */
    private Integer state;

    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 100 阿里云-OSS 目前支持
     * 200 七牛云
     * ....
     */
    private Integer storageType;

    /**
     * StorageType额外数据
     */
    private String extJson;

}
