package com.lyj.sms.controller;

import com.lyj.sms.bean.Achievement;
import com.lyj.sms.constans.Constants;
import com.lyj.sms.service.AchievementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成绩Controller.
 * Created by lunyujie on 2017/3/28.
 */
@Controller
@RequestMapping("/achievement")
public class AchievementController {
    /**
     * 注入成绩服务.
     */
    @Resource
    private AchievementService achievementService;

    /**
     * 得到成绩列表.
     *
     * @param schoolYear 学年
     * @param modelMap   model
     * @return 成绩列表
     */
    @RequestMapping(value = "/listAchievement", method = RequestMethod.GET)
    public String listAchievement(@RequestParam(value = "schoolYear", required = false) String schoolYear, ModelMap modelMap) {
        List<Achievement> list = achievementService.getAchievementList(schoolYear);
        modelMap.put("list", list);
        modelMap.put("mapLevels", Constants.getMapLevels());
        return "achievement/listAchievementPage";
    }

    /**
     * 跳转到编辑页面.
     *
     * @param id       id
     * @param modelMap model
     * @return 编辑界面
     */
    @RequestMapping(value = "/editAchievement", method = RequestMethod.GET)
    public String editAchievement(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        if (null != id) {
            Achievement achievement = achievementService.getAchievement(id);
            modelMap.put("achievement", achievement);
        }
        modelMap.put("mapLevels", Constants.getMapLevels());
        return "achievement/editAchievementPage";
    }

    /**
     * 保存成绩.
     *
     * @param achievement 成绩
     * @return 成绩列表
     */
    @RequestMapping(value = "/saveAchievement", method = RequestMethod.POST)
    public String saveAchievement(Achievement achievement) {
        achievementService.saveAchievement(achievement);
        return "redirect:/achievement/listAchievement";
    }

    /**
     * 删除成绩.
     *
     * @param id 成绩id
     * @return 成绩列表
     */
    @RequestMapping(value = "/removeAchievement", method = RequestMethod.GET)
    public String removeAchievement(@RequestParam(value = "id") Long id) {
        achievementService.removeAchievement(id);
        return "redirect:/achievement/listAchievement";
    }
}
