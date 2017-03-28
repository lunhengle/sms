package com.lyj.sms;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.lyj.sms.config.javaConfig.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by lunyujie on 2016/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
public class TestJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc() {
        String sql = "SELECT * FROM USER";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map.get("id").toString() + map.get("username") + map.get("password"));
        }
    }
}
