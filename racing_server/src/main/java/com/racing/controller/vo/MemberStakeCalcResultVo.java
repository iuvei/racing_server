package com.racing.controller.vo;

import java.math.BigDecimal;

public class MemberStakeCalcResultVo {

	private String wechatSn;
	
	private BigDecimal totalStakeAmount;

    private BigDecimal totalIncomeAmount;

    private BigDecimal totalDeficitAmount;

	public String getWechatSn() {
		return wechatSn;
	}

	public void setWechatSn(String wechatSn) {
		this.wechatSn = wechatSn;
	}

	public BigDecimal getTotalStakeAmount() {
		return totalStakeAmount;
	}

	public void setTotalStakeAmount(BigDecimal totalStakeAmount) {
		this.totalStakeAmount = totalStakeAmount;
	}

	public BigDecimal getTotalIncomeAmount() {
		return totalIncomeAmount;
	}

	public void setTotalIncomeAmount(BigDecimal totalIncomeAmount) {
		this.totalIncomeAmount = totalIncomeAmount;
	}

	public BigDecimal getTotalDeficitAmount() {
		return totalDeficitAmount;
	}

	public void setTotalDeficitAmount(BigDecimal totalDeficitAmount) {
		this.totalDeficitAmount = totalDeficitAmount;
	}
    
}
