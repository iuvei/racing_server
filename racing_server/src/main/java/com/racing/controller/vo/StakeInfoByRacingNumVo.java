package com.racing.controller.vo;

import java.math.BigDecimal;
import java.util.List;

import com.racing.model.stake.StakeVo;

public class StakeInfoByRacingNumVo {

	private String racingNum;
	
	private Integer[] result;
	
	private int stakeCount;
	
	private BigDecimal stakeAmount;
	
	private BigDecimal incomeAmount;
	
	private BigDecimal deficitAmount;
	
	private StakeVo stakeVo;

	public int getStakeCount() {
		return stakeCount;
	}

	public void setStakeCount(int stakeCount) {
		this.stakeCount = stakeCount;
	}

	public BigDecimal getStakeAmount() {
		return stakeAmount;
	}

	public void setStakeAmount(BigDecimal stakeAmount) {
		this.stakeAmount = stakeAmount;
	}

	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public BigDecimal getDeficitAmount() {
		return deficitAmount;
	}

	public void setDeficitAmount(BigDecimal deficitAmount) {
		this.deficitAmount = deficitAmount;
	}

	public StakeVo getStakeVo() {
		return stakeVo;
	}

	public void setStakeVo(StakeVo stakeVo) {
		this.stakeVo = stakeVo;
	}

	public String getRacingNum() {
		return racingNum;
	}

	public void setRacingNum(String racingNum) {
		this.racingNum = racingNum;
	}

	public Integer[] getResult() {
		return result;
	}

	public void setResult(Integer[] result) {
		this.result = result;
	}

	
}
