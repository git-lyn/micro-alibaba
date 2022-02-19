package com.lyn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-11 20:38
 **/
@RestController
@Slf4j
public class OrderController {

    @RequestMapping("/selectOrderInfoById/{id}")
    public String selectOrderInfoById(@PathVariable("id") String id, @AuthenticationPrincipal String userName) {
        log.info("username:{}", userName);
        System.out.println("id: " + id);
        return "selectOrderInfoById####:id= " + id;
    }

    @RequestMapping("/saveOrder")
    public String saveOrder(){
        log.info("save:{}",3333);
        System.out.println("save.......");
        return "order:oodfdfdfdf";
    }

}
