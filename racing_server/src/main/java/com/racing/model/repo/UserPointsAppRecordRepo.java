package com.racing.model.repo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserPointsAppRecordMapper;
import com.racing.model.po.UserPointsAppRecord;
import com.racing.model.po.UserPointsAppRecordExample;
import com.racing.util.PageUtil;

import jodd.util.StringUtil;

@Repository
public class UserPointsAppRecordRepo {
  @Autowired
  UserPointsAppRecordMapper mapper;

  public List<UserPointsAppRecord> selectByUserIds(List<Integer> userIds, String status, PageUtil pageUtil) {
    UserPointsAppRecordExample example = new UserPointsAppRecordExample();
    UserPointsAppRecordExample.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(status)) {
      criteria.andStatusEqualTo(status);
    }
    if (CollectionUtils.isNotEmpty(userIds)) {
      criteria.andUserIdIn(userIds);
    }

    example.setOrderByClause(" id desc " + pageUtil.getLimit());
    List<UserPointsAppRecord> list = mapper.selectByExample(example);
    return list;
  }

  public int countByUserIds(List<Integer> userIds, String status) {
    UserPointsAppRecordExample example = new UserPointsAppRecordExample();
    UserPointsAppRecordExample.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(status)) {
      criteria.andStatusEqualTo(status);
    }
    if (CollectionUtils.isNotEmpty(userIds)) {
      criteria.andUserIdIn(userIds);
    }

    return this.mapper.countByExample(example);
  }



  public UserPointsAppRecord selectById(Integer id) {
    UserPointsAppRecordExample example = new UserPointsAppRecordExample();
    example.createCriteria().andIdEqualTo(id);
    List<UserPointsAppRecord> list = mapper.selectByExample(example);
    return list.get(0);
  }

  public boolean updateStatus(UserPointsAppRecord userPointsAppRecord) {
    mapper.updateByPrimaryKeySelective(userPointsAppRecord);
    return true;
  }

  public List<UserPointsAppRecord> selectPointsByUserId(Integer userId, PageUtil pageUtil) {
    UserPointsAppRecordExample example = new UserPointsAppRecordExample();
    example.createCriteria().andUserIdEqualTo(userId);
    example.setOrderByClause(" id desc " + pageUtil.getLimit());
    List<UserPointsAppRecord> list = mapper.selectByExample(example);
    return list;
  }
}
