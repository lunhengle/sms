package com.lyj.sms.controller;

import com.lyj.sms.bean.User;
import com.lyj.sms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
     * 注入用户服务.
     */
    @Autowired
    private UserService userService;

    /**
     * 登陆.
     *
     * @param username 个人名
     * @param password 密码
     * @param modelMap model
     * @return 主页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        ModelMap modelMap, HttpServletRequest httpServletRequest) {
        logger.debug("login:" + "username :" + username + " password :" + password);
        User user = userService.getUserByTelephone(username);
        if (null == user) {
            modelMap.put("message", "当前用户不存在！");
            return "login";
        } else if (!user.getPassword().equals(password)) {
            modelMap.put("message", "密码错误！");
            return "login";
        } else {
            httpServletRequest.getSession().setAttribute("userId", user.getId());
            return "index";
        }
    }

}
