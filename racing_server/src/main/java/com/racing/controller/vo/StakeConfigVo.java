package com.racing.controller.vo;

import java.math.BigDecimal;

import com.racing.model.stake.StakeVo;

public class StakeConfigVo {

  private String racingNum;

  private String preRacingNum;

  private Integer[] result;

  private Integer[] preResult;

  private Long endStakeTime;

  private Long startRacingTime;

  private Integer stage;
  
  private String stageName;

  private BigDecimal todayIncome;
  
  private BigDecimal totalRacingStakeAmount;
  
  private StakeVo stakeVo;

  public String getRacingNum() {
    return racingNum;
  }

  public void setRacingNum(String racingNum) {
    this.racingNum = racingNum;
  }

  public String getPreRacingNum() {
    return preRacingNum;
  }

  public void setPreRacingNum(String preRacingNum) {
    this.preRacingNum = preRacingNum;
  }

  public Integer[] getResult() {
    return result;
  }

  public void setResult(Integer[] result) {
    this.result = result;
  }

  public Integer[] getPreResult() {
    return preResult;
  }

  public void setPreResult(Integer[] preResult) {
    this.preResult = preResult;
  }

  public Long getEndStakeTime() {
    return endStakeTime;
  }

  public void setEndStakeTime(Long endStakeTime) {
    this.endStakeTime = endStakeTime;
  }

  public Long getStartRacingTime() {
    return startRacingTime;
  }

  public void setStartRacingTime(Long startRacingTime) {
    this.startRacingTime = startRacingTime;
  }

  public BigDecimal getTodayIncome() {
    return todayIncome;
  }

  public void setTodayIncome(BigDecimal todayIncome) {
    this.todayIncome = todayIncome;
  }

  public Integer getStage() {
    return stage;
  }

  public void setStage(Integer stage) {
    this.stage = stage;
  }

public String getStageName() {
	return stageName;
}

public void setStageName(String stageName) {
	this.stageName = stageName;
}

public StakeVo getStakeVo() {
	return stakeVo;
}

public void setStakeVo(StakeVo stakeVo) {
	this.stakeVo = stakeVo;
}

public BigDecimal getTotalRacingStakeAmount() {
	return totalRacingStakeAmount;
}

public void setTotalRacingStakeAmount(BigDecimal totalRacingStakeAmount) {
	this.totalRacingStakeAmount = totalRacingStakeAmount;
}

}
