package com.racing.model.mapper;

import com.racing.model.po.UserStake;
import com.racing.model.po.UserStakeExample;
import com.racing.model.po.UserStakeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStakeMapper {
    int countByExample(UserStakeExample example);

    int deleteByExample(UserStakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserStakeWithBLOBs record);

    int insertSelective(UserStakeWithBLOBs record);

    List<UserStakeWithBLOBs> selectByExampleWithBLOBs(UserStakeExample example);

    List<UserStake> selectByExample(UserStakeExample example);

    UserStakeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserStakeWithBLOBs record, @Param("example") UserStakeExample example);

    int updateByExampleWithBLOBs(@Param("record") UserStakeWithBLOBs record, @Param("example") UserStakeExample example);

    int updateByExample(@Param("record") UserStake record, @Param("example") UserStakeExample example);

    int updateByPrimaryKeySelective(UserStakeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserStakeWithBLOBs record);

    int updateByPrimaryKey(UserStake record);
}