package com.lyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-11 17:29
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApp.class);
    }
}
