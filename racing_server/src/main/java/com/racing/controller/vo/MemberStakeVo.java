package com.racing.controller.vo;

import com.racing.model.stake.StakeVo;

public class MemberStakeVo {

	private String wechatSn;

	private StakeVo stakeVo;

	public StakeVo getStakeVo() {
		return stakeVo;
	}

	public void setStakeVo(StakeVo stakeVo) {
		this.stakeVo = stakeVo;
	}

	public String getWechatSn() {
		return wechatSn;
	}

	public void setWechatSn(String wechatSn) {
		this.wechatSn = wechatSn;
	}

}
