package com.racing.model.repo;

import com.racing.model.mapper.ManagerMapper;
import com.racing.model.po.Manager;
import com.racing.model.po.ManagerExample;
import com.racing.util.EncryptUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

  public Manager getByAccessKey(String accessKey) {
    ManagerExample example = new ManagerExample();
    example.createCriteria().andAccessKeyEqualTo(accessKey);
    List<Manager> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public List<Manager> getManagerList() {
    return this.mapper.selectByExample(new ManagerExample());
  }

  public int delete(int managerId) {
    return this.mapper.deleteByPrimaryKey(managerId);
  }

  public int add(Manager manager) {
    return mapper.insertSelective(manager);
  }

  public Manager selectByUserName(String userName) {
    ManagerExample example = new ManagerExample();
    example.createCriteria().andUserNameEqualTo(userName);
    List<Manager> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }
}
