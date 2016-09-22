package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class UserRacingIncome {
    private Integer id;

    private Integer userId;

    private String racingNum;

    private BigDecimal totalStakeAmount;

    private BigDecimal userStakeAmount;

    private BigDecimal membersStakeAmount;

    private BigDecimal totalIncomeAmount;

    private BigDecimal userIncomeAmount;

    private BigDecimal membersIncomeAmount;

    private BigDecimal totalDeficitAmount;

    private BigDecimal userDeficitAmount;

    private BigDecimal membersDeficitAmount;

    private Integer totalStakeCount;

    private Integer userStakeCount;

    private Integer membersStakeCount;

    private Date createTime;

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

    public String getRacingNum() {
        return racingNum;
    }

    public void setRacingNum(String racingNum) {
        this.racingNum = racingNum;
    }

    public BigDecimal getTotalStakeAmount() {
        return totalStakeAmount;
    }

    public void setTotalStakeAmount(BigDecimal totalStakeAmount) {
        this.totalStakeAmount = totalStakeAmount;
    }

    public BigDecimal getUserStakeAmount() {
        return userStakeAmount;
    }

    public void setUserStakeAmount(BigDecimal userStakeAmount) {
        this.userStakeAmount = userStakeAmount;
    }

    public BigDecimal getMembersStakeAmount() {
        return membersStakeAmount;
    }

    public void setMembersStakeAmount(BigDecimal membersStakeAmount) {
        this.membersStakeAmount = membersStakeAmount;
    }

    public BigDecimal getTotalIncomeAmount() {
        return totalIncomeAmount;
    }

    public void setTotalIncomeAmount(BigDecimal totalIncomeAmount) {
        this.totalIncomeAmount = totalIncomeAmount;
    }

    public BigDecimal getUserIncomeAmount() {
        return userIncomeAmount;
    }

    public void setUserIncomeAmount(BigDecimal userIncomeAmount) {
        this.userIncomeAmount = userIncomeAmount;
    }

    public BigDecimal getMembersIncomeAmount() {
        return membersIncomeAmount;
    }

    public void setMembersIncomeAmount(BigDecimal membersIncomeAmount) {
        this.membersIncomeAmount = membersIncomeAmount;
    }

    public BigDecimal getTotalDeficitAmount() {
        return totalDeficitAmount;
    }

    public void setTotalDeficitAmount(BigDecimal totalDeficitAmount) {
        this.totalDeficitAmount = totalDeficitAmount;
    }

    public BigDecimal getUserDeficitAmount() {
        return userDeficitAmount;
    }

    public void setUserDeficitAmount(BigDecimal userDeficitAmount) {
        this.userDeficitAmount = userDeficitAmount;
    }

    public BigDecimal getMembersDeficitAmount() {
        return membersDeficitAmount;
    }

    public void setMembersDeficitAmount(BigDecimal membersDeficitAmount) {
        this.membersDeficitAmount = membersDeficitAmount;
    }

    public Integer getTotalStakeCount() {
        return totalStakeCount;
    }

    public void setTotalStakeCount(Integer totalStakeCount) {
        this.totalStakeCount = totalStakeCount;
    }

    public Integer getUserStakeCount() {
        return userStakeCount;
    }

    public void setUserStakeCount(Integer userStakeCount) {
        this.userStakeCount = userStakeCount;
    }

    public Integer getMembersStakeCount() {
        return membersStakeCount;
    }

    public void setMembersStakeCount(Integer membersStakeCount) {
        this.membersStakeCount = membersStakeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}