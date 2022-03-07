package com.imyiren.uop.domain.support.convertor;

import com.imyiren.uop.domain.support.entity.PropDO;
import com.huaysw.crm.infra.dal.po.CommonPropPO;

import java.util.Objects;

/**
 * @author yiren
 */
public abstract class PropAppConvertor {

    public static PropDO toPropDO(CommonPropPO original) {
        if (Objects.isNull(original)) {
            return null;
        }
        PropDO propDO = new PropDO();
        propDO.setId(original.getId());
        propDO.setCode(original.getCode());
        propDO.setKey(original.getKey());
        propDO.setValue(original.getValue());
        propDO.setDeleted(original.getDeleted());
        propDO.setCreateTime(original.getCreateTime());
        propDO.setUpdateTime(original.getUpdateTime());
        return propDO;
    }

}
