package com.etoak.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Eureka Client: 服务消费者
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApp.class, args);
    }
}
