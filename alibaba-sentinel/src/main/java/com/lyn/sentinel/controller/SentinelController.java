package com.lyn.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lyn.sentinel.bean.OrderInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2021-04-04 16:16
 **/
@RestController
public class SentinelController {

    @GetMapping("/test-sentinel-resource")
    @SentinelResource(value = "/order/create",
            blockHandler = "blockHandlerFunc",
            fallback = "fallbackFunc")
    public String testSentinelResource(@RequestParam(required = true) String s) throws InterruptedException {
        Thread.sleep(100);
        return s;
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @RequestMapping("/getInfo/{id}")
    public OrderInfo getInfo(@PathVariable("id") String id) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(Integer.parseInt(id));
        orderInfo.setName(UUID.randomUUID().toString().substring(0,8));
        return orderInfo;
    }

    @RequestMapping("/getOrder/{orderId}")
    public OrderInfo getOrder(@PathVariable("orderId") String orderId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(Integer.parseInt(orderId));
        orderInfo.setName(UUID.randomUUID().toString().substring(0,8));
        return orderInfo;
    }

}
