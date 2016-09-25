package com.racing.model.repo;

import com.racing.controller.vo.UserVo;
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

    public int count() {
        UserExample example = new UserExample();
        example.createCriteria().andClientAccessKeyBetween("", "");
        return this.mapper.countByExample(example);
    }

    public UserVo selectUser(String nickName, Integer id, Integer page) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(nickName)) {
            criteria.andNickNameLike("%" + nickName + "%");
        }
        if (null == id) {
            criteria.andIdEqualTo(id);
        }

        Integer TotalPage = mapper.countByExample(example);

        if (null != page) {
            example.setOrderByClause(" id desc " + PageUtil.createPage(page,15));
        }else{
            example.setOrderByClause(" id desc " + PageUtil.createPage(1,15));
        }
        List<User> users = mapper.selectByExample(example);

        UserVo userVo = new UserVo();
        userVo.setUsers(users);
        userVo.setTotalPage(TotalPage/15);
        return userVo;
    }
}
