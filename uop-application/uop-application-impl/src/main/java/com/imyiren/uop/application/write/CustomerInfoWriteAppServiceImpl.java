package com.imyiren.uop.application.write;

import com.imyiren.uop.application.write.api.CustomerInfoWriteAppService;
import com.imyiren.uop.application.write.cmd.CustomerSaveCmd;
import com.imyiren.uop.application.write.dto.CustomerCreateDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerInfoWriteAppServiceImpl implements CustomerInfoWriteAppService {

    @Override
    public CustomerCreateDTO save(CustomerSaveCmd cmd) {
        CustomerCreateDTO customerCreateDTO = new CustomerCreateDTO();
        customerCreateDTO.setId(1231L);
        return customerCreateDTO;
    }

}
