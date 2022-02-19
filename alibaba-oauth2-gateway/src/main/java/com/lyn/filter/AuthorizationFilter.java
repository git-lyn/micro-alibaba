package com.lyn.filter;

import com.lyn.entity.MDA;
import com.lyn.entity.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-11 21:37
 **/
@Component
@Slf4j
public class AuthorizationFilter implements GlobalFilter, Ordered, InitializingBean {

    @Autowired
    private RestTemplate restTemplate;
    // 请求各个微服务, 不需要用户认证的URL
    private static Set<String> shouldSkipUrl = new LinkedHashSet<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 实际上，这边需要通过去数据库读取 不需要认证的url，不需要认证的URL是各个微服务
         * 开发模块的人员提供出来的 我在这里没有去查询数据库了，直接模拟写死
         */
        // 模拟商品详情接口不需要认证
        shouldSkipUrl.add("/product/selectProductInfoById");
        // 去认证的请求，本来就不需要拦截
        shouldSkipUrl.add("/oauth/token");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String reqPath = exchange.getRequest().getURI().getPath();
        log.info("网关认证开始URL->:{}",reqPath);
        // 1: 不需要认证的url
        if (shouldSkip(reqPath)) {
            log.info("无需认证的路径");
            return chain.filter(exchange);
        }

        // 获取请求头
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        // 请求头为空
        if (StringUtils.isEmpty(authHeader)) {
            log.warn("需要认证的url，请求头为空");
            throw new RuntimeException("ddd");
        }
        return null;
    }

    private TokenInfo getTokenInfo(String authHeader) {
        String token = StringUtils.substringAfter(authHeader, "bearer ");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(MDA.CLIENT_ID, MDA.CLIENT_SECRET);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("token", token);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        //ResponseEntity<TokenInfo> response = restTemplate.exchange(MDA.checktokenUrl, HttpMethod.POST,entity,TokenInfo.class);
        ResponseEntity<TokenInfo> response = restTemplate.exchange("ddd", HttpMethod.POST,entity,TokenInfo.class);
        log.info("token info: " + response.getBody().toString());
        return response.getBody();
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 方法实现说明：不需要授权的路径
     * @param reqPath 当前请求路径
     * @return
     */
    private boolean shouldSkip(String reqPath) {
        for (String skipPath : shouldSkipUrl) {
            if(reqPath.contains(skipPath))
                return true;
        }
        return false;
    }

}
