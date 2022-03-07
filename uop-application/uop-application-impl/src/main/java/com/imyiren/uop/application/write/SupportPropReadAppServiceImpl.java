package com.imyiren.uop.application.write;

import com.google.common.collect.Lists;
import com.imyiren.uop.application.read.api.SupportPropReadAppService;
import com.imyiren.uop.application.read.dto.SupportPropDTO;
import com.imyiren.uop.application.read.query.SupportPropListQuery;
import com.imyiren.uop.domain.support.api.CommonPropDomainService;
import com.imyiren.uop.domain.support.entity.PropDO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yiren
 */
@Service
@AllArgsConstructor
public class SupportPropReadAppServiceImpl implements SupportPropReadAppService {

    private final CommonPropDomainService commonPropDomainService;

    @Override
    public List<SupportPropDTO> listByQuery(SupportPropListQuery query) {
        List<PropDO> propList = commonPropDomainService.listByKey(query.getKey());

        if (CollectionUtils.isEmpty(propList)) {
            return Lists.newArrayList();
        }
        return propList.stream().map(elem -> {
            SupportPropDTO prop = new SupportPropDTO();
            prop.setCode(elem.getCode());
            prop.setKey(elem.getKey());
            prop.setValue(elem.getValue());
            return prop;
        }).collect(Collectors.toList());
    }
}
