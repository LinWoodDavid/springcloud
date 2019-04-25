package com.david.service;

import com.david.model.UserInfo;
import com.david.service.hystrix.ScheduleServiceEurekaClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * =================================
 * Created by David on 2019/4/23.
 * mail:    17610897521@163.com
 * 描述:     定义一个feign接口，
 * 通过@ FeignClient（“服务名”），来指定调用哪个服务。
 * <p>
 * 基于service-feign工程进行改造
 * 需要在FeignClient的ScheduleServiceEurekaClient接口的注解中加上fallback的指定类: ScheduleServiceEurekaClientHystrix
 * ScheduleServiceEurekaClientHystrix需要实现ScheduleServiceEurekaClient 接口，并注入到Ioc容器中
 */


@FeignClient(value = "eureka-client", fallback = ScheduleServiceEurekaClientHystrix.class)
public interface ScheduleServiceEurekaClient {

    @RequestMapping("hello")
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping("findAll")
    List<UserInfo> findAll();
}
