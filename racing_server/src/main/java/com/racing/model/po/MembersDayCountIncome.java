package com.racing.model.po;

import java.math.BigDecimal;

public class MembersDayCountIncome {
    private Integer id;

    private String membersId;

    private BigDecimal stakeAmount;

    private BigDecimal incomeAmount;

    private BigDecimal deficitAmount;

    private Integer stakeCount;

    private String day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMembersId() {
        return membersId;
    }

    public void setMembersId(String membersId) {
        this.membersId = membersId;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}