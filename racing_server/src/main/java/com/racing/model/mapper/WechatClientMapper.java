package com.racing.model.mapper;

import com.racing.model.po.WechatClient;
import com.racing.model.po.WechatClientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatClientMapper {
    int countByExample(WechatClientExample example);

    int deleteByExample(WechatClientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatClient record);

    int insertSelective(WechatClient record);

    List<WechatClient> selectByExample(WechatClientExample example);

    WechatClient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatClient record, @Param("example") WechatClientExample example);

    int updateByExample(@Param("record") WechatClient record, @Param("example") WechatClientExample example);

    int updateByPrimaryKeySelective(WechatClient record);

    int updateByPrimaryKey(WechatClient record);
}