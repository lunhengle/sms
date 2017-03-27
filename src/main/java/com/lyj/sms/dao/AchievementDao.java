package com.lyj.sms.dao;

import com.lyj.sms.bean.Achievement;

import java.util.List;

/**
 * 成绩 dao.
 * Created by lunhengle on 2017/3/23.
 */
public interface AchievementDao {
    /**
     * 根据id 得到成绩.
     *
     * @param id 成绩id
     * @return 成绩
     */
    Achievement getAchievement(final long id);

    /**
     * 保存成绩.
     *
     * @param achievement 成绩
     */
    void saveAchievement(final Achievement achievement);

    /**
     * 根据id删除成绩.
     *
     * @param id id
     */
    void removeAchievement(final long id);

    /**
     * 根据成绩学年获取成绩.
     *
     * @param schoolYear 学年
     * @return 成绩列表
     */
    List<Achievement> getAchievementList(final String schoolYear);

}
