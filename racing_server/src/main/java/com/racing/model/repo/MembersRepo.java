package com.racing.model.repo;

import com.racing.model.mapper.MembersMapper;
import com.racing.model.po.Members;
import com.racing.model.po.MembersExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MembersRepo {
    @Autowired
    MembersMapper mapper;

    public List<Members> select(Integer userId, String nickname, PageUtil pageUtil) {
        MembersExample example = new MembersExample();
        MembersExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
        if (StringUtil.isNotEmpty(nickname)) {
            criteria.andNickNameLike("%" + nickname + "%");
        }
        example.setOrderByClause(" id desc " + pageUtil.getLimit());
        List<Members> membersList = mapper.selectByExample(example);
        return membersList;
    }
}
