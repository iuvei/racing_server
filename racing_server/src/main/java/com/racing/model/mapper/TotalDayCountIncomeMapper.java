package com.racing.model.mapper;

import com.racing.model.po.TotalDayCountIncome;
import com.racing.model.po.TotalDayCountIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalDayCountIncomeMapper {
    int countByExample(TotalDayCountIncomeExample example);

    int deleteByExample(TotalDayCountIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalDayCountIncome record);

    int insertSelective(TotalDayCountIncome record);

    List<TotalDayCountIncome> selectByExample(TotalDayCountIncomeExample example);

    TotalDayCountIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalDayCountIncome record, @Param("example") TotalDayCountIncomeExample example);

    int updateByExample(@Param("record") TotalDayCountIncome record, @Param("example") TotalDayCountIncomeExample example);

    int updateByPrimaryKeySelective(TotalDayCountIncome record);

    int updateByPrimaryKey(TotalDayCountIncome record);
}