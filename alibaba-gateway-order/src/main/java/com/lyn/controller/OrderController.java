package com.lyn.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-07 11:16
 **/
@RestController
@RequestMapping("/myorder")
public class OrderController {

    @RequestMapping("/getOrder")
    public String getOrder(@RequestParam(value = "id", defaultValue = "2") int id){
        if (id > 9) {
            return "今天天气很不错";
        } else {
            return "today is running ";
        }
    }

    @RequestMapping("/getHeader")
    public String getHeader(@RequestHeader("X-Request-Foo")  String requestHeader){
        System.out.println("ddd: " + requestHeader);
        return "header: " + requestHeader;
    }

    @RequestMapping("/getRequest")
    public String gerRequest(@RequestParam(value = "company", defaultValue = "hello test") String company){

        System.out.println("company: " + company);
        return "company: " + company;
    }

}
