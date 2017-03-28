package com.lyj.sms;

import com.lyj.sms.bean.User;
import com.lyj.sms.config.javaConfig.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.lyj.sms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lunyujie on 2016/11/14.
 * 测试 注解配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
public class TestConfig {
    private static final Logger logger = LoggerFactory.getLogger(TestConfig.class);

    @Autowired
    private UserService userService;

    @Test
    public void testAppConfig() {
        User user = userService.getUser(1L);
        logger.info(user.getName());
    }

}
