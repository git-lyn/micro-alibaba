package com.lyn.myfactory;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 图灵自定义谓词工厂,业务模拟12306 晚上23:00到凌晨6:00不能购票
 * Created by smlz on 2019/12/16.
 */
//@Component
public class TulingTimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public TulingTimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {

        LocalTime startTime = config.getStartTime();

        LocalTime endTime = config.getEndTime();

        return new Predicate<ServerWebExchange>(){
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                LocalTime now = LocalTime.now();

                return now.isAfter(startTime) && now.isBefore(endTime);
            }
        };

    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("startTime", "endTime");
    }

    public static void main(String[] args) {
        System.out.println( LocalTime.now());
    }

}
