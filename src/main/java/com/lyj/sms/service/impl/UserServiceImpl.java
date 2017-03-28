package com.lyj.sms.service.impl;

import com.lyj.sms.bean.User;
import com.lyj.sms.dao.UserDao;
import com.lyj.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 个人service.
 * Created by lunyujie on 2016/11/14.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 注入dao.
     */
    @Autowired
    private UserDao userDao;


    /**
     * 根据id 得到个人.
     *
     * @param id 个人id
     * @return 个人
     */
    public final User getUser(final Long id) {
        return userDao.getUser(id);
    }

    /**
     * 保存个人.
     *
     * @param user 个人
     */
    @Override
    public void saveUser(final User user) {
        userDao.saveUser(user);
    }

    /**
     * 根据id删除个人.
     *
     * @param id id
     */
    @Override
    public void removeUser(final Long id) {
        userDao.removeUser(id);
    }

    /**
     * 根据个人名或者手机号获取个人.
     *
     * @param name 个人名
     * @return 个人列表
     */
    @Override
    public List<User> getUserList(final String name) {
        return userDao.getUserList(name);
    }
}
