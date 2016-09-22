package com.racing.model.mapper;

import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.UserRacingIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRacingIncomeMapper {
    int countByExample(UserRacingIncomeExample example);

    int deleteByExample(UserRacingIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRacingIncome record);

    int insertSelective(UserRacingIncome record);

    List<UserRacingIncome> selectByExample(UserRacingIncomeExample example);

    UserRacingIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRacingIncome record, @Param("example") UserRacingIncomeExample example);

    int updateByExample(@Param("record") UserRacingIncome record, @Param("example") UserRacingIncomeExample example);

    int updateByPrimaryKeySelective(UserRacingIncome record);

    int updateByPrimaryKey(UserRacingIncome record);
}