package com.racing.model.repo;

import com.racing.model.mapper.UserRacingIncomeMapper;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.UserRacingIncomeExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserRacingIncomeRepo {
    @Autowired
    UserRacingIncomeMapper mapper;

    public List<UserRacingIncome> selectByRacingNum(Integer userId, Date startDate, Date endDate,
                                                    String racingNum, PageUtil page) {
        UserRacingIncomeExample example = new UserRacingIncomeExample();
        UserRacingIncomeExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
        if (startDate != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null) {
            criteria.andCreateTimeLessThanOrEqualTo(startDate);
        }
        if (StringUtil.isNotEmpty(racingNum)) {
            criteria.andRacingNumEqualTo(racingNum);
        }
        example.setOrderByClause(" id desc " + page.getLimit());
        return mapper.selectByExample(example);
    }

    public int selectCountByRacing(Integer userId, Date startDate, Date endDate, String racingNum) {
        UserRacingIncomeExample example = new UserRacingIncomeExample();
        UserRacingIncomeExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
        if (startDate != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null) {
            criteria.andCreateTimeLessThanOrEqualTo(startDate);
        }
        if (StringUtil.isNotEmpty(racingNum)) {
            criteria.andRacingNumEqualTo(racingNum);
        }
        return mapper.countByExample(example);
    }
}
