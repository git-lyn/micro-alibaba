package com.lyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-08-31 17:18
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosServer {
    public static void main(String[] args) {
        SpringApplication.run(NacosServer.class);
    }
}
