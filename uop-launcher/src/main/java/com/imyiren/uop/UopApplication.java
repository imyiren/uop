package com.imyiren.uop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yiren
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UopApplication {

    public static void main(String[] args) {
        SpringApplication.run(UopApplication.class, args);
    }

}
