package com.imyiren.uop.application.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yiren
 */
@Data
public class PageDTO<T> implements Serializable {

    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private Long pages;

    private Boolean hasNextPage;

    private Boolean hasPrevPage;

    private List<T> dataList;


}
