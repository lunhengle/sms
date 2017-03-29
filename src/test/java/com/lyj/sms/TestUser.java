package com.lyj.sms;

import com.lyj.sms.bean.User;
import com.lyj.sms.config.javaConfig.AppConfig;
import com.lyj.sms.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试个人 servie.
 * Created by lunyujie on 2017/3/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
public class TestUser {
    /**
     * 注入个人service.
     */
    @Autowired
    private UserService userService;

    /**
     * 保存个人.
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("test");
        user.setPassword("123456");
        user.setIdCards("4105267777777777");
        user.setTelephone("15003838864");
        user.setEmail("helloWorld@163.com");
        user.setAddress("河南省郑州市惠济区");
        userService.saveUser(user);
        User user1 = userService.getUser(7L);
        Assert.assertEquals("test", user1.getName());
        Assert.assertEquals("河南省郑州市惠济区", user1.getAddress());
    }

    /**
     * 更新个人.
     */
    @Test
    public void testUpdateUser() {
        User user = userService.getUser(1L);
        user.setName("测试");
        userService.saveUser(user);
        User user1 = userService.getUser(1L);
        Assert.assertEquals("测试", user1.getName());
    }

    /**
     * 删除个人.
     */
    @Test
    public void testRemoveUser() {
        userService.removeUser(1L);
        User user = userService.getUser(1L);
        Assert.assertNull(user);
    }

    /**
     * 测试得到个人列表.
     */
    @Test
    public void testGetUserList() {
        List<User> list = userService.getUserList("");
        Assert.assertEquals(6, list.size());
        list = userService.getUserList("飞");
        Assert.assertEquals(1, list.size());
    }

    /**
     * 得到个人.
     */
    @Test
    public void testGetUser() {
        User user = userService.getUser(1L);
        Long l = 1L;
        Assert.assertEquals(l, user.getId());
    }

    /**
     * 根据手机号得到用户.
     */
    @Test
    public void testGetUserByTelephone() {
        User user = userService.getUserByTelephone("15003838864");
        Assert.assertNull(user);
        user=userService.getUserByTelephone("15000000000");
        Assert.assertNotNull(user);
    }
}
