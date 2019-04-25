package com.david.web;

import com.david.model.UserInfo;
import com.david.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * =================================
 * Created by David on 2019/4/24.
 * mail:    17610897521@163.com
 * 描述:
 */
@RestController
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Value("${server.port}")
    String port;

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "david") String name) {
        String hello = "hello " + name + " ,i am from port:" + port;
        logger.info(hello);
        return hello;
    }

    @RequestMapping("/findAll")
    public List findAll(HttpServletRequest request) {
        List<UserInfo> list = userInfoService.findAll();
        return list;
    }
}
