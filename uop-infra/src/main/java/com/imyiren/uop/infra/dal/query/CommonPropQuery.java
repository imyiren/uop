package com.imyiren.uop.infra.dal.query;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class CommonPropQuery implements Serializable {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 参数编码
     */
    private String code;

    /**
     * KEY 会有一对多的场景
     */
    private String key;

    /**
     * 值
     */
    private String value;

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

}
