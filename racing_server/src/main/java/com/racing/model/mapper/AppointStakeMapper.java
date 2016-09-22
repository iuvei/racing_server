package com.racing.model.mapper;

import com.racing.model.po.AppointStake;
import com.racing.model.po.AppointStakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointStakeMapper {
    int countByExample(AppointStakeExample example);

    int deleteByExample(AppointStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppointStake record);

    int insertSelective(AppointStake record);

    List<AppointStake> selectByExample(AppointStakeExample example);

    AppointStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppointStake record, @Param("example") AppointStakeExample example);

    int updateByExample(@Param("record") AppointStake record, @Param("example") AppointStakeExample example);

    int updateByPrimaryKeySelective(AppointStake record);

    int updateByPrimaryKey(AppointStake record);
}