package com.lyj.sms.bean;

import java.sql.Date;

/**
 * 成绩实体类.
 * Created by lunyujie on 2017/3/23.
 */
public class Achievement {
    /**
     * id.
     */
    private long id;
    /**
     * 个人id.
     */
    private long userId;
    /**
     * 学科.
     */
    private String subject;
    /**
     * 学年.
     */
    private String schoolYear;
    /**
     * 成绩.
     */
    private long achievement;
    /**
     * 等级 1 不合格 2 合格 3 良好 4 优秀.
     */
    private int level;
    /**
     * 创建时间.
     */
    private Date created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public long getAchievement() {
        return achievement;
    }

    public void setAchievement(long achievement) {
        this.achievement = achievement;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
