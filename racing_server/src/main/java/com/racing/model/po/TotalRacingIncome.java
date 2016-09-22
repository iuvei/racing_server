package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class TotalRacingIncome {
    private Integer id;

    private String racingNum;

    private BigDecimal stakeAmount;

    private BigDecimal incomeAmount;

    private BigDecimal deficitAmount;

    private Integer stakeCount;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRacingNum() {
        return racingNum;
    }

    public void setRacingNum(String racingNum) {
        this.racingNum = racingNum;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}