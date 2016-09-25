package com.racing.controller.vo.manager;

import java.math.BigDecimal;

public class UserPointInfoVo {

  private Integer id;

  private String userName;

  private String nickName;

  private BigDecimal totalPoints;

  private BigDecimal userPoints;

  private BigDecimal membersPoints;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

}
