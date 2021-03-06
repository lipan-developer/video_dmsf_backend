package com.dmsf.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:46
 * @Description:
 */
@Entity
@Table(name = "t_dmsf_video_info")
public class DmsfVideoInfo {

    @Id
    private String tableKey;
    private String title;
    private String actor;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date showTime;
    private String describeInfo;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private String picture;
    private String type;
    private Integer support;
    @Transient
    private List<VideoSalveInfo> salves;

    private String smallDescible;

    public String getSmallDescible() {
        return smallDescible;
    }

    public void setSmallDescible(String smallDescible) {
        this.smallDescible = smallDescible;
    }

    public String getTableKey() {
        return tableKey;
    }
    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getDescribeInfo() {
        return describeInfo;
    }

    public void setDescribeInfo(String describeInfo) {
        this.describeInfo = describeInfo;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public List<VideoSalveInfo> getSalves() {
        return salves;
    }

    public void setSalves(List<VideoSalveInfo> salves) {
        this.salves = salves;
    }
}
