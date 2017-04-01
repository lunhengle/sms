package com.lyj.sms.service.impl;

import com.lyj.sms.bean.Achievement;
import com.lyj.sms.dao.AchievementDao;
import com.lyj.sms.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 成绩service实现类.
 * Created by lunyujie on 2017/3/23.
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
    public Achievement getAchievement(Long id) {
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
    public void removeAchievement(Long id) {
        achievementDao.removeAchievement(id);
    }

    /**
     * 根据成绩学年获取成绩.
     *
     * @param schoolYear 学年
     * @return 成绩列表
     */
    @Override
    public List<Map<String,Object>> getAchievementList(String schoolYear) {
        return achievementDao.getAchievementList(schoolYear);
    }

    /**
     * 根据用户ID获取成绩.
     *
     * @param userId 用户id
     * @return 成绩列表
     */
    @Override
    public List<Achievement> getAchievementList(Long userId) {
        return achievementDao.getAchievementList(userId);
    }

    /**
     * 获取成绩个数.
     *
     * @return 成绩数
     */
    @Override
    public Long getAchievementCount() {
        return achievementDao.getAchievementCount();
    }
}
