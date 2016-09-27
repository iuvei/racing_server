package com.racing.model.repo;

import com.racing.model.mapper.TotalRacingIncomeMapper;
import com.racing.model.po.TotalRacingIncome;
import com.racing.model.po.TotalRacingIncomeExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TotalRacingIncomeRepo {
    @Autowired
    TotalRacingIncomeMapper mapper;

    public List<TotalRacingIncome> selectByRacingNum(Date startDate, Date endDate,
                                                     String racingNum, PageUtil page) {
        TotalRacingIncomeExample example = new TotalRacingIncomeExample();
        TotalRacingIncomeExample.Criteria criteria = example.createCriteria();
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

    public int selectCountByRacing(Date startDate, Date endDate, String racingNum) {
        TotalRacingIncomeExample example = new TotalRacingIncomeExample();
        TotalRacingIncomeExample.Criteria criteria = example.createCriteria();
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
