package com.racing.model.mapper;

import com.racing.model.po.UserCommonStake;
import com.racing.model.po.UserCommonStakeExample;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCommonStakeMapper {
	
	int updateUserStake(@Param("userId") Integer userId, @Param("racingNum")String racingNum, @Param("commonStake")CommonStake commonStake);
	
    int countByExample(UserCommonStakeExample example);

    int deleteByExample(UserCommonStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCommonStake record);

    int insertSelective(UserCommonStake record);

    List<UserCommonStake> selectByExample(UserCommonStakeExample example);

    UserCommonStake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCommonStake record, @Param("example") UserCommonStakeExample example);

    int updateByExample(@Param("record") UserCommonStake record, @Param("example") UserCommonStakeExample example);

    int updateByPrimaryKeySelective(UserCommonStake record);

    int updateByPrimaryKey(UserCommonStake record);
}