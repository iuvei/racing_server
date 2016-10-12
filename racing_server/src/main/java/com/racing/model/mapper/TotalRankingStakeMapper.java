package com.racing.model.mapper;

import com.racing.model.po.TotalRankingStake;
import com.racing.model.po.TotalRankingStakeExample;
import com.racing.model.stake.RankingStake;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalRankingStakeMapper {
	
	int updateStake(@Param("racingNum")String racingNum, @Param("rankingStake")RankingStake rankingStake);
	
    int countByExample(TotalRankingStakeExample example);

    int deleteByExample(TotalRankingStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalRankingStake record);

    int insertSelective(TotalRankingStake record);

    List<TotalRankingStake> selectByExample(TotalRankingStakeExample example);

    TotalRankingStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalRankingStake record, @Param("example") TotalRankingStakeExample example);

    int updateByExample(@Param("record") TotalRankingStake record, @Param("example") TotalRankingStakeExample example);

    int updateByPrimaryKeySelective(TotalRankingStake record);

    int updateByPrimaryKey(TotalRankingStake record);
}