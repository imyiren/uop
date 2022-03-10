package com.imyiren.uop.application.write.api;


import com.imyiren.uop.application.write.cmd.ValidationPicCreateCmd;
import com.imyiren.uop.application.write.dto.ValidationPicDTO;

/**
 * @author yiren
 */
public interface ValidationWriteAppService {

    /**
     * 创建图片验证码
     *
     * @param cmd 创建命令
     * @return 图片验证码信息
     */
    ValidationPicDTO createValidationPic(ValidationPicCreateCmd cmd);
}
