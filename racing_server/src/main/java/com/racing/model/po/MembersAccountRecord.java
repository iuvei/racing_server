package com.racing.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class MembersAccountRecord {
    private Integer id;

    private Integer membersId;

    private String type;

    private BigDecimal operationPoints;

    private BigDecimal resultPoints;

    private Date operationTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getOperationPoints() {
        return operationPoints;
    }

    public void setOperationPoints(BigDecimal operationPoints) {
        this.operationPoints = operationPoints;
    }

    public BigDecimal getResultPoints() {
        return resultPoints;
    }

    public void setResultPoints(BigDecimal resultPoints) {
        this.resultPoints = resultPoints;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}