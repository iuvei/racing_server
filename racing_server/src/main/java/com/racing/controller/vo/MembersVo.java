package com.racing.controller.vo;

import java.math.BigDecimal;

public class MembersVo {
    private Integer id;
    private Integer userId;

    private Integer wechatClientId;
    private String wechatSn;
    private String nickName;

    private BigDecimal points;
    private BigDecimal updatePoints;

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

    public Integer getWechatClientId() {
        return wechatClientId;
    }

    public void setWechatClientId(Integer wechatClientId) {
        this.wechatClientId = wechatClientId;
    }

    public String getWechatSn() {
        return wechatSn;
    }

    public void setWechatSn(String wechatSn) {
        this.wechatSn = wechatSn;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public BigDecimal getUpdatePoints() {
        return updatePoints;
    }

    public void setUpdatePoints(BigDecimal updatePoints) {
        this.updatePoints = updatePoints;
    }
}