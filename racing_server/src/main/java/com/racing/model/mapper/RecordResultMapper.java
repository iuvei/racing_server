package com.racing.model.mapper;

import com.racing.model.po.RecordResult;
import com.racing.model.po.RecordResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordResultMapper {
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