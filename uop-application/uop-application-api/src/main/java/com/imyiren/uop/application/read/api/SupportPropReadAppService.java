package com.imyiren.uop.application.read.api;

import com.imyiren.uop.application.read.dto.SupportPropDTO;
import com.imyiren.uop.application.read.query.SupportPropListQuery;

import java.util.List;


/**
 * @author yiren
 */
public interface SupportPropReadAppService {

    /**
     * 配置参数查询
     *
     * @param query 查询参数
     * @return prop List
     */
    List<SupportPropDTO> listByQuery(SupportPropListQuery query);

}
