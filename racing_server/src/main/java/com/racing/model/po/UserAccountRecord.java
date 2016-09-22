package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class UserAccountRecord {
    private Integer id;

    private Integer userId;

    private String type;

    private BigDecimal operationTotalPoints;

    private BigDecimal resultTotalPoints;

    private BigDecimal operationUserPoints;

    private BigDecimal resultUserPoints;

    private BigDecimal operationMembersPoints;

    private BigDecimal resultMembersPoints;

    private Date operationTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getOperationTotalPoints() {
        return operationTotalPoints;
    }

    public void setOperationTotalPoints(BigDecimal operationTotalPoints) {
        this.operationTotalPoints = operationTotalPoints;
    }

    public BigDecimal getResultTotalPoints() {
        return resultTotalPoints;
    }

    public void setResultTotalPoints(BigDecimal resultTotalPoints) {
        this.resultTotalPoints = resultTotalPoints;
    }

    public BigDecimal getOperationUserPoints() {
        return operationUserPoints;
    }

    public void setOperationUserPoints(BigDecimal operationUserPoints) {
        this.operationUserPoints = operationUserPoints;
    }

    public BigDecimal getResultUserPoints() {
        return resultUserPoints;
    }

    public void setResultUserPoints(BigDecimal resultUserPoints) {
        this.resultUserPoints = resultUserPoints;
    }

    public BigDecimal getOperationMembersPoints() {
        return operationMembersPoints;
    }

    public void setOperationMembersPoints(BigDecimal operationMembersPoints) {
        this.operationMembersPoints = operationMembersPoints;
    }

    public BigDecimal getResultMembersPoints() {
        return resultMembersPoints;
    }

    public void setResultMembersPoints(BigDecimal resultMembersPoints) {
        this.resultMembersPoints = resultMembersPoints;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}