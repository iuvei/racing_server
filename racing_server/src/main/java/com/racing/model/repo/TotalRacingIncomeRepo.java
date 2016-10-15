package com.racing.model.repo;

import com.racing.model.mapper.TotalRacingIncomeMapper;
import com.racing.model.po.TotalRacingIncome;
import com.racing.model.po.TotalRacingIncomeExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
    
    public void updateRacingIncome(TotalRacingIncome racingIncome){
    	TotalRacingIncomeExample example = new TotalRacingIncomeExample();
    	example.createCriteria().andRacingNumEqualTo(racingIncome.getRacingNum());
    	if(CollectionUtils.isEmpty(mapper.selectByExample(example))){
    		racingIncome.setCreateTime(new Date());
    		racingIncome.setDeficitAmount(racingIncome.getStakeAmount().subtract(racingIncome.getIncomeAmount()));
    		mapper.insertSelective(racingIncome);
    	}else{
    		mapper.updateIncome(racingIncome);
    	}
    }
    
    public TotalRacingIncome selectByRacingNum(String racingNum){
    	TotalRacingIncomeExample example = new TotalRacingIncomeExample();
    	example.createCriteria().andRacingNumEqualTo(racingNum);
    	List<TotalRacingIncome> list = mapper.selectByExample(example);
    	if(CollectionUtils.isNotEmpty(list)){
    		return list.get(0);
    	}
    	return null;
    }
    
    public void iniNewIncome(String racingNum){
    	TotalRacingIncome income = new TotalRacingIncome();
    	income.setCreateTime(new Date());
    	income.setDeficitAmount(BigDecimal.ZERO);
    	income.setIncomeAmount(BigDecimal.ZERO);
    	income.setRacingNum(racingNum);
    	income.setStakeAmount(BigDecimal.ZERO);
    	income.setStakeCount(0);
    	mapper.insertSelective(income);
    }
    
}
