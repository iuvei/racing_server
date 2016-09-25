package com.racing.model.repo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserMapper;
import com.racing.model.po.User;
import com.racing.model.po.UserExample;
import com.racing.util.EncryptUtil;
import com.racing.util.PageUtil;

import jodd.util.StringUtil;

@Repository
public class UserRepo {
  @Autowired
  UserMapper mapper;

  public int count(String nickName, Integer id) {
    UserExample example = new UserExample();
    UserExample.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(nickName)) {
      criteria.andNickNameLike("%" + nickName + "%");
    }
    if (null == id) {
      criteria.andIdEqualTo(id);
    }
    return this.mapper.countByExample(example);
  }

  public List<User> selectUser(String nickName, Integer id, PageUtil pageUtil) {
    UserExample example = new UserExample();
    UserExample.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(nickName)) {
      criteria.andNickNameLike("%" + nickName + "%");
    }
    if (null != id) {
      criteria.andIdEqualTo(id);
    }
    example.setOrderByClause(" id desc " + pageUtil);
    List<User> users = mapper.selectByExample(example);
    return users;
  }

  public User getByUserNameAndPassword(String userName, String password) {
    password = EncryptUtil.md5AndSha1Upcase(password);
    UserExample example = new UserExample();
    example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
    List<User> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public User getByUserNameAndPasswordAndClientSN(String userName, String password, String clientSN) {
    password = EncryptUtil.md5AndSha1Upcase(password);
    UserExample example = new UserExample();
    example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password).andClientSnEqualTo(clientSN);
    List<User> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public User update(User user) {
    this.mapper.updateByPrimaryKeySelective(user);
    return user;
  }

  public boolean updateWebOutTime(Integer userId, Date webOutTime) {
    User user = new User();
    user.setId(userId);
    user.setWebOutTime(webOutTime);
    this.mapper.updateByPrimaryKeySelective(user);
    return true;
  }

  public boolean updateClientOutTime(Integer userId, Date clientOutTime) {
    User user = new User();
    user.setId(userId);
    user.setClientOutTime(clientOutTime);
    this.mapper.updateByPrimaryKeySelective(user);
    return true;
  }


  public User getByClientSN(String clientSN) {
    UserExample example = new UserExample();
    example.createCriteria().andClientSnEqualTo(clientSN);
    List<User> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public List<User> selectUser(String nickName, Integer id) {
    UserExample example = new UserExample();
    UserExample.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(nickName)) {
      criteria.andNickNameLike("%" + nickName + "%");
    }
    if (null == id) {
      criteria.andIdEqualTo(id);
    }
    List<User> users = mapper.selectByExample(example);
    return users;
  }

  public User getByClientAccessKey(String accessKey) {
    UserExample example = new UserExample();
    example.createCriteria().andClientAccessKeyEqualTo(accessKey);
    List<User> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  public User getByWebAccessKey(String accessKey) {
    UserExample example = new UserExample();
    example.createCriteria().andWebAccessKeyEqualTo(accessKey);
    List<User> list = this.mapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }
}
