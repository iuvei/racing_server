package com.racing.model.mapper;

import com.racing.model.po.UserPointsAppRecord;
import com.racing.model.po.UserPointsAppRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPointsAppRecordMapper {
    int countByExample(UserPointsAppRecordExample example);

    int deleteByExample(UserPointsAppRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPointsAppRecord record);

    int insertSelective(UserPointsAppRecord record);

    List<UserPointsAppRecord> selectByExample(UserPointsAppRecordExample example);

    UserPointsAppRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPointsAppRecord record, @Param("example") UserPointsAppRecordExample example);

    int updateByExample(@Param("record") UserPointsAppRecord record, @Param("example") UserPointsAppRecordExample example);

    int updateByPrimaryKeySelective(UserPointsAppRecord record);

    int updateByPrimaryKey(UserPointsAppRecord record);
}