package com.racing.controller.vo.manager;

import java.util.Date;

public class ManagerInfoVo {

  private Integer id;

  private String userName;

  private String nickName;

  private String lastLoginIp;

  private Date lastLoginTime;

  private Boolean isEnable;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getLastLoginIp() {
    return lastLoginIp;
  }

  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public Boolean getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(Boolean isEnable) {
    this.isEnable = isEnable;
  }

}
