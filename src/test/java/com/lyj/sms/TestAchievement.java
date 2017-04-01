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
import java.util.Map;

/**
 * 成绩测试.
 * Created by lunyujie on 2027/3/27.
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
        Achievement achievement = achievementService.getAchievement(2L);
        Long l = 2L;
        Assert.assertEquals(l, achievement.getId());
    }

    /**
     * 测试得到成绩列表.
     */
    @Test
    public void testGetAchievementList() {
        List<Map<String,Object>> achievementList = achievementService.getAchievementList("");
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
        achievement.setAchievement(200);
        achievement.setLevels(2);
        achievement.setUserId(2L);
        achievementService.saveAchievement(achievement);
        Achievement achievement2 = achievementService.getAchievement(16L);
        Long l = 16L;
        Assert.assertEquals(l, achievement2.getId());
    }

    /**
     * 测试更新成绩.
     */
    @Test
    public void testUpdateAchievement() {
        Achievement achievement = achievementService.getAchievement(2L);
        achievement.setSchoolYear("第二学年");
        achievementService.saveAchievement(achievement);
        Achievement achievement2 = achievementService.getAchievement(2L);
        Assert.assertEquals("第二学年", achievement2.getSchoolYear());
    }

    /**
     * 测试删除成绩.
     */
    @Test
    public void testRemoveAchievement() {
        achievementService.removeAchievement(2L);
        Achievement achievement = achievementService.getAchievement(2L);
        Assert.assertNull(achievement);
    }

    /**
     * 根据用户id获取成绩.
     */
    @Test
    public void testGetAchievementListByUserId() {
        List<Achievement> achievementList = achievementService.getAchievementList(2L);
        Assert.assertNotNull(achievementList);
    }

    /**
     * 测试成绩个数.
     */
    @Test
    public void testGetAchievementCount() {
        long count = achievementService.getAchievementCount();
        Assert.assertNotNull(count);
    }
}
