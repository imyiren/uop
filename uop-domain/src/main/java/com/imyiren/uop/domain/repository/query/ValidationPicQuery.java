package com.imyiren.uop.domain.repository.query;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yiren
 */
@Data
public class ValidationPicQuery implements Serializable {

    private Long id;

    private String picKey;

    private Integer state;

    private Integer deleted;


    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    private LocalDateTime createTimeStart;
    private LocalDateTime createTimeEnd;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    private LocalDateTime updateTimeStart;
    private LocalDateTime updateTimeEnd;
}
