package com.racing.model.repo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.ManagerMapper;
import com.racing.model.po.Manager;
import com.racing.model.po.ManagerExample;
import com.racing.util.EncryptUtil;

@Repository
public class ManagerRepo {

  @Autowired
  private ManagerMapper mapper;

  public Manager getByUserNameAndPassword(String userName, String password) {
    password = EncryptUtil.md5AndSha1Upcase(password);
    ManagerExample example = new ManagerExample();
    example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
    List<Manager> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public Manager update(Manager manager) {
    this.mapper.updateByPrimaryKeySelective(manager);
    return manager;
  }

  public boolean updateWebOutTime(Integer managerId, Date webOutTime) {
    Manager manager = new Manager();
    manager.setId(managerId);
    manager.setWebOutTime(webOutTime);
    this.mapper.updateByPrimaryKeySelective(manager);
    return true;
  }

}
