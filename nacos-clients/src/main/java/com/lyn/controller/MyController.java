package com.lyn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-03 19:12
 **/
@RestController
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    private static String  url = "http://nacos-server";

    /**
     * 设置限流规则
     */
    @PostConstruct
    public void init(){
        List<FlowRule> flowRules = new ArrayList<>();
        /**
         * 定义受保护的资源的规则
         */
        FlowRule flowRule = new FlowRule();
        // 设置流控规则 QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源
        flowRule.setResource("mytest");
        // 设置受保护的资源的阈值
        flowRule.setCount(1);
        flowRules.add(flowRule);
        System.out.println("启动。。..init");
        // 加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
    }

    @RequestMapping("/mytest")
    @SentinelResource(value = "client", blockHandler = "fallClient")
    public String mytest() {
        System.out.println("teststest....");
        //Object res = restTemplate.getForObject( "http://credit-service/credit/creditCount", Object.class);
        Object res = restTemplate.getForObject(url + "/getServer?name=222", Object.class);
        return "client test result......";
    }

    public String fallClient(BlockException e){
        return "client 方法被限流了。。控制了 .. " + e;
    }


}
