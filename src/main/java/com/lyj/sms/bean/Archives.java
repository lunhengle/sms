package com.lyj.sms.bean;

import java.sql.Date;

/**
 * 档案实体类.
 * Created by lunyujie on 2017/3/23.
 */
public class Archives {
    /**
     * id.
     */
    private Long id;
    /**
     * 个人id.
     */
    private Long userId;
    /**
     * 学校名称.
     */
    private String schoolName;
    /**
     * 学校地址.
     */
    private String schoolAddress;
    /**
     * 老师.
     */
    private String teacher;
    /**
     * 年级.
     */
    private String grade;
    /**
     * 评价.
     */
    private String comments;
    /**
     * 等级 1 不合格 2 合格 3 良好 4 优秀.
     */
    private int levels;
    /**
     * 创建时间.
     */
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
