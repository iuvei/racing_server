package com.racing.model.mapper;

import com.racing.model.po.TotalCommonStake;
import com.racing.model.po.TotalCommonStakeExample;
import com.racing.model.stake.CommonStake;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalCommonStakeMapper {
	
	int updateStake(@Param("racingNum")String racingNum, @Param("commonStake")CommonStake commonStake);
	
    int countByExample(TotalCommonStakeExample example);

    int deleteByExample(TotalCommonStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalCommonStake record);

    int insertSelective(TotalCommonStake record);

    List<TotalCommonStake> selectByExample(TotalCommonStakeExample example);

    TotalCommonStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalCommonStake record, @Param("example") TotalCommonStakeExample example);

    int updateByExample(@Param("record") TotalCommonStake record, @Param("example") TotalCommonStakeExample example);

    int updateByPrimaryKeySelective(TotalCommonStake record);

    int updateByPrimaryKey(TotalCommonStake record);
}