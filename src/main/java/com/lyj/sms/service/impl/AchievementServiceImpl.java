package com.lyj.sms.service.impl;

import com.lyj.sms.bean.Achievement;
import com.lyj.sms.dao.AchievementDao;
import com.lyj.sms.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 成绩service实现类.
 * Created by lunhengle on 2017/3/23.
 */
@Service
public class AchievementServiceImpl implements AchievementService {
    /**
     * 成绩dao.
     */
    @Autowired
    private AchievementDao achievementDao;

    /**
     * 根据id 得到成绩.
     *
     * @param id 成绩id
     * @return 成绩
     */
    @Override
    public Achievement getAchievement(long id) {
        return achievementDao.getAchievement(id);
    }

    /**
     * 保存成绩.
     *
     * @param achievement 成绩
     */
    @Override
    public void saveAchievement(Achievement achievement) {
        achievementDao.saveAchievement(achievement);
    }

    /**
     * 根据id删除成绩.
     *
     * @param id id
     */
    @Override
    public void removeAchievement(long id) {
        achievementDao.removeAchievement(id);
    }

    /**
     * 根据成绩学年获取成绩.
     *
     * @param schoolYear 学年
     * @return 成绩列表
     */
    @Override
    public List<Achievement> getAchievementList(String schoolYear) {
        return achievementDao.getAchievementList(schoolYear);
    }
}
