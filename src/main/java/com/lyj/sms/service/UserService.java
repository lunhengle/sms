package com.lyj.sms.service;

import com.lyj.sms.bean.User;

import java.util.List;

/**
 * 个人信息service接口.
 * Created by lunyujie on 2016/11/14.
 */
public interface UserService {
    /**
     * 根据id 得到个人.
     *
     * @param id 个人id
     * @return 个人
     */
    User getUser(final long id);

    /**
     * 保存个人.
     *
     * @param user 个人
     */
    void saveUser(final User user);

    /**
     * 根据id删除个人.
     *
     * @param id id
     */
    void removeUser(final long id);

    /**
     * 根据个人名获取个人.
     *
     * @param name 个人名
     * @return 个人列表
     */
    List<User> getUserList(final String name);
}
