package com.racing.controller.vo;

import java.math.BigDecimal;

public class DayCountStakeVo {

  private String day;

  private Integer totalStakeCount;

  private BigDecimal totalStakeAmount;

  private BigDecimal totalDeficitAmount;

  private BigDecimal totalCommissionAmount;

  private BigDecimal totalIncomeAmount;

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public Integer getTotalStakeCount() {
    return totalStakeCount;
  }

  public void setTotalStakeCount(Integer totalStakeCount) {
    this.totalStakeCount = totalStakeCount;
  }

  public BigDecimal getTotalStakeAmount() {
    return totalStakeAmount;
  }

  public void setTotalStakeAmount(BigDecimal totalStakeAmount) {
    this.totalStakeAmount = totalStakeAmount;
  }

  public BigDecimal getTotalDeficitAmount() {
    return totalDeficitAmount;
  }

  public void setTotalDeficitAmount(BigDecimal totalDeficitAmount) {
    this.totalDeficitAmount = totalDeficitAmount;
  }

  public BigDecimal getTotalCommissionAmount() {
    return totalCommissionAmount;
  }

  public void setTotalCommissionAmount(BigDecimal totalCommissionAmount) {
    this.totalCommissionAmount = totalCommissionAmount;
  }

  public BigDecimal getTotalIncomeAmount() {
    return totalIncomeAmount;
  }

  public void setTotalIncomeAmount(BigDecimal totalIncomeAmount) {
    this.totalIncomeAmount = totalIncomeAmount;
  }

}
