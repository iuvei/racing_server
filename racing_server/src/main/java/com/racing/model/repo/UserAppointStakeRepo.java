package com.racing.model.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserAppointStakeMapper;
import com.racing.model.po.UserAppointStake;
import com.racing.model.po.UserAppointStakeExample;
import com.racing.model.stake.AppointStake;

@Repository
public class UserAppointStakeRepo {

	@Autowired
	private UserAppointStakeMapper mapper;
	
	public List<UserAppointStake> getByRacingNumAndUserId(String racingNum, Integer userId){
		UserAppointStakeExample example = new UserAppointStakeExample();
		example.createCriteria().andRacingNumEqualTo(racingNum).andUserIdEqualTo(userId);
		example.setOrderByClause(" carNum ASC");
		return mapper.selectByExample(example);
	}
	
	public boolean addNew(List<UserAppointStake> userAppointStakeList, Integer userId, String racingNum){
		for(UserAppointStake userAppointStake : userAppointStakeList){
			userAppointStake.setRacingNum(racingNum);
			userAppointStake.setUserId(userId);
			mapper.insertSelective(userAppointStake);
		}
		return true;
	}
	
	public boolean updateUserStake(Integer userId, String racingNum,List<AppointStake> appointStakeList){
		for(AppointStake appointStake : appointStakeList){
			mapper.updateUserStake(userId, racingNum, appointStake);
		}
		return true;
	}
	
}
