package com.racing.model.po;

import java.math.BigDecimal;

public class TotalDayCountIncome {
    private Integer id;

    private String day;

    private BigDecimal stakeAmount;

    private BigDecimal incomeAmount;

    private BigDecimal deficitAmount;

    private Integer stakeCount;

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

    public BigDecimal getStakeAmount() {
        return stakeAmount;
    }

    public void setStakeAmount(BigDecimal stakeAmount) {
        this.stakeAmount = stakeAmount;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getDeficitAmount() {
        return deficitAmount;
    }

    public void setDeficitAmount(BigDecimal deficitAmount) {
        this.deficitAmount = deficitAmount;
    }

    public Integer getStakeCount() {
        return stakeCount;
    }

    public void setStakeCount(Integer stakeCount) {
        this.stakeCount = stakeCount;
    }
}