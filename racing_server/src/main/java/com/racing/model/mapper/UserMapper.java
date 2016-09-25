package com.racing.model.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.racing.model.po.User;
import com.racing.model.po.UserExample;

public interface UserMapper {

  int updatePoints(@Param("userId") Integer userId, @Param("addTotalPoints") BigDecimal addTotalPoints, @Param("addUserPoints") BigDecimal addUserPoints,
      @Param("addMembersPoints") BigDecimal addMembersPoints);

  int countByExample(UserExample example);

  int deleteByExample(UserExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  int insertSelective(User record);

  List<User> selectByExample(UserExample example);

  User selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

  int updateByExample(@Param("record") User record, @Param("example") UserExample example);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}
