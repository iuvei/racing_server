package com.racing.model.mapper;

import com.racing.model.po.UserDayCountIncome;
import com.racing.model.po.UserDayCountIncomeExample;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDayCountIncomeMapper {
	
	int updateIncome(@Param("record") UserDayCountIncomeWithBLOBs record);

	int updateIncomeWithoutStake(@Param("record") UserDayCountIncomeWithBLOBs record);
	
    int countByExample(UserDayCountIncomeExample example);

    int deleteByExample(UserDayCountIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDayCountIncomeWithBLOBs record);

    int insertSelective(UserDayCountIncomeWithBLOBs record);

    List<UserDayCountIncomeWithBLOBs> selectByExampleWithBLOBs(UserDayCountIncomeExample example);

    List<UserDayCountIncome> selectByExample(UserDayCountIncomeExample example);

    UserDayCountIncomeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDayCountIncomeWithBLOBs record, @Param("example") UserDayCountIncomeExample example);

    int updateByExampleWithBLOBs(@Param("record") UserDayCountIncomeWithBLOBs record, @Param("example") UserDayCountIncomeExample example);

    int updateByExample(@Param("record") UserDayCountIncome record, @Param("example") UserDayCountIncomeExample example);

    int updateByPrimaryKeySelective(UserDayCountIncomeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserDayCountIncomeWithBLOBs record);

    int updateByPrimaryKey(UserDayCountIncome record);
}