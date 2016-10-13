package com.racing.model.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.TotalAppointStakeMapper;
import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalAppointStakeExample;
import com.racing.model.stake.AppointStake;

@Repository
public class TotalAppointStakeRepo {

	@Autowired
	private TotalAppointStakeMapper mapper;
	
	public void updateStake(String racingNum,List<AppointStake> appointStakeList){
		for(AppointStake appointStake : appointStakeList){
			mapper.updateStake(racingNum, appointStake);
		}
	}
	
	public void initNewStake(String racingNum){
		for(int i = 0; i<10 ; i++){
			TotalAppointStake totalAppointStake = new TotalAppointStake();
			totalAppointStake.setCarNum(i+1);
			totalAppointStake.setRacingNum(racingNum);
			mapper.insertSelective(totalAppointStake);
		}
	}
	
	public List<TotalAppointStake> getByRacingNum(String racingNum){
		TotalAppointStakeExample example = new TotalAppointStakeExample();
		example.createCriteria().andRacingNumEqualTo(racingNum);
		example.setOrderByClause(" car_num ASC");
		return mapper.selectByExample(example);
	}
}
