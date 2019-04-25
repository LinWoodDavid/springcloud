package com.david.web;

import com.david.model.UserInfo;
import com.david.service.ScheduleServiceEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * =================================
 * Created by David on 2019/4/23.
 * mail:    17610897521@163.com
 * 描述:
 */
@RestController
public class ClientController {

    @Resource
    ScheduleServiceEurekaClient scheduleServiceEurekaClient;

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        String s = scheduleServiceEurekaClient.sayHelloFromClientOne(name);
        return s;
    }

    @RequestMapping("findAll")
    public List findAll(HttpServletRequest request) {
        List<UserInfo> list = scheduleServiceEurekaClient.findAll();
        return list;
    }
}
