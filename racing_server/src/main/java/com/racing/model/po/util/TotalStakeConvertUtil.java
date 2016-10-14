package com.racing.model.po.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalCommonStake;
import com.racing.model.po.TotalRankingStake;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.service.stake.StakeService;

public class TotalStakeConvertUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(StakeService.class);
	
	public static CommonStake commontStakPoToVo(TotalCommonStake totalCommonStake){
		CommonStake commonStake = new CommonStake(); 
		try {
			PropertyUtils.copyProperties(commonStake, totalCommonStake);
		} catch (Exception e) {
			LOGGER.error("拷贝属性出现异常", e);
		}
		return commonStake;
	}
	
	public static TotalCommonStake commontStakVoToPo(CommonStake commonStake){
		TotalCommonStake totalCommonStake = new TotalCommonStake(); 
		try {
			PropertyUtils.copyProperties(totalCommonStake, commonStake);
		} catch (Exception e) {
			LOGGER.error("拷贝属性出现异常", e);
		}
		return totalCommonStake;
	}
	
	public static List<AppointStake> appointStakPoToVo(List<TotalAppointStake> totalAppointStakeList){
		List<AppointStake> appointStakeList = new ArrayList<AppointStake>();
		if(CollectionUtils.isNotEmpty(totalAppointStakeList)){
			for(TotalAppointStake totalAppointStake : totalAppointStakeList){
				AppointStake appointStake = new AppointStake();
				try {
					PropertyUtils.copyProperties(appointStake, totalAppointStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				appointStakeList.add(appointStake);
			}
		}
		return appointStakeList;
	}

	public static List<TotalAppointStake> appointStakVoToPo(List<AppointStake> appointStakeList){
		List<TotalAppointStake> totalAppointStakeList = new ArrayList<TotalAppointStake>();
		if(CollectionUtils.isNotEmpty(appointStakeList)){
			for(AppointStake appointStake : appointStakeList){
				TotalAppointStake totalAppointStake = new TotalAppointStake();
				try {
					PropertyUtils.copyProperties(totalAppointStake, appointStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				totalAppointStakeList.add(totalAppointStake);
			}
		}
		return totalAppointStakeList;
	}
	
	public static List<RankingStake> rankingPoToVo(List<TotalRankingStake> totalRankingStakeList){
		List<RankingStake> rankingStakeList = new ArrayList<RankingStake>();
		if(CollectionUtils.isNotEmpty(totalRankingStakeList)){
			for(TotalRankingStake totalRankingStake : totalRankingStakeList){
				RankingStake rankingStake = new RankingStake();
				try {
					PropertyUtils.copyProperties(rankingStake, totalRankingStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				rankingStakeList.add(rankingStake);
			}
		}
		return rankingStakeList;
	}
	public static List<TotalRankingStake> rankingVoToPo(List<RankingStake> rankingStakeList){
		List<TotalRankingStake> totalRankingStakeList = new ArrayList<TotalRankingStake>();
		if(CollectionUtils.isNotEmpty(rankingStakeList)){
			for(RankingStake rankingStake : rankingStakeList){
				TotalRankingStake totalRankingStake = new TotalRankingStake();
				try {
					PropertyUtils.copyProperties(totalRankingStake, rankingStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				totalRankingStakeList.add(totalRankingStake);
			}
		}
		return totalRankingStakeList;
	}
	
}
