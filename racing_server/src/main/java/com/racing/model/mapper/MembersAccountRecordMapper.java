package com.racing.model.mapper;

import com.racing.model.po.MembersAccountRecord;
import com.racing.model.po.MembersAccountRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MembersAccountRecordMapper {
    int countByExample(MembersAccountRecordExample example);

    int deleteByExample(MembersAccountRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MembersAccountRecord record);

    int insertSelective(MembersAccountRecord record);

    List<MembersAccountRecord> selectByExample(MembersAccountRecordExample example);

    MembersAccountRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MembersAccountRecord record, @Param("example") MembersAccountRecordExample example);

    int updateByExample(@Param("record") MembersAccountRecord record, @Param("example") MembersAccountRecordExample example);

    int updateByPrimaryKeySelective(MembersAccountRecord record);

    int updateByPrimaryKey(MembersAccountRecord record);
}