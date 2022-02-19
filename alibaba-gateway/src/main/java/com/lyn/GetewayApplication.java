package com.lyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-06 22:50
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GetewayApplication {
    public static synchronized void main(String[] args) {
        SpringApplication.run(GetewayApplication.class);
    }
}
