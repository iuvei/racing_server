package com.racing.model.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.TotalRankingStakeMapper;
import com.racing.model.po.TotalRankingStake;
import com.racing.model.po.TotalRankingStakeExample;
import com.racing.model.stake.RankingStake;

@Repository
public class TotalRankingStakeRepo {

	@Autowired
	private TotalRankingStakeMapper mapper;
	
	public void updateStake(String racingNum, List<RankingStake> rankingStakeList){
		for(RankingStake rankingStake : rankingStakeList){
			mapper.updateStake(racingNum, rankingStake);
		}
	}
	
	public void initNewStake(String racingNum){
		for(int i = 0; i<10 ; i++){
			TotalRankingStake rankingStake = new TotalRankingStake();
			rankingStake.setRankingNum(i+1);
			rankingStake.setRacingNum(racingNum);
			mapper.insertSelective(rankingStake);
		}
	}
	
	public List<TotalRankingStake> getRacingNum(String racingNum){
		TotalRankingStakeExample example = new TotalRankingStakeExample();
		example.createCriteria().andRacingNumEqualTo(racingNum);
		example.setOrderByClause(" ranking_num ASC");
		return mapper.selectByExample(example);
	}
	
}
