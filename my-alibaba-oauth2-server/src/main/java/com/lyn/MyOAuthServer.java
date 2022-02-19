package com.lyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2021-04-18 15:41
 **/
@SpringBootApplication
//@EnableDiscoveryClient
public class MyOAuthServer {
    public static void main(String[] args) {
        SpringApplication.run(MyOAuthServer.class, args);
    }
}
