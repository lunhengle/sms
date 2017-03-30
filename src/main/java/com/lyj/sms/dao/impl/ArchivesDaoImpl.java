package com.lyj.sms.dao.impl;

import com.lyj.sms.bean.Archives;
import com.lyj.sms.dao.ArchivesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 档案dao实现类.
 * Created by lunyujie on 2017/3/23.
 */
@Repository
public class ArchivesDaoImpl implements ArchivesDao {
    /**
     * 注入jdbc.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id 得到档案.
     *
     * @param id 档案id
     * @return 档案
     */
    @Override
    public Archives getArchives(Long id) {
        if (this.getArchivesCountById(id)) {
            final String sql = "SELECT * FROM ARCHIVES WHERE ID = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Archives>() {
                public Archives mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return getMapRow(rs);
                }
            });
        } else {
            return null;
        }
    }

    /**
     * 获取当前值是否存在
     *
     * @param id id
     * @return true 存在 false 不存在
     */
    private boolean getArchivesCountById(final Long id) {
        boolean isTrue = true;
        final String sqlCount = "SELECT COUNT(1) FROM ARCHIVES WHERE ID = ?";
        int count = jdbcTemplate.queryForObject(sqlCount, new Object[]{id}, Integer.class);
        if (count == 0) {
            isTrue = false;
        }
        return isTrue;
    }


    /**
     * 保存档案.
     *
     * @param archives 档案
     */
    @Override
    public void saveArchives(Archives archives) {
        if (null != archives.getId()) { //更新
            final String sql = "UPDATE ARCHIVES SET COMMENTS = ?,GRADE = ?,LEVELS = ?,SCHOOL_ADDRESS = ?, SCHOOL_NAME = ?,TEACHER=? WHERE ID = ?";
            jdbcTemplate.update(sql, new Object[]{archives.getComments(), archives.getGrade(), archives.getLevels(), archives.getSchoolAddress(), archives.getSchoolName(), archives.getTeacher(), archives.getId()});
        } else { //插入
            long count = this.getArchivesCount();
            final String sql = "INSERT INTO ARCHIVES(ID,USER_ID,COMMENTS,GRADE,SCHOOL_ADDRESS,SCHOOL_NAME,TEACHER,LEVELS,CREATED)VALUES(?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, new Object[]{count + 1, archives.getUserId(), archives.getComments(), archives.getGrade(), archives.getSchoolAddress(), archives.getSchoolName(), archives.getTeacher(), archives.getLevels(), new Date()});
        }
    }

    /**
     * 根据id删除档案.
     *
     * @param id id
     */
    @Override
    public void removeArchives(Long id) {
        final String sql = "DELETE FROM ARCHIVES WHERE ID = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    /**
     * 根据档案名或者手机号获取档案.
     *
     * @param schoolName 学校名
     * @return 档案列表
     */
    @Override
    public List<Archives> getArchivesList(String schoolName) {
        String sql = "SELECT * FROM ARCHIVES WHERE 1 = 1 ";
        Object[] objects = new Object[]{};
        if (null != schoolName && "" != schoolName) {
            sql += " AND SCHOOL_NAME LIKE ? ";
            objects = new Object[]{"%" + schoolName + "%"};
        }
        return jdbcTemplate.query(sql, objects, new RowMapper<Archives>() {
            public Archives mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getMapRow(rs);
            }
        });
    }

    /**
     * 根据用户ID 获取档案信息.
     *
     * @param userId 用户ID
     * @return 用户档案信息
     */
    @Override
    public List<Archives> getArchivesList(Long userId) {
        String sql = "SELECT * FROM ARCHIVES WHERE USER_ID = ?";
        Object[] objects = new Object[]{userId};
        return jdbcTemplate.query(sql, objects, new RowMapper<Archives>() {
            public Archives mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getMapRow(rs);
            }
        });
    }

    /**
     * 获取档案个数.
     *
     * @return 档案个数
     */
    @Override
    public Long getArchivesCount() {
        final String sqlCount = "SELECT COUNT(1) FROM ARCHIVES";
        return jdbcTemplate.queryForObject(sqlCount, Long.class);
    }

    /**
     * 转换成Archives.
     *
     * @param rs 记录
     * @return 返货档案
     * @throws SQLException 异常信息
     */
    private Archives getMapRow(ResultSet rs) throws SQLException {
        Archives archives = new Archives();
        archives.setId(rs.getLong("ID"));
        archives.setComments(rs.getString("COMMENTS"));
        archives.setCreated(rs.getDate("CREATED"));
        archives.setGrade(rs.getString("GRADE"));
        archives.setLevels(rs.getInt("LEVELS"));
        archives.setSchoolAddress(rs.getString("SCHOOL_ADDRESS"));
        archives.setSchoolName(rs.getString("SCHOOL_NAME"));
        archives.setTeacher(rs.getString("TEACHER"));
        archives.setUserId(rs.getLong("USER_ID"));
        return archives;
    }
}
