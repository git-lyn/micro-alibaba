package com.lyn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-08-31 17:21
 **/
@RestController
public class ServerController {

    @RequestMapping("/getServer")
    public String getServer(){
        return "11112323232";
    }

}
