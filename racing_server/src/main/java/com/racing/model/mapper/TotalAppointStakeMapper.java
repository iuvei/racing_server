package com.racing.model.mapper;

import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalAppointStakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalAppointStakeMapper {
    int countByExample(TotalAppointStakeExample example);

    int deleteByExample(TotalAppointStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TotalAppointStake record);

    int insertSelective(TotalAppointStake record);

    List<TotalAppointStake> selectByExample(TotalAppointStakeExample example);

    TotalAppointStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TotalAppointStake record, @Param("example") TotalAppointStakeExample example);

    int updateByExample(@Param("record") TotalAppointStake record, @Param("example") TotalAppointStakeExample example);

    int updateByPrimaryKeySelective(TotalAppointStake record);

    int updateByPrimaryKey(TotalAppointStake record);
}