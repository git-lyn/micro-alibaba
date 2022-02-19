package com.lyn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-11 20:19
 **/

/**
 * 3、资源服务器的安全配置
 * 我资源服务器拿到令牌，我怎么知道这个令牌是否合法，
 * 所以我需要去配置远程校验token的配置
 */
@Configuration
@EnableWebSecurity
public class OrderWebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 远程校验token的配置
    @Bean
    public ResourceServerTokenServices resourceServerTokenServices(){
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        // client_id和密码
        remoteTokenServices.setClientId("order_app");
        remoteTokenServices.setClientSecret("smlz");
        // 认证服务器的校验地址
        remoteTokenServices.setCheckTokenEndpointUrl("http://auth-server/oauth/check_token");
        remoteTokenServices.setRestTemplate(restTemplate());
        return remoteTokenServices;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        OAuth2AuthenticationManager manager = new OAuth2AuthenticationManager();
        manager.setTokenServices(resourceServerTokenServices());
        return manager;
    }

}
