package com.racing.model.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.TotalAppointStakeMapper;
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
	
}
