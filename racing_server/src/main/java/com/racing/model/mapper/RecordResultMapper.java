package com.racing.model.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.racing.model.po.RecordResult;
import com.racing.model.po.RecordResultExample;

public interface RecordResultMapper {

  int upaddTotalStakeAmount(@Param("racingNum") String racingNum, @Param("addTotalStakeAmount") BigDecimal addTotalStakeAmount,
      @Param("addTotalStakeCount") Integer addTotalStakeCount);

  int countByExample(RecordResultExample example);

  int deleteByExample(RecordResultExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(RecordResult record);

  int insertSelective(RecordResult record);

  List<RecordResult> selectByExample(RecordResultExample example);

  RecordResult selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") RecordResult record, @Param("example") RecordResultExample example);

  int updateByExample(@Param("record") RecordResult record, @Param("example") RecordResultExample example);

  int updateByPrimaryKeySelective(RecordResult record);

  int updateByPrimaryKey(RecordResult record);
}
