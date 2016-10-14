package com.racing.model.po.util;


import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.util.JsonUtils;

public class TotalDayStakeConvertUtil {

	public static StakeVo commontStakPoToVo(TotalDayCountIncomeWithBLOBs totalDayStakePo){
		StakeVo stakeVo = new StakeVo();
		stakeVo.setAppointStakeList(JsonUtils.toObjList(totalDayStakePo.getAppointStake(), AppointStake.class));
		stakeVo.setCommonStake(JsonUtils.toObj(totalDayStakePo.getCommonStake(), CommonStake.class));
		stakeVo.setRankingStakeList(JsonUtils.toObjList(totalDayStakePo.getRankingStake(), RankingStake.class));
		return stakeVo;
	}
	
	
	
}
