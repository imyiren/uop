package com.imyiren.uop.domain.repository.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class ValidationPicDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 校验KEY
     */
    private String picKey;

    /**
     * 校验码
     */
    private String picCode;

    /**
     * 状态 100-已生成待验证 200-验证成功 300-失效
     */
    private Integer state;

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
