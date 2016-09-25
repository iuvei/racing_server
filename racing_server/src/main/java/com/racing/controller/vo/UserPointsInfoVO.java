package com.racing.controller.vo;

import java.math.BigDecimal;

public class UserPointsInfoVO {

  private Integer userId;

  private String userName;

  private String nickName;

  private BigDecimal totalPoints;

  private BigDecimal userPoints;

  private BigDecimal membersPoints;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public BigDecimal getTotalPoints() {
    return totalPoints;
  }

  public void setTotalPoints(BigDecimal totalPoints) {
    this.totalPoints = totalPoints;
  }

  public BigDecimal getUserPoints() {
    return userPoints;
  }

  public void setUserPoints(BigDecimal userPoints) {
    this.userPoints = userPoints;
  }

  public BigDecimal getMembersPoints() {
    return membersPoints;
  }

  public void setMembersPoints(BigDecimal membersPoints) {
    this.membersPoints = membersPoints;
  }

}
