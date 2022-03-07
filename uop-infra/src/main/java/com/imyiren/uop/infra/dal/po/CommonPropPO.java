package com.imyiren.uop.infra.dal.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * common_prop
 * @author
 */
@Data
public class CommonPropPO implements Serializable {
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

    private static final long serialVersionUID = 1L;
}
