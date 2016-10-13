package com.racing.model.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserRankingStakeMapper;
import com.racing.model.po.UserRankingStake;
import com.racing.model.po.UserRankingStakeExample;
import com.racing.model.stake.RankingStake;

@Repository
public class UserRankingStakeRepo {

	@Autowired
	private UserRankingStakeMapper mapper;
	
	public List<UserRankingStake> getByRacingNumAndUserId(String racingNum, Integer userId){
		UserRankingStakeExample example = new UserRankingStakeExample();
		example.createCriteria().andRacingNumEqualTo(racingNum).andUserIdEqualTo(userId);
		example.setOrderByClause(" ranking_num ASC");
		return mapper.selectByExample(example);
	}
	
	public boolean addNew(List<UserRankingStake> userRankingStakeList, Integer userId, String racingNum){
		for(UserRankingStake rankingStake : userRankingStakeList ){
			rankingStake.setUserId(userId);
			rankingStake.setRacingNum(racingNum);
			mapper.insertSelective(rankingStake);
		}
		return true;
	}
	
	public boolean updateUserStake(Integer userId, String racingNum, List<RankingStake> rankingStakeList){
		for(RankingStake rankingStake : rankingStakeList){
			mapper.updateUserStake(userId, racingNum, rankingStake);
		}
		return true;
	}
	
}
