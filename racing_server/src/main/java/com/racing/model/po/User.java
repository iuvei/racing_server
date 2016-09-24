package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private String nickName;

    private BigDecimal totalPoints;

    private BigDecimal userPoints;

    private BigDecimal membersPoints;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Date createTime;

    private Byte isEnable;

    private String clientSn;

    private Date clientExpireDate;

    private Byte clientIsEnable;

    private String webSecurityKey;

    private String webAccessKey;

    private Date webOutTime;

    private String clientSecurityKey;

    private String clientAccessKey;

    private Date clientOutTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    public BigDecimal getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(BigDecimal userPoints) {
        this.userPoints = userPoints;
    }

    public BigDecimal getMembersPoints() {
        return membersPoints;
    }

    public void setMembersPoints(BigDecimal membersPoints) {
        this.membersPoints = membersPoints;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public String getClientSn() {
        return clientSn;
    }

    public void setClientSn(String clientSn) {
        this.clientSn = clientSn;
    }

    public Date getClientExpireDate() {
        return clientExpireDate;
    }

    public void setClientExpireDate(Date clientExpireDate) {
        this.clientExpireDate = clientExpireDate;
    }

    public Byte getClientIsEnable() {
        return clientIsEnable;
    }

    public void setClientIsEnable(Byte clientIsEnable) {
        this.clientIsEnable = clientIsEnable;
    }

    public String getWebSecurityKey() {
        return webSecurityKey;
    }

    public void setWebSecurityKey(String webSecurityKey) {
        this.webSecurityKey = webSecurityKey;
    }

    public String getWebAccessKey() {
        return webAccessKey;
    }

    public void setWebAccessKey(String webAccessKey) {
        this.webAccessKey = webAccessKey;
    }

    public Date getWebOutTime() {
        return webOutTime;
    }

    public void setWebOutTime(Date webOutTime) {
        this.webOutTime = webOutTime;
    }

    public String getClientSecurityKey() {
        return clientSecurityKey;
    }

    public void setClientSecurityKey(String clientSecurityKey) {
        this.clientSecurityKey = clientSecurityKey;
    }

    public String getClientAccessKey() {
        return clientAccessKey;
    }

    public void setClientAccessKey(String clientAccessKey) {
        this.clientAccessKey = clientAccessKey;
    }

    public Date getClientOutTime() {
        return clientOutTime;
    }

    public void setClientOutTime(Date clientOutTime) {
        this.clientOutTime = clientOutTime;
    }
}