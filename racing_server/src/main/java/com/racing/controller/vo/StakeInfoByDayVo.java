package com.racing.controller.vo;

import java.math.BigDecimal;

import com.racing.model.stake.StakeVo;

public class StakeInfoByDayVo {

	private String day;
	
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
