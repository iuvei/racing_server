package com.racing.model.mapper;

import com.racing.model.po.MemberStake;
import com.racing.model.po.MemberStakeExample;
import com.racing.model.po.MemberStakeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberStakeMapper {
	
	int updateIncome(@Param("record") MemberStakeWithBLOBs record);
	
    int countByExample(MemberStakeExample example);

    int deleteByExample(MemberStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberStakeWithBLOBs record);

    int insertSelective(MemberStakeWithBLOBs record);

    List<MemberStakeWithBLOBs> selectByExampleWithBLOBs(MemberStakeExample example);

    List<MemberStake> selectByExample(MemberStakeExample example);

    MemberStakeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberStakeWithBLOBs record, @Param("example") MemberStakeExample example);

    int updateByExampleWithBLOBs(@Param("record") MemberStakeWithBLOBs record, @Param("example") MemberStakeExample example);

    int updateByExample(@Param("record") MemberStake record, @Param("example") MemberStakeExample example);

    int updateByPrimaryKeySelective(MemberStakeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MemberStakeWithBLOBs record);

    int updateByPrimaryKey(MemberStake record);
}