package com.racing.model.po.util;

import com.racing.model.po.MemberStakeWithBLOBs;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.JsonUtils;

public class MemberStakeConvertUtil {

	public static StakeVo convertUserStakeJsonToBean(MemberStakeWithBLOBs stakeWithBLOBs){
		StakeVo newStakeVo = new StakeVo(); 
		if(stakeWithBLOBs!=null){
			newStakeVo.setAppointStakeList(JsonUtils.toObjList(stakeWithBLOBs.getAppointStake(), AppointStake.class));
			newStakeVo.setCommonStake(JsonUtils.toObj(stakeWithBLOBs.getCommonStake(), CommonStake.class));
			newStakeVo.setRankingStakeList(JsonUtils.toObjList(stakeWithBLOBs.getRankingStake(), RankingStake.class));
		}else{
			newStakeVo = StakeVoUtil.createNewStake("");	
		}
		return newStakeVo;
	}
	
}
