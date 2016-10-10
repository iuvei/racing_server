package com.racing.model.repo;

import com.racing.model.mapper.WechatClientMapper;
import com.racing.model.po.WechatClient;
import com.racing.model.po.WechatClientExample;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WechatClientRepo {
    @Autowired
    WechatClientMapper mapper;

    public List<WechatClient> select(Integer userId, PageUtil pageUtil) {
        WechatClientExample example = new WechatClientExample();
        WechatClientExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
        example.setOrderByClause(" id desc " + pageUtil.getLimit());
        List<WechatClient> list = mapper.selectByExample(example);
        return list;
    }

    public int update(WechatClient wechatClient) {
        return mapper.updateByPrimaryKey(wechatClient);
    }
}
