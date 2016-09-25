package com.racing.model.repo;

import com.racing.model.mapper.UserMapper;
import com.racing.model.po.User;
import com.racing.model.po.UserExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        if (null == id) {
            criteria.andIdEqualTo(id);
        }
        example.setOrderByClause(" id desc " + pageUtil);
        List<User> users = mapper.selectByExample(example);
        return users;
    }
}
