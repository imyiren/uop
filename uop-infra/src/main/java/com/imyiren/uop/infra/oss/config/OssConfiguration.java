package com.imyiren.uop.infra.oss.config;

import com.imyiren.uop.infra.oss.client.UopOssClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiren
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(OssProperties.class)
public class OssConfiguration {


    @Bean
    public UopOssClient uopOssClient(OssProperties ossProperties) {
        return new UopOssClient(ossProperties);
    }


}
