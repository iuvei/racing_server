package com.racing.model.repo;

import com.racing.model.mapper.MembersAccountRecordMapper;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.po.MembersAccountRecordExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MembersAccountRecordRepo {
    @Autowired
    MembersAccountRecordMapper mapper;

    public List<MembersAccountRecord> select(Integer memberId,
                                             Date sDate, Date eDate,
                                             String type, PageUtil pageUtil) {
        MembersAccountRecordExample example = new MembersAccountRecordExample();
        MembersAccountRecordExample.Criteria criteria = example.createCriteria().andMembersIdEqualTo(memberId);
        if (sDate != null && eDate != null) {
            criteria.andOperationTimeBetween(sDate, eDate);
        }
        if (StringUtil.isNotEmpty(type)) {
            criteria.andTypeEqualTo(type);
        }
        example.setOrderByClause(" id desc " + pageUtil.getLimit());
        List<MembersAccountRecord> list = mapper.selectByExample(example);
        return list;
    }
}
