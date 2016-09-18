package com.racing.model.mapper;

import com.racing.model.po.DayCountStake;
import com.racing.model.po.DayCountStakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayCountStakeMapper {
    int countByExample(DayCountStakeExample example);

    int deleteByExample(DayCountStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DayCountStake record);

    int insertSelective(DayCountStake record);

    List<DayCountStake> selectByExample(DayCountStakeExample example);

    DayCountStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DayCountStake record, @Param("example") DayCountStakeExample example);

    int updateByExample(@Param("record") DayCountStake record, @Param("example") DayCountStakeExample example);

    int updateByPrimaryKeySelective(DayCountStake record);

    int updateByPrimaryKey(DayCountStake record);
}