package com.lyn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-11 20:11
 **/
@Configuration
@EnableResourceServer
// 2、 写配置(资源服务器的配置)
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 标识自己是一个资源服务器，唯一标识为order-service
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("order-service");
    }

    /**
     * springsecurity的配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 标识 /selectOrderInfoById/** 需要token的scope有read权限
        // saveOrder 有些权限
//        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/selectOrderInfoById/**")
                .access("#oauth2.hasScope('read')")
                .and()
                .authorizeRequests()
                .antMatchers("/order/saveOrder")
                .access("#oauth2.hasScope('write')");
    }
}
