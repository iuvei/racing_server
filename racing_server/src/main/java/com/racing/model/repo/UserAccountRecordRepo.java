package com.racing.model.repo;

import com.racing.model.mapper.UserAccountRecordMapper;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.po.UserAccountRecordExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAccountRecordRepo {
    @Autowired
    UserAccountRecordMapper mapper;

    public int insert(UserAccountRecord userPointsAppRecord) {
        return mapper.insertSelective(userPointsAppRecord);
    }

    public List<UserAccountRecord> selectByUserIdOrState(Integer userId, String status, PageUtil pageUtil) {

        UserAccountRecordExample example = new UserAccountRecordExample();
        UserAccountRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(status)) {
            criteria.andTypeEqualTo(status);
        }
        if (null != userId) {
            criteria.andUserIdEqualTo(userId);
        }
        example.setOrderByClause(" id desc " + pageUtil.getLimit());
        List<UserAccountRecord> userAccountRecordList = mapper.selectByExample(example);
        return userAccountRecordList;
    }

    public int countByUserIdOrState(Integer userId, String status) {
        UserAccountRecordExample example = new UserAccountRecordExample();
        UserAccountRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(status)) {
            criteria.andTypeEqualTo(status);
        }
        if (null != userId) {
            criteria.andUserIdEqualTo(userId);
        }
        int count = mapper.countByExample(example);
        return count;
    }
}
