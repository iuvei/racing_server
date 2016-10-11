package com.racing.controller.vo;

import com.racing.model.stake.StakeVo;

public class MemberStakeVo {

  private Integer memberId;

  private StakeVo stakeVo;

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public StakeVo getStakeVo() {
    return stakeVo;
  }

  public void setStakeVo(StakeVo stakeVo) {
    this.stakeVo = stakeVo;
  }

}
