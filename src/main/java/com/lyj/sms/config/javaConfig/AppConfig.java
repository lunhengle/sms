package com.lyj.sms.config.javaConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring 配置文件.
 * Created by lunyujie on 2016/11/11.
 */
@Configuration
@PropertySource({"classpath:/properties/config.properties"})
@Import({DataConfig.class})
@ComponentScan({"com.lyj.sms.bean", "com.lyj.sms.dao", "com.lyj.sms.service"})
public class AppConfig {
}
