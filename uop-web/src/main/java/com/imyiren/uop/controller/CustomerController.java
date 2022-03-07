package com.imyiren.uop.controller;

import com.imyiren.uop.application.write.api.CustomerInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.CustomerSaveCmd;
import com.imyiren.uop.application.write.dto.CustomerCreateDTO;
import com.imyiren.uop.convertor.CustomerConvertor;
import com.imyiren.uop.request.CustomerSaveRequest;
import com.imyiren.result.BizResults;
import com.imyiren.result.base.BizResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yiren
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerInfoWriteAppService customerInfoWriteAppService;

    @PostMapping
    public BizResult<Long> createCustomer(@RequestBody CustomerSaveRequest request,
                                          @RequestHeader("session-id") String sessionId) {
        // getUserId by sessionId
        Long userId = 1L;

        CustomerSaveCmd cmd = CustomerConvertor.toCustomerSaveCmd(request);
        cmd.setCreateUserId(userId);
        CustomerCreateDTO customer = customerInfoWriteAppService.save(cmd);

        return BizResults.success(customer.getId());
    }

}
