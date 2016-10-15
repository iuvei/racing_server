package com.racing.model.po.util;


import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.JsonUtils;

public class TotalDayStakeConvertUtil {

	public static StakeVo commontStakPoToVo(TotalDayCountIncomeWithBLOBs totalDayStakePo){
		StakeVo stakeVo = new StakeVo();
		if(totalDayStakePo == null){
			stakeVo = StakeVoUtil.createNewStake("");
		}else{
			stakeVo.setAppointStakeList(JsonUtils.toObjList(totalDayStakePo.getAppointStake(), AppointStake.class));
			stakeVo.setCommonStake(JsonUtils.toObj(totalDayStakePo.getCommonStake(), CommonStake.class));
			stakeVo.setRankingStakeList(JsonUtils.toObjList(totalDayStakePo.getRankingStake(), RankingStake.class));
		}
		return stakeVo;
	}
	
	
	
}
