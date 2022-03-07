package com.huaysw.crm.controller;

import com.imyiren.uop.application.read.api.SupportPropReadAppService;
import com.imyiren.uop.application.read.dto.SupportPropDTO;
import com.imyiren.uop.application.read.query.SupportPropListQuery;
import com.huaysw.crm.vo.SupportPropVO;
import com.imyiren.result.BizResults;
import com.imyiren.result.base.BizResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author yiren
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/open/support/prop")
public class OpenSupportPropController {

    private SupportPropReadAppService supportPropReadAppService;

    @GetMapping
    public BizResult<List<SupportPropVO>> listByKey(@RequestParam String key) {
        SupportPropListQuery query = new SupportPropListQuery();
        query.setKey(key);
        List<SupportPropDTO> supportPropList = supportPropReadAppService.listByQuery(query);

        List<SupportPropVO> propInfoList = supportPropList.stream().map(elem -> {
            SupportPropVO supportPropVO = new SupportPropVO();
            supportPropVO.setCode(elem.getCode());
            supportPropVO.setKey(elem.getKey());
            supportPropVO.setValue(elem.getValue());
            return supportPropVO;
        }).collect(Collectors.toList());
        return BizResults.success(propInfoList);
    }

}
