package com.lyj.sms.dao.impl;

import com.lyj.sms.bean.User;
import com.lyj.sms.constans.Constants;
import com.lyj.sms.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 个人dao 实现类.
 * Created by lunyujie on 2016/11/14.
 */
@Repository
public class UserDaoImpl implements UserDao {
    /**
     * 注入jdbc.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id 得到个人.
     *
     * @param id 个人id
     * @return 个人
     */
    public final User getUser(final Long id) {
        if (this.getUserCount(id)) {
            final String sql = "SELECT * FROM USER WHERE ID = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return getMapRow(rs);
                }
            });
        } else {
            return null;
        }
    }

    /**
     * 保存个人.
     *
     * @param user 个人
     */
    @Override
    public void saveUser(final User user) {
        if (null != user.getId()) { //更新
            final String sql = "UPDATE USER SET NAME = ?,ID_CARDS = ?,TELEPHONE = ?,EMAIL = ?, ADDRESS = ? WHERE ID = ?";
            jdbcTemplate.update(sql, new Object[]{user.getName(), user.getIdCards(), user.getTelephone(), user.getEmail(), user.getAddress(), user.getId()});
        } else { //插入
            final String sqlCount = "SELECT COUNT(1) FROM USER";
            long count = jdbcTemplate.queryForObject(sqlCount, Long.class);
            final String sql = "INSERT INTO USER(ID,NAME,PASSWORD,ID_CARDS,TELEPHONE,EMAIL,ADDRESS,STATUS,ROLE_CODE,CREATED)VALUES(?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, new Object[]{count + 1, user.getName(), user.getPassword(), user.getIdCards(), user.getTelephone(), user.getEmail(), user.getAddress(), Constants.STATUS_ENABLE.getValue(),Constants.ROLE_CODE_NORMAL.getValue(), new Date()});
        }
    }

    /**
     * 获取当前值是否存在
     *
     * @param id id
     * @return true 存在 false 不存在
     */
    private boolean getUserCount(final Long id) {
        boolean isTrue = true;
        final String sqlCount = "SELECT COUNT(1) FROM USER WHERE ID = ?";
        int count = jdbcTemplate.queryForObject(sqlCount, new Object[]{id}, Integer.class);
        if (count == 0) {
            isTrue = false;
        }
        return isTrue;
    }

    /**
     * 根据id删除个人.
     *
     * @param id id
     */
    @Override
    public void removeUser(final Long id) {
        final String sql = "DELETE FROM USER WHERE ID = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    /**
     * 根据个人名或者手机号获取个人.
     *
     * @param name 个人名
     * @return 个人列表
     */
    @Override
    public List<User> getUserList(final String name) {
        String sql = "SELECT * FROM USER WHERE 1 = 1 AND ROLE_CODE = ?";
        Object[] objects = new Object[]{Constants.ROLE_CODE_NORMAL.getValue()};
        if (null != name && "" != name) {
            sql += " AND NAME LIKE ? ";
            objects = new Object[]{Constants.ROLE_CODE_NORMAL.getValue(), "%" + name + "%"};
        }
        return jdbcTemplate.query(sql, objects, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getMapRow(rs);
            }
        });
    }

    /**
     * 根据手机号获取用户.
     *
     * @param telephone 手机号
     * @return 用户
     */
    @Override
    public User getUserByTelephone(String telephone) {
        Object[] objects = new Object[]{telephone};
        String sqlCount = "SELECT COUNT(1) FROM USER WHERE TELEPHONE = ?";
        int count = jdbcTemplate.queryForObject(sqlCount, objects, Integer.class);
        if (0 != count) {
            String sql = "SELECT * FROM USER WHERE TELEPHONE = ?";
            return jdbcTemplate.queryForObject(sql, objects, new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return getMapRow(rs);
                }
            });
        } else {
            return null;
        }
    }

    /**
     * 转换成user.
     *
     * @param rs 记录
     * @return 返货个人
     * @throws SQLException 异常信息
     */
    private User getMapRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("ID"));
        user.setName(rs.getString("NAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setIdCards(rs.getString("ID_CARDS"));
        user.setTelephone(rs.getString("TELEPHONE"));
        user.setEmail(rs.getString("EMAIL"));
        user.setAddress(rs.getString("ADDRESS"));
        user.setStatus(rs.getInt("STATUS"));
        user.setRoleCode(rs.getInt("ROLE_CODE"));
        user.setCreated(rs.getDate("CREATED"));
        return user;
    }

}
