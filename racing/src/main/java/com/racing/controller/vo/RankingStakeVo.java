package com.racing.controller.vo;

import java.math.BigDecimal;

public class RankingStakeVo {
  private Integer id;

  private Integer rankingNum;

  private BigDecimal big = BigDecimal.ZERO;

  private BigDecimal small = BigDecimal.ZERO;

  private BigDecimal odd = BigDecimal.ZERO;

  private BigDecimal even = BigDecimal.ZERO;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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
