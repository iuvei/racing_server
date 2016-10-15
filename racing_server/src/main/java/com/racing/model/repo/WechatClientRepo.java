package com.racing.model.repo;

import com.racing.model.mapper.WechatClientMapper;
import com.racing.model.po.WechatClient;
import com.racing.model.po.WechatClientExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WechatClientRepo {
    @Autowired
    WechatClientMapper mapper;

    public WechatClient select(Integer userId) {
        WechatClientExample example = new WechatClientExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<WechatClient> list = mapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public int update(WechatClient wechatClient) {
        return mapper.updateByPrimaryKeySelective(wechatClient);
    }

    public int add(WechatClient wechatClient) {
        return mapper.insertSelective(wechatClient);
    }
}
