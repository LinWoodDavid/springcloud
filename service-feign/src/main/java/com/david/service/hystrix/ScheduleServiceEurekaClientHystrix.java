package com.david.service.hystrix;

import com.david.model.UserInfo;
import com.david.service.ScheduleServiceEurekaClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * =================================
 * Created by David on 2019/4/24.
 * mail:    17610897521@163.com
 * 描述:    实现ScheduleServiceEurekaClient 接口，并注入到Ioc容器中
 */
@Component
public class ScheduleServiceEurekaClientHystrix implements ScheduleServiceEurekaClient {

    @Override
    public String sayHelloFromClientOne(String name) {
        return "sorry " + name;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> list = new ArrayList<>();
        return list;
    }
}
