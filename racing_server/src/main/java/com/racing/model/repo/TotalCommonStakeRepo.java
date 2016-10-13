package com.racing.model.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.TotalCommonStakeMapper;
import com.racing.model.po.TotalCommonStake;
import com.racing.model.stake.CommonStake;

@Repository
public class TotalCommonStakeRepo {

	@Autowired
	private TotalCommonStakeMapper mapper;
	
	public void updateStake(String racingNum, CommonStake commonStake){
		mapper.updateStake(racingNum, commonStake);
	}
	
	public void initNewStake(String racingNum){
		TotalCommonStake totalCommonStake = new TotalCommonStake();
		totalCommonStake.setRacingNum(racingNum);
		mapper.insertSelective(totalCommonStake);
	}
}
