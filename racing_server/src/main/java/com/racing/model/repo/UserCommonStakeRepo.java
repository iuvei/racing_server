package com.racing.model.repo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserCommonStakeMapper;
import com.racing.model.po.UserCommonStake;
import com.racing.model.po.UserCommonStakeExample;
import com.racing.model.stake.CommonStake;


@Repository
public class UserCommonStakeRepo {

	@Autowired
	private UserCommonStakeMapper mapper;
	
	public UserCommonStake getByRacingNumAndUserId(String racingNum, Integer userId){
		UserCommonStakeExample example = new UserCommonStakeExample();
		example.createCriteria().andRacingNumEqualTo(racingNum).andUserIdEqualTo(userId);
		List<UserCommonStake> userCommonStakeList = mapper.selectByExample(example);
		
		if(CollectionUtils.isNotEmpty(userCommonStakeList)){
			return userCommonStakeList.get(0);
		}
		
		return null;
		
	}
	
	public UserCommonStake addNew(UserCommonStake userCommonStake, Integer userId, String racingNum){
		userCommonStake.setUserId(userId);
		userCommonStake.setRacingNum(racingNum);;
		mapper.insertSelective(userCommonStake);
		return userCommonStake;
	}
	
	public boolean updateUserStake(Integer userId, String racingNum, CommonStake commonStake){
		mapper.updateUserStake(userId, racingNum, commonStake);
		return true;
	}
	
}
