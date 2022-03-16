package com.lyn.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {


    @GetMapping("/hello")
    public String hello(int id){

        return "hello world";
    }

}
