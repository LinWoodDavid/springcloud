package com.david.configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * =================================
 * Created by David on 2019/4/24.
 * mail:    17610897521@163.com
 * 描述:      Zuul 进行服务过滤，做一些安全验证
 */
@Component
public class ServerFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ServerFilter.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，
     * 在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run：过滤器的具体逻辑。
     * 可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }
            return null;
        }
        logger.info("ok");
        return null;
    }

}
