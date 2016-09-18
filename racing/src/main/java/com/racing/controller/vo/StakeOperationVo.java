package com.racing.controller.vo;

import java.util.Date;

public class StakeOperationVo {

  private String racingNum;

  private Integer[] result;

  private Date startTime;

  private Date serverTime;

  private Date endStakeTime;

  private Date startModifyTime;

  private Date endModifyTime;

  private Boolean isCanStake;

  private Boolean isCanModifyResult;

  public String getRacingNum() {
    return racingNum;
  }

  public void setRacingNum(String racingNum) {
    this.racingNum = racingNum;
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

  public Boolean getIsCanStake() {
    return isCanStake;
  }

  public void setIsCanStake(Boolean isCanStake) {
    this.isCanStake = isCanStake;
  }

  public Boolean getIsCanModifyResult() {
    return isCanModifyResult;
  }

  public void setIsCanModifyResult(Boolean isCanModifyResult) {
    this.isCanModifyResult = isCanModifyResult;
  }

  public Integer[] getResult() {
    return result;
  }

  public void setResult(Integer[] result) {
    this.result = result;
  }

  public Date getEndStakeTime() {
    return endStakeTime;
  }

  public void setEndStakeTime(Date endStakeTime) {
    this.endStakeTime = endStakeTime;
  }

  public Date getStartModifyTime() {
    return startModifyTime;
  }

  public void setStartModifyTime(Date startModifyTime) {
    this.startModifyTime = startModifyTime;
  }

  public Date getEndModifyTime() {
    return endModifyTime;
  }

  public void setEndModifyTime(Date endModifyTime) {
    this.endModifyTime = endModifyTime;
  }

}
