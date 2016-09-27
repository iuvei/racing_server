package com.racing.model.repo;

import com.racing.model.mapper.TotalDayCountIncomeMapper;
import com.racing.model.po.TotalDayCountIncome;
import com.racing.model.po.TotalDayCountIncomeExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TotalDayCountIncomeRepo {
    @Autowired
    TotalDayCountIncomeMapper mapper;

    public List<TotalDayCountIncome> selectByDate(String startDate,
                                                  String endDate,
                                                  PageUtil page) {
        TotalDayCountIncomeExample example = new TotalDayCountIncomeExample();
        TotalDayCountIncomeExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(startDate)) {
            criteria.andDayGreaterThanOrEqualTo(startDate);
        }
        if (StringUtil.isNotEmpty(endDate)) {
            criteria.andDayLessThanOrEqualTo(startDate);
        }
        example.setOrderByClause(" day desc " + page.getLimit());
        return mapper.selectByExample(example);
    }

    public int selectCountByDate(String startDate,
                                 String endDate) {
        TotalDayCountIncomeExample example = new TotalDayCountIncomeExample();
        TotalDayCountIncomeExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(startDate)) {
            criteria.andDayGreaterThanOrEqualTo(startDate);
        }
        if (StringUtil.isNotEmpty(endDate)) {
            criteria.andDayLessThanOrEqualTo(startDate);
        }
        return mapper.countByExample(example);
    }
}
