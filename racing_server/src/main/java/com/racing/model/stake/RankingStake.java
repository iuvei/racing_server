package com.racing.model.stake;

import java.math.BigDecimal;

public class RankingStake {

  private Integer rankingNum;

  private BigDecimal big;

  private BigDecimal small;

  private BigDecimal odd;

  private BigDecimal even;

  public Integer getRankingNum() {
    return rankingNum;
  }

  public void setRankingNum(Integer rankingNum) {
    this.rankingNum = rankingNum;
  }

  public BigDecimal getBig() {
    return big;
  }

  public void setBig(BigDecimal big) {
    this.big = big;
  }

  public BigDecimal getSmall() {
    return small;
  }

  public void setSmall(BigDecimal small) {
    this.small = small;
  }

  public BigDecimal getOdd() {
    return odd;
  }

  public void setOdd(BigDecimal odd) {
    this.odd = odd;
  }

  public BigDecimal getEven() {
    return even;
  }

  public void setEven(BigDecimal even) {
    this.even = even;
  }
}
