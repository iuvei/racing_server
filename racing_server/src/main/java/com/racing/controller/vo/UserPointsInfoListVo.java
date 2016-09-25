package com.racing.controller.vo;

import java.util.List;

public class UserPointsInfoListVo extends PageVo {

  private List<UserPointsInfoVO> userPointsInfoList;

  public List<UserPointsInfoVO> getUserPointsInfoList() {
    return userPointsInfoList;
  }

  public void setUserPointsInfoList(List<UserPointsInfoVO> userPointsInfoList) {
    this.userPointsInfoList = userPointsInfoList;
  }

}
