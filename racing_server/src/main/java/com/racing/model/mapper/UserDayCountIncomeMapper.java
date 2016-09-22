package com.racing.model.mapper;

import com.racing.model.po.UserDayCountIncome;
import com.racing.model.po.UserDayCountIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDayCountIncomeMapper {
    int countByExample(UserDayCountIncomeExample example);

    int deleteByExample(UserDayCountIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDayCountIncome record);

    int insertSelective(UserDayCountIncome record);

    List<UserDayCountIncome> selectByExample(UserDayCountIncomeExample example);

    UserDayCountIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDayCountIncome record, @Param("example") UserDayCountIncomeExample example);

    int updateByExample(@Param("record") UserDayCountIncome record, @Param("example") UserDayCountIncomeExample example);

    int updateByPrimaryKeySelective(UserDayCountIncome record);

    int updateByPrimaryKey(UserDayCountIncome record);
}