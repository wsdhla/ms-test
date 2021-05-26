package com.etoak.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Eureka Client: 服务提供者
 */
@MapperScan("com.etoak.test.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApp.class, args);
    }
}
