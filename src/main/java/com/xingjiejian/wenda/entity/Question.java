package com.xingjiejian.wenda.entity;

import java.util.Date;

/**
 * 问题
 * @author
 */
public class Question {
    /**
     * 主键，问题编号
     */
    private Integer id;
    /**
     * 问题标题，不超过45字
     */
    private String title;
    /**
     * 问题描述，不超过500字
     */
    private String description;
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 图片
     */
    private String picture;
    /**
     * 分类id
     */
    private Integer categoryId;
    /**
     * 发表时间
     */
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", picture='" + picture + '\'' +
                ", categoryId=" + categoryId +
                ", time=" + time +
                '}';
    }
}
