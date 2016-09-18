package com.racing.controller.vo;

import java.util.List;


public class StakeVo {

  private String racing_num;

  private CommonStakeVo commonStake;

  private List<AppointStakeVo> appointStakeList;

  private List<RankingStakeVo> rankingStakeList;

  public String getRacing_num() {
    return racing_num;
  }

  public void setRacing_num(String racing_num) {
    this.racing_num = racing_num;
  }

  public CommonStakeVo getCommonStake() {
    return commonStake;
  }

  public void setCommonStake(CommonStakeVo commonStake) {
    this.commonStake = commonStake;
  }

  public List<AppointStakeVo> getAppointStakeList() {
    return appointStakeList;
  }

  public void setAppointStakeList(List<AppointStakeVo> appointStakeList) {
    this.appointStakeList = appointStakeList;
  }

  public List<RankingStakeVo> getRankingStakeList() {
    return rankingStakeList;
  }

  public void setRankingStakeList(List<RankingStakeVo> rankingStakeList) {
    this.rankingStakeList = rankingStakeList;
  }

}
