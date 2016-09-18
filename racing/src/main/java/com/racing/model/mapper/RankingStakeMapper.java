package com.racing.model.mapper;

import com.racing.model.po.RankingStake;
import com.racing.model.po.RankingStakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RankingStakeMapper {
    int countByExample(RankingStakeExample example);

    int deleteByExample(RankingStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RankingStake record);

    int insertSelective(RankingStake record);

    List<RankingStake> selectByExample(RankingStakeExample example);

    RankingStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RankingStake record, @Param("example") RankingStakeExample example);

    int updateByExample(@Param("record") RankingStake record, @Param("example") RankingStakeExample example);

    int updateByPrimaryKeySelective(RankingStake record);

    int updateByPrimaryKey(RankingStake record);
}