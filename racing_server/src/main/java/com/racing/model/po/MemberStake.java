package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class MemberStake {
    private Integer id;

    private Integer membersId;

    private String racingNum;

    private BigDecimal totalStakeAmount;

    private BigDecimal totalIncomeAmount;

    private BigDecimal totalDeficitAmount;

    private Integer totalStakeCount;

    private Boolean isComplateStatistics;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
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

    public Boolean getIsComplateStatistics() {
        return isComplateStatistics;
    }

    public void setIsComplateStatistics(Boolean isComplateStatistics) {
        this.isComplateStatistics = isComplateStatistics;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}