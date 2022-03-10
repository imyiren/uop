package com.imyiren.uop.domain.repository.api;

import com.imyiren.uop.domain.repository.entity.ValidationPicDO;
import com.imyiren.uop.domain.repository.query.ValidationPicQuery;

/**
 * @author yiren
 */
public interface ValidationPicRepository {


    /**
     * 创建图片验证码
     *
     * @param validationPicDO 图片验证码信息
     * @return 图片验证码
     */
    ValidationPicDO save(ValidationPicDO validationPicDO);

    /**
     * 获取图片验证码
     *
     * @param query 查询参数
     * @return 图片验证码信息
     */
    ValidationPicDO get(ValidationPicQuery query);

}
