package com.lyj.sms.dao.impl;

import com.lyj.sms.dao.ArchivesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 档案dao实现类.
 * Created by lunyujie on 2017/3/23.
 */
@Repository
public class ArchivesDaoImpl implements ArchivesDao{
    /**
     * 注入jdbc.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
