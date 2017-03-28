package com.lyj.sms.dao;

import com.lyj.sms.bean.User;

import java.util.List;

/**
 * 个人dao 接口.
 * Created by lunyujie on 2016/11/14.
 */
public interface UserDao {
    /**
     * 根据id 得到个人.
     *
     * @param id 个人id
     * @return 个人
     */
    User getUser(final Long id);

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
    void removeUser(final Long id);

    /**
     * 根据个人名或者手机号获取个人.
     *
     * @param name      个人名
     * @return 个人列表
     */
    List<User> getUserList(final String name);
}
