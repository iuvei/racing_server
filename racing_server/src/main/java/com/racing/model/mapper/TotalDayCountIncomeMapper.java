package com.racing.model.mapper;

import com.racing.model.po.TotalDayCountIncome;
import com.racing.model.po.TotalDayCountIncomeExample;
import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalDayCountIncomeMapper {
	
	int updateIncome(@Param("record")TotalDayCountIncomeWithBLOBs record);
	
    int countByExample(TotalDayCountIncomeExample example);

    int deleteByExample(TotalDayCountIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalDayCountIncomeWithBLOBs record);

    int insertSelective(TotalDayCountIncomeWithBLOBs record);

    List<TotalDayCountIncomeWithBLOBs> selectByExampleWithBLOBs(TotalDayCountIncomeExample example);

    List<TotalDayCountIncome> selectByExample(TotalDayCountIncomeExample example);

    TotalDayCountIncomeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalDayCountIncomeWithBLOBs record, @Param("example") TotalDayCountIncomeExample example);

    int updateByExampleWithBLOBs(@Param("record") TotalDayCountIncomeWithBLOBs record, @Param("example") TotalDayCountIncomeExample example);

    int updateByExample(@Param("record") TotalDayCountIncome record, @Param("example") TotalDayCountIncomeExample example);

    int updateByPrimaryKeySelective(TotalDayCountIncomeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TotalDayCountIncomeWithBLOBs record);

    int updateByPrimaryKey(TotalDayCountIncome record);
}