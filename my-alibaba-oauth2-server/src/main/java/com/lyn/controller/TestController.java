package com.lyn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2021-04-18 17:03
 **/
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/demo/{id}")
    public String test(@PathVariable String id){
        System.out.println("id: " + id);
        return "hello, " + id;
    }
}
