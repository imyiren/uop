package com.imyiren.uop.client.web;

import com.imyiren.uop.client.web.permission.UopPermissionInterceptor;
import com.imyiren.uop.client.web.session.UopSessionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiren
 */
@Configuration
public class UopWebConfiguration {

    @Bean
    public UopSessionFilter uopSessionFilter () {
        return new UopSessionFilter();
    }

    @Bean
    public UopPermissionInterceptor uopPermissionInterceptor() {
        return new UopPermissionInterceptor();
    }

}
