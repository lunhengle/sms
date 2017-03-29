package com.lyj.sms.controller;

import com.lyj.sms.bean.User;
import com.lyj.sms.constans.Constants;
import com.lyj.sms.service.AchievementService;
import com.lyj.sms.service.ArchivesService;
import com.lyj.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 个人信息controller.
 * Created by lunyujie on 2016/11/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 注入个人信息service.
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
     * 个人列表信息.
     *
     * @param name     个人名
     * @param modelMap model
     * @return 跳转到个人列表页面
     */
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String getListUser(@RequestParam(value = "name", required = false) String name, ModelMap modelMap) {
        List list = userService.getUserList(name);
        modelMap.put("list", list);
        return "users/listUserPage";
    }

    /**
     * 编辑个人信息.
     *
     * @param id       个人ID
     * @param modelMap model
     * @return 跳转到编辑个人界面
     */
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        if (null != id) {
            User user = userService.getUser(id);
            modelMap.put("user", user);
        }
        return "users/editUserPage";
    }

    /**
     * 保存个人信息.
     *
     * @param user 个人
     * @return 跳转到个人列表页面
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/user/listUser";
    }

    /**
     * 删除个人信息.
     *
     * @param id 个人id
     * @return 跳转到个人列表页面
     */
    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    public String removeUser(@RequestParam(value = "id") Long id) {
        userService.removeUser(id);
        return "redirect:/user/listUser";
    }

    /**
     * 查看个人信息.
     *
     * @param id       个人ID
     * @param modelMap model
     * @return 跳转到个人信息页面
     */
    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String showUser(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        User user = userService.getUser(id);
        modelMap.put("user", user);
        modelMap.put("archivesList", archivesService.getArchivesList(id));
        modelMap.put("achievementList", achievementService.getAchievementList(id));
        modelMap.put("mapLevels", Constants.getMapLevels());
        return "users/showUserPage";
    }
}
