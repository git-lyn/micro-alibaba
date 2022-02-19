package com.lyn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-11 17:33
 *  授权服务器的配置
 **/

/**
 *  需要知道三方的资源:
 *  1、 用户认证的信息
 *  2、 微服务的信息
 *  3、 前端服务信息
 */
@EnableAuthorizationServer
@Configuration
public class MyAuthorizationConfig implements AuthorizationServerConfigurer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     * 配置加密器对象
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * 3、针对资源服务器来校验令牌的配置
     * 你资源服务器来校验令牌 需要带入client_id和client_securet过来
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 获取tokenkey需要登陆
        security.checkTokenAccess("isAuthenticated()");
    }

    /**
     * 1、为第三方客户端进行配置处理
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /**
         * 配置解析 授权服务器指定客户端(第三方应用)
         * 为第三方应用办法客户端 id为，密码为
         * 支持的授权类型为 密码模式(有四种模式, 后面说)
         * 颁发的令牌有效期为1小时
         * 通过该令牌可以访问 哪些资源服务器(order-service) 可以配置多个
         * 访问资源服务器的 read write权限
         */
        clients.inMemory()
                .withClient("portal_app") // app_id
                .secret(passwordEncoder.encode("portal_app")) // secret
                //.authorizedGrantTypes("order-service", "product-service") //
                .authorizedGrantTypes("password") // 采用的密码模式: password token
                .accessTokenValiditySeconds(3600) //过期时间
                .resourceIds("order-service", "product-service") // 可以访问的微服务
                .and()
                .withClient("order_app") // app_id
                .secret(passwordEncoder.encode("smlz")) // 密码
                .accessTokenValiditySeconds(1800)
                .scopes("read") // read权限
                .authorizedGrantTypes("password") // 支持的授权类型为 密码模式
                .resourceIds("order-service")
                .and()
                .withClient("product_app")
                .secret(passwordEncoder.encode("smlz"))
                .accessTokenValiditySeconds(1800)
                .scopes("read")
                .authorizedGrantTypes("password")
                .resourceIds("product-service");


    }

    /**
     * 2、针对用户的配置，也就是说，第三方客户端带入过来的用户名，密码
     * 我认证中心怎么去验证他的的正确性
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
