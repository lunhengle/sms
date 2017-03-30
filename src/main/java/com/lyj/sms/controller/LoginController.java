package com.lyj.sms.controller;

import com.lyj.sms.bean.User;
import com.lyj.sms.service.AchievementService;
import com.lyj.sms.service.ArchivesService;
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
     * 注入个人服务.
     */
    @Autowired
    private UserService userService;
    /**
     * 注入成绩service.
     */
    @Autowired
    private AchievementService achievementService;
    /**
     * 注入档案service.
     */
    @Autowired
    private ArchivesService archivesService;

    /**
     * 登陆.
     *
     * @param username           个人名
     * @param password           密码
     * @param modelMap           model
     * @param httpServletRequest 请求
     * @return 主页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") final String username,
                        @RequestParam(value = "password") final String password,
                        ModelMap modelMap, HttpServletRequest httpServletRequest) {
        logger.debug("login:" + "username :" + username);
        User user = userService.getUserByTelephone(username);
        if (null == user) {
            modelMap.put("message", "当前用户不存在！");
            return "login";
        } else if (!user.getPassword().equals(password)) {
            modelMap.put("message", "密码错误！");
            return "login";
        } else {
            httpServletRequest.getSession().setAttribute("userId", user.getId());
            httpServletRequest.getSession().setAttribute("roleCode", user.getRoleCode());
            modelMap.put("archivesCount", archivesService.getArchivesCount());
            modelMap.put("achievementCount", achievementService.getAchievementCount());
            return "index";
        }
    }

    /**
     * 退出系统.
     *
     * @param httpServletRequest 请求
     * @return 退出到登陆界面
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("userId", null);
        return "login";
    }

    /**
     * 跳转到找回密码界面.
     *
     * @return 找回密码
     */
    @RequestMapping(value = "/findPassword")
    public String findPassword() {
        return "findPassword";
    }

    /**
     * 跳转到首页.
     *
     * @param modelMap model
     * @return 首页
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap) {
        modelMap.put("archivesCount", archivesService.getArchivesCount());
        modelMap.put("achievementCount", achievementService.getAchievementCount());
        return "index";
    }

    /**
     * 重置密码.
     *
     * @param password           密码
     * @param httpServletRequest 请求
     * @return 首页
     */
    @RequestMapping(value = "/savePassword")
    public String savePassword(@RequestParam(value = "password") final String password, HttpServletRequest httpServletRequest) {
        Long userId = (Long) httpServletRequest.getSession().getAttribute("userId");
        User user = userService.getUser(userId);
        user.setPassword(password);
        userService.saveUser(user);
        return "login";
    }

}
