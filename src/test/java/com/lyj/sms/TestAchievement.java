package com.lyj.sms;

import com.lyj.sms.bean.Achievement;
import com.lyj.sms.config.javaConfig.AppConfig;
import com.lyj.sms.service.AchievementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成绩测试.
 * Created by lunhengle on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
public class TestAchievement {
    /**
     * 注入成绩服务.
     */
    @Resource
    public AchievementService achievementService;

    /**
     * 测试得到成绩.
     */
    @Test
    public void testGetAchievement() {
        Achievement achievement = achievementService.getAchievement(1);
        Assert.assertEquals(1, achievement.getId());
    }

    /**
     * 测试得到成绩列表.
     */
    @Test
    public void testGetAchievementList() {
        List<Achievement> achievementList = achievementService.getAchievementList("");
        Assert.assertEquals(15, achievementList.size());
        achievementList = achievementService.getAchievementList("第三");
        Assert.assertEquals(5, achievementList.size());
    }

    /**
     * 测试保存成绩.
     */
    @Test
    public void testSaveAchievement() {
        Achievement achievement = new Achievement();
        achievement.setSubject("语文");
        achievement.setSchoolYear("第二学年");
        achievement.setAchievement(100);
        achievement.setLevels(1);
        achievement.setUserId(1);
        achievementService.saveAchievement(achievement);
        Achievement achievement1 = achievementService.getAchievement(16l);
        Assert.assertEquals(16, achievement1.getId());
    }

    /**
     * 测试更新成绩.
     */
    @Test
    public void testUpdateAchievement() {
        Achievement achievement = achievementService.getAchievement(1l);
        achievement.setSchoolYear("第二学年");
        achievementService.saveAchievement(achievement);
        Achievement achievement1 = achievementService.getAchievement(1l);
        Assert.assertEquals("第二学年", achievement1.getSchoolYear());
    }

    /**
     * 测试删除成绩.
     */
    @Test
    public void testRemoveAchievement() {
        achievementService.removeAchievement(1l);
        Achievement achievement = achievementService.getAchievement(1l);
        Assert.assertNull(achievement);
    }
}
