package com.imyiren.uop.domain.support.service;

import com.google.common.collect.Lists;
import com.imyiren.uop.domain.support.api.CommonPropDomainService;
import com.imyiren.uop.domain.support.convertor.PropAppConvertor;
import com.imyiren.uop.domain.support.entity.PropDO;
import com.huaysw.crm.infra.dal.dao.CommonPropDAO;
import com.huaysw.crm.infra.dal.po.CommonPropPO;
import com.huaysw.crm.infra.dal.query.CommonPropQuery;
import com.huaysw.crm.infra.enums.DeleteEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yiren
 */
@Service
public class CommonPropDomainServiceImpl implements CommonPropDomainService {

    @Resource
    private CommonPropDAO commonPropDAO;

    @Override
    public List<PropDO> listByKey(String key) {
        CommonPropQuery commonPropQuery = new CommonPropQuery();
        commonPropQuery.setKey(key);
        commonPropQuery.setDeleted(DeleteEnum.NOT_DELETED.getCode());
        List<CommonPropPO> commonPropList = commonPropDAO.listByQuery(commonPropQuery);

        if (CollectionUtils.isEmpty(commonPropList)) {
            return Lists.newArrayList();
        }
        return commonPropList.stream().map(PropAppConvertor::toPropDO).collect(Collectors.toList());
    }
}
