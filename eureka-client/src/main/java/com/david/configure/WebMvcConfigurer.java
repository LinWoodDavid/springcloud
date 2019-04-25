package com.david.configure;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Spring MVC 配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    /**
     * 放行静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/static/font/");
        registry.addResourceHandler("/html/**").addResourceLocations("classpath:/static/html/");
        registry.addResourceHandler("/ico/**").addResourceLocations("classpath:/static/ico/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");

        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/favicon.ico");
    }

    /**
     * 处理中文乱码
     *
     * @return
     */
/*    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }*/

    //使用阿里 FastJson 作为JSON MessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        //config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);//保留空的字段
        //SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
        //SerializerFeature.WriteNullNumberAsZero//Number null -> 0
        // 按需配置，更多参考FastJson文档哈
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        converters.add(converter);
    }

}
