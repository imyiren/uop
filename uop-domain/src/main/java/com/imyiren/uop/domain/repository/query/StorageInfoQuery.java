package com.imyiren.uop.domain.repository.query;

import java.time.LocalDateTime;

public class StorageInfoQuery {

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
     *
     * 1 - uop系统用户文件 关联用户
     *
     * 999 - 系统文件 关联ID为-1 不允许删除
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

    /**
     * 是否删除
     */
    private Integer deleted;


    private LocalDateTime createTime;
    private LocalDateTime createTimeStart;
    private LocalDateTime createTimeEnd;

    private LocalDateTime updateTime;
    private LocalDateTime updateTimeStart;
    private LocalDateTime updateTimeEnd;


}
