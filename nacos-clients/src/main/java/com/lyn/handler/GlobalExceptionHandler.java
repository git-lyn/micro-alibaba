package com.lyn.handler;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyn.bean.ResultInfo;
//import com.netflix.client.http.HttpRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-03 21:37
 **/
public class GlobalExceptionHandler {

    /**
     * 降级后进行处理
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse handlerException
            (HttpRequest request, byte[] body,
             ClientHttpRequestExecution execution, BlockException ex) {

        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setMsg("被限制流量了");
        resultInfo.setNum(1);

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            return new SentinelClientHttpResponse(objectMapper.writeValueAsString(resultInfo));
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 熔断后进行处理的方法
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse fallback
            (HttpRequest request, byte[] body,
             ClientHttpRequestExecution execution, BlockException ex) {

        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setMsg("被降级");
        resultInfo.setNum(2);

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            return new SentinelClientHttpResponse(objectMapper.writeValueAsString(resultInfo));
        } catch (JsonProcessingException e) {
            return null;
        }
    }



}
