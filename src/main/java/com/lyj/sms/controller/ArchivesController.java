package com.lyj.sms.controller;

import com.lyj.sms.bean.Archives;
import com.lyj.sms.constans.Constants;
import com.lyj.sms.service.ArchivesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 档案controller.
 * Created by lunyujie on 2017/3/28.
 */
@Controller
@RequestMapping("/archives")
public class ArchivesController {
    /**
     * 注入档案service.
     */
    @Resource
    private ArchivesService archivesService;

    /**
     * 档案list.
     *
     * @param schoolName 学校名
     * @param modelMap   model
     * @return 跳转到档案列表页面
     */
    @RequestMapping(value = "/listArchives", method = RequestMethod.GET)
    public String listArchives(@RequestParam(value = "schoolName", required = false) String schoolName, ModelMap modelMap) {
        List<Archives> list = archivesService.getArchivesList(schoolName);
        modelMap.put("list", list);
        modelMap.put("mapLevels", Constants.getMapLevels());
        return "archives/listArchivesPage";
    }

    /**
     * 跳转到编辑档案界面.
     *
     * @param id       档案id
     * @param modelMap model
     * @return 编辑档案界面
     */
    @RequestMapping(value = "/editArchives", method = RequestMethod.GET)
    public String editArchives(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        if (null != id) {
            Archives archives = archivesService.getArchives(id);
            modelMap.put("archives", archives);
        }
        modelMap.put("mapLevels", Constants.getMapLevels());
        return "archives/editArchivesPage";
    }

    /**
     * 保存档案.
     *
     * @param archives 档案
     * @return 档案列表界面
     */
    @RequestMapping(value = "/saveArchives", method = RequestMethod.POST)
    public String saveArchives(Archives archives) {
        archivesService.saveArchives(archives);
        return "redirect:/archives/listArchives";
    }

    /**
     * 删除档案信息.
     *
     * @param id 档案id
     * @return 档案列表页面
     */
    @RequestMapping(value = "/removeArchives", method = RequestMethod.GET)
    public String removeArchives(@RequestParam(value = "id") long id) {
        archivesService.removeArchives(id);
        return "redirect:/archives/listArchives";
    }
}
