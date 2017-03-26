package com.lyj.sms.bean;

import java.sql.Date;

/**
 * 个人实体类.
 * Created by lunyujie on 2016/11/14.
 */
public class User {
    /**
     * ID.
     */
    private long id;
    /**
     * 个人名.
     */
    private String name;
    /**
     * 密码.
     */
    private String password;
    /**
     * 身份证号.
     */
    private String idCards;
    /**
     * 电话.
     */
    private String telephone;
    /**
     * 邮件.
     */
    private String email;
    /**
     * 地址.
     */
    private String address;
    /**
     * 个人状态 0 禁用 1 启用.
     */
    private int status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCards() {
        return idCards;
    }

    public void setIdCards(String idCards) {
        this.idCards = idCards;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}
