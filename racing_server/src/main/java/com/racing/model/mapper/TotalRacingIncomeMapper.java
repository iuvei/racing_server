package com.racing.model.mapper;

import com.racing.model.po.TotalRacingIncome;
import com.racing.model.po.TotalRacingIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalRacingIncomeMapper {
    int countByExample(TotalRacingIncomeExample example);

    int deleteByExample(TotalRacingIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalRacingIncome record);

    int insertSelective(TotalRacingIncome record);

    List<TotalRacingIncome> selectByExample(TotalRacingIncomeExample example);

    TotalRacingIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalRacingIncome record, @Param("example") TotalRacingIncomeExample example);

    int updateByExample(@Param("record") TotalRacingIncome record, @Param("example") TotalRacingIncomeExample example);

    int updateByPrimaryKeySelective(TotalRacingIncome record);

    int updateByPrimaryKey(TotalRacingIncome record);
}