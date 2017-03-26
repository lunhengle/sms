package com.lyj.sms.config;

import com.lyj.sms.config.javaConfig.AppConfig;
import com.lyj.sms.config.javaConfig.MvcConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * servlet 3.0 替代web.xml java config 实现方式.
 * Created by lunyujie on 2016/11/14.
 */
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 设置日志.
     */
    private final static Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("系统初始化加载开始!");
        super.onStartup(servletContext);
        this.initializerContext(servletContext);
    }

    /**
     * 配置 spring context.
     *
     * @return spring context
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("加载root config");
        return new Class<?>[]{AppConfig.class};
    }

    /**
     * 配置 servlet context.
     *
     * @return servlet context
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("加载servlet Config");
        return new Class<?>[]{MvcConfig.class};
    }

    /**
     * 配置 servlet mappings.
     *
     * @return servlet mappings
     */
    @Override
    protected String[] getServletMappings() {
        logger.info("加载 servlet mappings");
        return new String[]{"/"};
    }

    /**
     * 配置过滤器.
     *
     * @return 过滤器集合
     */
    @Override
    protected Filter[] getServletFilters() {
        //去掉也没有乱码 暂时注释掉 等到项目中出现错误了 在看看
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //设置编码格式
        characterEncodingFilter.setEncoding("UTF-8");
        //是否允许设置的encoding覆盖request response 已经存在的encodings
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }

    /**
     * 初始化参数.
     *
     * @param servletContext servlet 上下文
     */
    private void initializerContext(ServletContext servletContext) {
        logger.info("初始化spring profiles");
        servletContext.setInitParameter("spring.profiles.default", "test");
        servletContext.setInitParameter("spring.profiles.active", "test");
    }

}
