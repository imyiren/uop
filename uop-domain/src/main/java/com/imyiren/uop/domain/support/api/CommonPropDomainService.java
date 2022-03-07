package com.imyiren.uop.domain.support.api;


import com.imyiren.uop.domain.support.entity.PropDO;

import java.util.List;

/**
 * @author yiren
 */
public interface CommonPropDomainService {

    /**
     * 根据KEY值获取DO
     * @param key key
     * @return propList
     */
    List<PropDO> listByKey(String key);

}
