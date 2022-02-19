package com.lyn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-08-31 17:25
 **/
@Controller
public class ClientController  {
    @Autowired
    private RestTemplate restTemplate;

    private static String  url = "http://nacos-server";




    public void init223(){
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule3 = new FlowRule();
        flowRule3.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule3.setResource("client");
        //设置受保护的资源的阈值
        flowRule3.setCount(1);
        flowRules.add(flowRule3);
        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
        System.out.println("client...........#########");
    }

/*        public void init() {
       List<FlowRule> flowRules = new ArrayList<>();
       FlowRule flowRule3 = new FlowRule();
       //设置流控规则 QPS
       flowRule3.setGrade(RuleConstant.FLOW_GRADE_QPS);
       //设置受保护的资源
       flowRule3.setResource("helloSentinelV3");
       //设置受保护的资源的阈值
       flowRule3.setCount(1);
       flowRules.add(flowRule3);
       //加载配置好的规则
       FlowRuleManager.loadRules(flowRules);


    }*/


    @RequestMapping("/client")
//    @SentinelResource(value = "client", blockHandler = "fallClient")
    public String client(String name){
//        int num = 1 / name;
        System.out.println("####: " + name);
        //Object res = restTemplate.getForObject(url + "/getServer?name=222", Object.class);
        System.out.println(name);
        return "res: client";
    }

    public String fallClient(BlockException e, String name){
        return "client 方法被限流了。。控制了 .. " + e;
    }


    @RequestMapping("/credit")
    public Object credit(){
        Object res = restTemplate.getForObject( "http://credit-service/credit/creditCount", Object.class);
        System.out.println(res);
        return "client: " + res;
    }

    public void afterPropertiesSet() throws Exception {
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule3 = new FlowRule();
        flowRule3.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源
        flowRule3.setResource("client");
        //设置受保护的资源的阈值
        flowRule3.setCount(1);
        flowRules.add(flowRule3);
        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);
        System.out.println("client...........#########");
    }
}
