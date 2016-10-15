package com.racing.model.mapper;

import com.racing.model.po.MembersDayCountIncome;
import com.racing.model.po.MembersDayCountIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MembersDayCountIncomeMapper {
	
	int updateIncome(@Param("record") MembersDayCountIncome record);
	
    int countByExample(MembersDayCountIncomeExample example);

    int deleteByExample(MembersDayCountIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MembersDayCountIncome record);

    int insertSelective(MembersDayCountIncome record);

    List<MembersDayCountIncome> selectByExample(MembersDayCountIncomeExample example);

    MembersDayCountIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MembersDayCountIncome record, @Param("example") MembersDayCountIncomeExample example);

    int updateByExample(@Param("record") MembersDayCountIncome record, @Param("example") MembersDayCountIncomeExample example);

    int updateByPrimaryKeySelective(MembersDayCountIncome record);

    int updateByPrimaryKey(MembersDayCountIncome record);
}