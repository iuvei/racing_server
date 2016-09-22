package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class UserStake {
    private Integer id;

    private Integer userId;

    private String racingNum;

    private BigDecimal totalStakeAmount;

    private BigDecimal totalIncomeAmount;

    private BigDecimal totalDeficitAmount;

    private Integer totalStakeCount;

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

    public BigDecimal getTotalIncomeAmount() {
        return totalIncomeAmount;
    }

    public void setTotalIncomeAmount(BigDecimal totalIncomeAmount) {
        this.totalIncomeAmount = totalIncomeAmount;
    }

    public BigDecimal getTotalDeficitAmount() {
        return totalDeficitAmount;
    }

    public void setTotalDeficitAmount(BigDecimal totalDeficitAmount) {
        this.totalDeficitAmount = totalDeficitAmount;
    }

    public Integer getTotalStakeCount() {
        return totalStakeCount;
    }

    public void setTotalStakeCount(Integer totalStakeCount) {
        this.totalStakeCount = totalStakeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}