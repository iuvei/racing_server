package com.racing.controller.vo;

public class LoginInfoVO {

  private String nickName;

  private String accessKey;

  private String securityKey;

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getSecurityKey() {
    return securityKey;
  }

  public void setSecurityKey(String securityKey) {
    this.securityKey = securityKey;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

}
