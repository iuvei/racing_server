package com.racing.model.stake;

import java.util.List;

public class StakeVo {

	private String racingNum;
	
  /**
   * 指定车号的名次押注情况，有且仅有有10条记录
   */
  private List<AppointStake> appointStakeList;

  /**
   * 常规押注，1~5龙虎情况，冠亚和大小单双，冠亚和指定
   */
  private CommonStake commonStake;

  /**
   * 名次情况的大小单双押注
   */
  private List<RankingStake> rankingStakeList;

  public CommonStake getCommonStake() {
    return commonStake;
  }

  public void setCommonStake(CommonStake commonStake) {
    this.commonStake = commonStake;
  }

  public List<RankingStake> getRankingStakeList() {
    return rankingStakeList;
  }

  public void setRankingStakeList(List<RankingStake> rankingStakeList) {
    this.rankingStakeList = rankingStakeList;
  }

public String getRacingNum() {
	return racingNum;
}

public void setRacingNum(String racingNum) {
	this.racingNum = racingNum;
}

public List<AppointStake> getAppointStakeList() {
	return appointStakeList;
}

public void setAppointStakeList(List<AppointStake> appointStakeList) {
	this.appointStakeList = appointStakeList;
}

}
