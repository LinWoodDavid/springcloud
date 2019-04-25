package com.david.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * =================================
 * Created by David on 2019/4/25.
 * mail:    17610897521@163.com
 * 描述:
 */
@RestController
public class RouteController {

    String httpUri = "http://httpbin.org:80";

    /**
     * 创建路由
     * <p>
     * 在下面的myRoutes方法中，使用了一个RouteLocatorBuilder的bean去创建路由，
     * 除了创建路由RouteLocatorBuilder可以让你添加各种predicates和filters，
     * predicates断言的意思，顾名思义就是根据具体的请求的规则，由具体的route去处理，
     * filters是各种过滤器，用来对请求做各种判断和修改。
     * <p>
     * 下面创建的route可以让请求“/get”请求都转发到“http://httpbin.org/get”。
     * 在route配置上，添加了一个filter，
     * 该filter会将请求添加一个header,key为hello，value为world。
     * <p>
     * 启动项目浏览器访问 http://localhost:6085/get 可以看到添加的请求头 "Hello": "World"
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f ->
                                f.addRequestHeader("Hello", "World")
                                        .hystrix(config -> config.setName("mycmd")
                                                .setFallbackUri("forward:/fallback"))

                        )
                        .uri(httpUri))//开发中网络请求测试服务
                .build();
    }

    /**
     * Hystrix 的fallback 回调
     *
     * @return
     */
    @RequestMapping("/fallback")
    public String fallback() {
        return "fallback";
    }

}
