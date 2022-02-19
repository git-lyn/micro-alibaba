package com.lyn.myfactory;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-10 14:09
 **/
@Component
public class MyTimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public MyTimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    /**
     * 进行判断处理
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {

        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                LocalTime now = LocalTime.now();
                return now.isAfter(config.getStartTime()) && now.isBefore(config.getEndTime());
            }
        };
    }

    /**
     * 用于接收yml中的配置 - TimeBetween=上午7:00,下午11:00
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("startTime","endTime");
    }


}
