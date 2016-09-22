package com.racing.controller.vo;

import java.util.Date;

public class NewRacingResultVO {

  private Boolean isCanStart;

  private String racingNum;

  private Integer[] racingResult;

  private Date startTime;

  private Date serverTime;

  public Boolean getIsCanStart() {
    return isCanStart;
  }

  public void setIsCanStart(Boolean isCanStart) {
    this.isCanStart = isCanStart;
  }

  public String getRacingNum() {
    return racingNum;
  }

  public void setRacingNum(String racingNum) {
    this.racingNum = racingNum;
  }

  public Integer[] getRacingResult() {
    return racingResult;
  }

  public void setRacingResult(Integer[] racingResult) {
    this.racingResult = racingResult;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getServerTime() {
    return serverTime;
  }

  public void setServerTime(Date serverTime) {
    this.serverTime = serverTime;
  }

}
