package com.imyiren.uop.infra.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yiren
 */
@Data
@ConfigurationProperties("aliyun.oss")
public class OssProperties {

    /**
     * 接入点
     */
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String prefix = "uop";
    private String domain;

}
