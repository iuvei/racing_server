package com.racing.model.repo;

import com.racing.model.mapper.TotalDayCountIncomeMapper;
import com.racing.model.po.TotalDayCountIncome;
import com.racing.model.po.TotalDayCountIncomeExample;
import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.DateUtil;
import com.racing.util.JsonUtils;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
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
            criteria.andDayLessThanOrEqualTo(endDate);
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
            criteria.andDayLessThanOrEqualTo(endDate);
        }
        return mapper.countByExample(example);
    }
    
    public TotalDayCountIncomeWithBLOBs getByDay(Date day){
    	TotalDayCountIncomeExample example = new TotalDayCountIncomeExample();
    	example.createCriteria().andDayEqualTo(DateUtil.parseToString(day, DateUtil.DateFormat_yyyy_MM_dd));
    	List<TotalDayCountIncomeWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
    	if(CollectionUtils.isNotEmpty(list)){
    		return list.get(0);
    	}else{
    		return null;
    	}
    }
    
    public void initIncome(Date day){
    	TotalDayCountIncomeWithBLOBs record = new TotalDayCountIncomeWithBLOBs();
    	StakeVo stakeVo = StakeVoUtil.createNewStake("");
    	record.setAppointStake(JsonUtils.toJsonHasNullKey(stakeVo.getAppointStakeList()));
    	record.setCommonStake(JsonUtils.toJsonHasNullKey(stakeVo.getCommonStake()));
    	record.setRankingStake(JsonUtils.toJsonHasNullKey(stakeVo.getRankingStakeList()));
    	record.setDay(DateUtil.parseToString(day, DateUtil.DateFormat_yyyy_MM_dd));
    	record.setDeficitAmount(BigDecimal.ZERO);
    	record.setIncomeAmount(BigDecimal.ZERO);
    	record.setStakeAmount(BigDecimal.ZERO);
    	record.setStakeCount(0);
    	mapper.insertSelective(record);
    }
    
    public void updateIncome(TotalDayCountIncomeWithBLOBs record){
    	TotalDayCountIncomeExample example = new TotalDayCountIncomeExample();
    	example.createCriteria().andDayEqualTo(record.getDay());
    	List<TotalDayCountIncomeWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
    	if(CollectionUtils.isEmpty(list)){
    		record.setDeficitAmount(record.getStakeAmount().subtract(record.getIncomeAmount()));
    		mapper.insertSelective(record);
    	}else{
    		mapper.updateIncome(record);
    	}
    }
}
