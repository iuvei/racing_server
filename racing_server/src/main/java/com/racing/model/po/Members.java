package com.racing.model.po;

import java.math.BigDecimal;

public class Members {
    private Integer id;

    private Integer userId;

    private String wechatClientId;

    private String groupSn;

    private String wechatSn;

    private BigDecimal points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWechatClientId() {
        return wechatClientId;
    }

    public void setWechatClientId(String wechatClientId) {
        this.wechatClientId = wechatClientId;
    }

    public String getGroupSn() {
        return groupSn;
    }

    public void setGroupSn(String groupSn) {
        this.groupSn = groupSn;
    }

    public String getWechatSn() {
        return wechatSn;
    }

    public void setWechatSn(String wechatSn) {
        this.wechatSn = wechatSn;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}