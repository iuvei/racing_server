package com.racing.service.calc;

import java.math.BigDecimal;

public class CalcResultVo {

  private Integer[] racingResult;

  private Integer firstAddSecond;

  private Boolean isFirstSecondOdd;

  private Boolean isFirstSecondBig;

  private Boolean isFirstUp;

  private Boolean isSecondUp;

  private Boolean isThirdUp;

  private Boolean isFourthUp;

  private Boolean isFifthUp;

  private Boolean isComplateCalculation;

  private BigDecimal preResultAmount;

  private Integer[] preResult;

  public Integer[] getRacingResult() {
    return racingResult;
  }

  public void setRacingResult(Integer[] racingResult) {
    this.racingResult = racingResult;
  }

  public Integer getFirstAddSecond() {
    return firstAddSecond;
  }

  public void setFirstAddSecond(Integer firstAddSecond) {
    this.firstAddSecond = firstAddSecond;
  }

  public Boolean getIsFirstSecondOdd() {
    return isFirstSecondOdd;
  }

  public void setIsFirstSecondOdd(Boolean isFirstSecondOdd) {
    this.isFirstSecondOdd = isFirstSecondOdd;
  }

  public Boolean getIsFirstSecondBig() {
    return isFirstSecondBig;
  }

  public void setIsFirstSecondBig(Boolean isFirstSecondBig) {
    this.isFirstSecondBig = isFirstSecondBig;
  }

  public Boolean getIsFirstUp() {
    return isFirstUp;
  }

  public void setIsFirstUp(Boolean isFirstUp) {
    this.isFirstUp = isFirstUp;
  }

  public Boolean getIsSecondUp() {
    return isSecondUp;
  }

  public void setIsSecondUp(Boolean isSecondUp) {
    this.isSecondUp = isSecondUp;
  }

  public Boolean getIsThirdUp() {
    return isThirdUp;
  }

  public void setIsThirdUp(Boolean isThirdUp) {
    this.isThirdUp = isThirdUp;
  }

  public Boolean getIsFourthUp() {
    return isFourthUp;
  }

  public void setIsFourthUp(Boolean isFourthUp) {
    this.isFourthUp = isFourthUp;
  }

  public Boolean getIsFifthUp() {
    return isFifthUp;
  }

  public void setIsFifthUp(Boolean isFifthUp) {
    this.isFifthUp = isFifthUp;
  }

  public Boolean getIsComplateCalculation() {
    return isComplateCalculation;
  }

  public void setIsComplateCalculation(Boolean isComplateCalculation) {
    this.isComplateCalculation = isComplateCalculation;
  }

  public BigDecimal getPreResultAmount() {
    return preResultAmount;
  }

  public void setPreResultAmount(BigDecimal preResultAmount) {
    this.preResultAmount = preResultAmount;
  }

  public Integer[] getPreResult() {
    return preResult;
  }

  public void setPreResult(Integer[] preResult) {
    this.preResult = preResult;
  }

}
