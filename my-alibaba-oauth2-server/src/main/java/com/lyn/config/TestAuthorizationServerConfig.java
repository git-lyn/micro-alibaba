package com.lyn.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import sun.security.util.Password;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2021-04-18 15:43
 **/
//@Configuration
//@EnableAuthorizationServer
public class TestAuthorizationServerConfig {
        //extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    /**
//     * ③针对资源服务器来校验令牌的配置
//     * 资源服务器来校验令牌，需要带入client_id和client_securet过来
//     * @param security
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        // 获取tokenkey需要登陆
//        security.checkTokenAccess("isAuthenticated()");
//    }
//
//    /**
//     * ①:第三方客户端配置，配置哪些应用可以来访问我们认证服务器。
//     * 为客户端分配一个client_id为portal_app,密码为portal_app,
//     * 它的权限访问为read权限的。服务器颁发的token 有效期是1个小时，
//     * 拿着token令牌可以访问order-service,product-service两个微服务
//     * order-service,product-service同理，也是分配了账号
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        /**
//         * 配置解析 授权服务器指定客户端(第三方应用)能访问授权服务器
//         * 为第三方应用颁发客户端id为， 密码为smlz
//         * 支持的授权模式 为密码模式、授权码模式（有四种模式）
//         * 颁发的令牌的有效期为1小时
//         * 通过该令牌可以访问 那些资源服务器（order-service） 可以配置多个
//         * 访问资源服务器的 read wirte权限
//         */
//
//        clients.inMemory()
//                .withClient("portal_app")
//                .secret(passwordEncoder.encode("protal_app"))
//                .authorizedGrantTypes("password", "authorization_code")
//                .scopes("read")
//                .accessTokenValiditySeconds(3600)
//                .resourceIds("order-service", "product-service")
//                .redirectUris("http://www.baidu.com")
//                .and()
//                .withClient("order_app")
//                .secret(passwordEncoder.encode("smlz"))
//                .accessTokenValiditySeconds(1800)
//                .scopes("read")
//                .authorizedGrantTypes("password")
//                .resourceIds("order-service")
//                .and()
//                .withClient("product_app")
//                .secret(passwordEncoder.encode("smlz"))
//                .accessTokenValiditySeconds(1800)
//                .scopes("read")
//                .authorizedGrantTypes("password")
//                .resourceIds("product-service");
//
//    }
//
//    /**
//     * ②：针对用户的配置，也就是说，第三方客户端带入过来的用户名，密码我认证中心怎么
//     * 去验证他的正确性
//     * @param endpoints
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }
}
