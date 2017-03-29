package com.lyj.sms.dao.impl;

import com.lyj.sms.bean.Achievement;
import com.lyj.sms.dao.AchievementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 成绩dao实现类.
 * Created by lunyujie on 2017/3/23.
 */
@Repository
public class AchievementDaoImpl implements AchievementDao {
    /**
     * 注入jdbc.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id 得到成绩.
     *
     * @param id 成绩id
     * @return 成绩
     */
    @Override
    public Achievement getAchievement(Long id) {
        if (this.getAchievementCount(id)) {
            final String sql = "SELECT * FROM ACHIEVEMENT WHERE ID = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Achievement>() {
                public Achievement mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return getMapRow(rs);
                }
            });
        } else {
            return null;
        }
    }

    /**
     * 保存成绩.
     *
     * @param achievement 成绩
     */
    @Override
    public void saveAchievement(Achievement achievement) {
        if (null != achievement.getId()) { //更新
            final String sql = "UPDATE ACHIEVEMENT SET ACHIEVEMENT = ?,LEVELS = ?,SCHOOL_YEAR = ?, SUBJECT = ? WHERE ID = ?";
            jdbcTemplate.update(sql, new Object[]{achievement.getAchievement(), achievement.getLevels(), achievement.getSchoolYear(), achievement.getSubject(), achievement.getId()});
        } else { //插入
            final String sqlCount = "SELECT COUNT(1) FROM ACHIEVEMENT";
            int count = jdbcTemplate.queryForObject(sqlCount, Integer.class);
            final String sql = "INSERT INTO ACHIEVEMENT(ID,USER_ID,ACHIEVEMENT,LEVELS,SCHOOL_YEAR,SUBJECT,CREATED)VALUES(?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, new Object[]{count + 1, achievement.getUserId(), achievement.getAchievement(), achievement.getLevels(), achievement.getSchoolYear(), achievement.getSubject(), new Date()});
        }
    }

    /**
     * 根据id删除成绩.
     *
     * @param id id
     */
    @Override
    public void removeAchievement(Long id) {
        final String sql = "DELETE FROM ACHIEVEMENT WHERE ID = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    /**
     * 根据成绩学年获取成绩.
     *
     * @param schoolYear 学年
     * @return 成绩列表
     */
    @Override
    public List<Achievement> getAchievementList(String schoolYear) {
        String sql = "SELECT * FROM ACHIEVEMENT WHERE 1 = 1 ";
        Object[] objects = new Object[]{};
        if (null != schoolYear && "" != schoolYear) {
            sql += " AND SCHOOL_YEAR LIKE ? ";
            objects = new Object[]{"%" + schoolYear + "%"};
        }
        return jdbcTemplate.query(sql, objects, new RowMapper<Achievement>() {
            public Achievement mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getMapRow(rs);
            }
        });
    }

    /**
     * 根据用户ID获取成绩.
     *
     * @param userId 用户id
     * @return 成绩列表
     */
    @Override
    public List<Achievement> getAchievementList(Long userId) {
        String sql = "SELECT * FROM ACHIEVEMENT WHERE USER_ID = ?";
        Object[] objects = new Object[]{userId};
        return jdbcTemplate.query(sql, objects, new RowMapper<Achievement>() {
            public Achievement mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getMapRow(rs);
            }
        });
    }

    /**
     * 获取当前值是否存在
     *
     * @param id id
     * @return true 存在 false 不存在
     */
    private boolean getAchievementCount(final Long id) {
        boolean isTrue = true;
        final String sqlCount = "SELECT COUNT(1) FROM ACHIEVEMENT WHERE ID = ?";
        int count = jdbcTemplate.queryForObject(sqlCount, new Object[]{id}, Integer.class);
        if (count == 0) {
            isTrue = false;
        }
        return isTrue;
    }

    /**
     * 转换成成绩.
     *
     * @param rs 记录
     * @return 返货成绩
     * @throws SQLException 异常信息
     */
    private Achievement getMapRow(ResultSet rs) throws SQLException {
        Achievement achievement = new Achievement();
        achievement.setId(rs.getLong("ID"));
        achievement.setUserId(rs.getLong("USER_ID"));
        achievement.setAchievement(rs.getLong("ACHIEVEMENT"));
        achievement.setLevels(rs.getInt("LEVELS"));
        achievement.setSchoolYear(rs.getString("SCHOOL_YEAR"));
        achievement.setSubject(rs.getString("SUBJECT"));
        achievement.setCreated(rs.getDate("CREATED"));
        return achievement;
    }
}
