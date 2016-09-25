package com.racing.controller.vo.manager;

import java.math.BigDecimal;
import java.util.Date;

public class UserPointsAppRecordVo {
  private Integer id;
  private BigDecimal appPoints;
  private String appComment;
  private Date appTime;
  private String operationComment;
  private Date operationTime;
  private String status;
  private Integer userId;
  private String userNickName;
  private String userUserName;

  public String getUserNickName() {
    return userNickName;
  }

  public void setUserNickName(String userNickName) {
    this.userNickName = userNickName;
  }

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

  public BigDecimal getAppPoints() {
    return appPoints;
  }

  public void setAppPoints(BigDecimal appPoints) {
    this.appPoints = appPoints;
  }

  public String getAppComment() {
    return appComment;
  }

  public void setAppComment(String appComment) {
    this.appComment = appComment;
  }

  public Date getAppTime() {
    return appTime;
  }

  public void setAppTime(Date appTime) {
    this.appTime = appTime;
  }

  public String getOperationComment() {
    return operationComment;
  }

  public void setOperationComment(String operationComment) {
    this.operationComment = operationComment;
  }

  public Date getOperationTime() {
    return operationTime;
  }

  public void setOperationTime(Date operationTime) {
    this.operationTime = operationTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUserUserName() {
    return userUserName;
  }

  public void setUserUserName(String userUserName) {
    this.userUserName = userUserName;
  }

}
