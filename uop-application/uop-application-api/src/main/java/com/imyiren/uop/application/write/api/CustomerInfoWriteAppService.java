package com.imyiren.uop.application.write.api;


import com.imyiren.uop.application.write.cmd.CustomerSaveCmd;
import com.imyiren.uop.application.write.dto.CustomerCreateDTO;

/**
 * @author yiren
 */
public interface CustomerInfoWriteAppService {

    /**
     * 创建客户
     *
     * @param cmd 创建客户命令
     * @return 创建结果
     */
    CustomerCreateDTO save(CustomerSaveCmd cmd);
}
