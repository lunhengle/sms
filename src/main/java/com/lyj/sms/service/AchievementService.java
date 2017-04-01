package com.lyj.sms.service;

import com.lyj.sms.bean.Achievement;

import java.util.List;
import java.util.Map;

/**
 * 成绩service.
 * Created by lunyujie on 2017/3/23.
 */
public interface AchievementService {
    /**
     * 根据id 得到成绩.
     *
     * @param id 成绩id
     * @return 成绩
     */
    Achievement getAchievement(final Long id);

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
    void removeAchievement(final Long id);

    /**
     * 根据成绩学年获取成绩.
     *
     * @param schoolYear 学年
     * @return 成绩列表
     */
    List<Map<String,Object>> getAchievementList(final String schoolYear);
    /**
     * 根据用户ID获取成绩.
     *
     * @param userId 用户id
     * @return 成绩列表
     */
    List<Achievement> getAchievementList(final Long userId);
    /**
     * 获取成绩个数.
     *
     * @return 成绩数
     */
    Long getAchievementCount();
}
