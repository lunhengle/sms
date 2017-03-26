package com.lyj.sms.config.javaConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置spring mvc.
 * Created by lunyujie on 2016/11/14.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.lyj.sms.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 日志.
     */
    private final static Logger logger = LoggerFactory.getLogger(MvcConfig.class);

    /**
     * 重写编码格式.
     *
     * @param converters 编码格式集合
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        logger.info("设置首页 为login");
        registry.addViewController("/").setViewName("login");
    }

    /**
     * 设置 字符串编码格式为 utf-8.
     *
     * @return 字符串编码
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        Charset utf8 = Charset.forName("UTF-8");
        //默认设置 text/plain 为utf-8
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(utf8);
        //设置 text/html 为 utf-8
        MediaType mediaType = MediaType.parseMediaType("text/html;charset=UTF-8");
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(mediaType);
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return stringHttpMessageConverter;
    }

    /**
     * 设置json .
     *
     * @return json 转换器
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置 text/html 为 utf-8
        MediaType mediaTypeText = MediaType.parseMediaType("text/html;charset=UTF-8");
        MediaType mediaTypeJson = MediaType.parseMediaType("text/json;charset=UTF-8");
        MediaType mediaTypeApplication = MediaType.parseMediaType("application/json;charset=UTF-8");
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(mediaTypeText);
        mediaTypes.add(mediaTypeJson);
        mediaTypes.add(mediaTypeApplication);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return mappingJackson2HttpMessageConverter;
    }

    /**
     * 设置mvc 前后缀.
     *
     * @return mvc 视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        logger.info("设置mvc 前缀文件夹 views 后缀 .jsp");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 添加静态资源.
     *
     * @param registry 资源注册
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("设置 静态资源!");
        registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    }
}
