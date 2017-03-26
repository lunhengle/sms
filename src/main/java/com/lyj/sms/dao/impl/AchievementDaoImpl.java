package com.lyj.sms.dao.impl;

import com.lyj.sms.dao.AchievementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 成绩dao实现类.
 * Created by lunhengle on 2017/3/23.
 */
@Repository
public class AchievementDaoImpl implements AchievementDao {
    /**
     * 注入jdbc.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
