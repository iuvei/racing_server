package com.racing.model.mapper;

import com.racing.model.po.Members;
import com.racing.model.po.MembersExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MembersMapper {
	
	int updatePoints(@Param("memberId")Integer memberId, @Param("addPoints")BigDecimal addPoints);
	
    int countByExample(MembersExample example);

    int deleteByExample(MembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Members record);

    int insertSelective(Members record);

    List<Members> selectByExample(MembersExample example);

    Members selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Members record, @Param("example") MembersExample example);

    int updateByExample(@Param("record") Members record, @Param("example") MembersExample example);

    int updateByPrimaryKeySelective(Members record);

    int updateByPrimaryKey(Members record);
}