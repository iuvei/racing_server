package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class DayCountStake {
    private Integer id;

    private String day;

    private BigDecimal totalStakeAmount;

    private BigDecimal totalDeficitAmount;

    private Integer totalStakeCount;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public BigDecimal getTotalStakeAmount() {
        return totalStakeAmount;
    }

    public void setTotalStakeAmount(BigDecimal totalStakeAmount) {
        this.totalStakeAmount = totalStakeAmount;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}