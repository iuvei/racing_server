package com.racing.controller.vo;

public class MemberStakeVo {

  private Integer memberId;

  private String racingNum;

  private StakeVo stakeVo;

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public String getRacingNum() {
    return racingNum;
  }

  public void setRacingNum(String racingNum) {
    this.racingNum = racingNum;
  }

  public StakeVo getStakeVo() {
    return stakeVo;
  }

  public void setStakeVo(StakeVo stakeVo) {
    this.stakeVo = stakeVo;
  }

}
