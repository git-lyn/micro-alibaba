package com.lyn;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.lyn.handler.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-08-31 17:24
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosClient {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate
            (blockHandler = "handlerException", blockHandlerClass = GlobalExceptionHandler.class,
                    fallback = "fallback", fallbackClass = GlobalExceptionHandler.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosClient.class);
    }
}
