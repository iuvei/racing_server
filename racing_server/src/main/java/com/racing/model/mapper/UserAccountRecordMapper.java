package com.racing.model.mapper;

import com.racing.model.po.UserAccountRecord;
import com.racing.model.po.UserAccountRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountRecordMapper {
    int countByExample(UserAccountRecordExample example);

    int deleteByExample(UserAccountRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAccountRecord record);

    int insertSelective(UserAccountRecord record);

    List<UserAccountRecord> selectByExample(UserAccountRecordExample example);

    UserAccountRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAccountRecord record, @Param("example") UserAccountRecordExample example);

    int updateByExample(@Param("record") UserAccountRecord record, @Param("example") UserAccountRecordExample example);

    int updateByPrimaryKeySelective(UserAccountRecord record);

    int updateByPrimaryKey(UserAccountRecord record);
}