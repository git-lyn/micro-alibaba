package com.lyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-26 15:11
 **/
@RestController
public class RedisClusterController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/testCluster")
    public void testCluster(){
        stringRedisTemplate.opsForValue().set("zhuge", "666");
        System.out.println(stringRedisTemplate.opsForValue().get("zhuge"));
    }


}
