package com.racing.model.stake;

import java.math.BigDecimal;

public class StakeCountInfoVo {

  private BigDecimal totalStakeAmount;

  private Integer totalStakeCount;

  public BigDecimal getTotalStakeAmount() {
    return totalStakeAmount;
  }

  public void setTotalStakeAmount(BigDecimal totalStakeAmount) {
    this.totalStakeAmount = totalStakeAmount;
  }

  public Integer getTotalStakeCount() {
    return totalStakeCount;
  }

  public void setTotalStakeCount(Integer totalStakeCount) {
    this.totalStakeCount = totalStakeCount;
  }

}
