package com.racing.controller.vo;

public class RecordResultVo {

	private String racingNum;
	
	private Integer[] result;
	
	private Integer firstAddSecond;

    private Boolean isFirstSecondBig;

    private Boolean isFirstSecondOdd;

    private Boolean isFirstUp;

    private Boolean isSecondUp;

    private Boolean isThirdUp;

    private Boolean isFourthUp;

    private Boolean isFifthUp;

	public Integer[] getResult() {
		return result;
	}

	public void setResult(Integer[] result) {
		this.result = result;
	}

	public Integer getFirstAddSecond() {
		return firstAddSecond;
	}

	public void setFirstAddSecond(Integer firstAddSecond) {
		this.firstAddSecond = firstAddSecond;
	}

	public Boolean getIsFirstSecondBig() {
		return isFirstSecondBig;
	}

	public void setIsFirstSecondBig(Boolean isFirstSecondBig) {
		this.isFirstSecondBig = isFirstSecondBig;
	}

	public Boolean getIsFirstSecondOdd() {
		return isFirstSecondOdd;
	}

	public void setIsFirstSecondOdd(Boolean isFirstSecondOdd) {
		this.isFirstSecondOdd = isFirstSecondOdd;
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

	public String getRacingNum() {
		return racingNum;
	}

	public void setRacingNum(String racingNum) {
		this.racingNum = racingNum;
	}
	
}
