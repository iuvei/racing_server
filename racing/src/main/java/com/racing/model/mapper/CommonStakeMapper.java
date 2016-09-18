package com.racing.model.mapper;

import com.racing.model.po.CommonStake;
import com.racing.model.po.CommonStakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommonStakeMapper {
    int countByExample(CommonStakeExample example);

    int deleteByExample(CommonStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommonStake record);

    int insertSelective(CommonStake record);

    List<CommonStake> selectByExample(CommonStakeExample example);

    CommonStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommonStake record, @Param("example") CommonStakeExample example);

    int updateByExample(@Param("record") CommonStake record, @Param("example") CommonStakeExample example);

    int updateByPrimaryKeySelective(CommonStake record);

    int updateByPrimaryKey(CommonStake record);
}