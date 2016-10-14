package com.racing.model.po.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.racing.model.po.UserAppointStake;
import com.racing.model.po.UserCommonStake;
import com.racing.model.po.UserRankingStake;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.service.stake.StakeService;

public class UserStakeConvertUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(StakeService.class);
	
	public static CommonStake commontStakPoToVo(UserCommonStake userCommonStake){
		CommonStake commonStake = new CommonStake(); 
		try {
			PropertyUtils.copyProperties(commonStake, userCommonStake);
		} catch (Exception e) {
			LOGGER.error("拷贝属性出现异常", e);
		}
		return commonStake;
	}
	
	public static UserCommonStake commontStakVoToPo(CommonStake commonStake){
		UserCommonStake userCommonStake = new UserCommonStake(); 
		try {
			PropertyUtils.copyProperties(userCommonStake, commonStake);
		} catch (Exception e) {
			LOGGER.error("拷贝属性出现异常", e);
		}
		return userCommonStake;
	}
	
	public static List<AppointStake> appointStakPoToVo(List<UserAppointStake> userAppointStakeList){
		List<AppointStake> appointStakeList = new ArrayList<AppointStake>();
		if(CollectionUtils.isNotEmpty(userAppointStakeList)){
			for(UserAppointStake userAppointStake : userAppointStakeList){
				AppointStake appointStake = new AppointStake();
				try {
					PropertyUtils.copyProperties(appointStake, userAppointStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				appointStakeList.add(appointStake);
			}
		}
		return appointStakeList;
	}

	public static List<UserAppointStake> appointStakVoToPo(List<AppointStake> appointStakeList){
		List<UserAppointStake> userAppointStakeList = new ArrayList<UserAppointStake>();
		if(CollectionUtils.isNotEmpty(appointStakeList)){
			for(AppointStake appointStake : appointStakeList){
				UserAppointStake userAppointStake = new UserAppointStake();
				try {
					PropertyUtils.copyProperties(userAppointStake, appointStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				userAppointStakeList.add(userAppointStake);
			}
		}
		return userAppointStakeList;
	}
	
	public static List<RankingStake> rankingPoToVo(List<UserRankingStake> userRankingStakeList){
		List<RankingStake> rankingStakeList = new ArrayList<RankingStake>();
		if(CollectionUtils.isNotEmpty(userRankingStakeList)){
			for(UserRankingStake userRankingStake : userRankingStakeList){
				RankingStake rankingStake = new RankingStake();
				try {
					PropertyUtils.copyProperties(rankingStake, userRankingStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				rankingStakeList.add(rankingStake);
			}
		}
		return rankingStakeList;
	}
	public static List<UserRankingStake> rankingVoToPo(List<RankingStake> rankingStakeList){
		List<UserRankingStake> userRankingStakeList = new ArrayList<UserRankingStake>();
		if(CollectionUtils.isNotEmpty(rankingStakeList)){
			for(RankingStake rankingStake : rankingStakeList){
				UserRankingStake userRankingStake = new UserRankingStake();
				try {
					PropertyUtils.copyProperties(userRankingStake, rankingStake);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
				userRankingStakeList.add(userRankingStake);
			}
		}
		return userRankingStakeList;
	}
	
}
