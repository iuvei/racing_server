package com.racing.model.mapper;

import com.racing.model.po.UserRankingStake;
import com.racing.model.po.UserRankingStakeExample;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRankingStakeMapper {
	
	int updateUserStake(@Param("userId") Integer userId, @Param("racingNum")String racingNum, @Param("rankingStake")RankingStake rankingStake);
	
    int countByExample(UserRankingStakeExample example);

    int deleteByExample(UserRankingStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRankingStake record);

    int insertSelective(UserRankingStake record);

    List<UserRankingStake> selectByExample(UserRankingStakeExample example);

    UserRankingStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRankingStake record, @Param("example") UserRankingStakeExample example);

    int updateByExample(@Param("record") UserRankingStake record, @Param("example") UserRankingStakeExample example);

    int updateByPrimaryKeySelective(UserRankingStake record);

    int updateByPrimaryKey(UserRankingStake record);
}