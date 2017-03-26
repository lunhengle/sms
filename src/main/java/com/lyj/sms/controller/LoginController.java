package com.lyj.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登陆.
 * Created by lunyujie on 2016/12/5.
 */
@Controller
public class LoginController {
    /**
     * 日志.
     */
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登陆.
     *
     * @param username 个人名
     * @param password 密码
     * @return 主页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        logger.debug("login:" + "username :" + username + " password :" + password);
        return "index";
    }

}
