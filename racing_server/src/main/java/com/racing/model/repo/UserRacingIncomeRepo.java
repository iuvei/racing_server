package com.racing.model.repo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.UserRacingIncomeMapper;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.UserRacingIncomeExample;
import com.racing.util.PageUtil;

import jodd.util.StringUtil;

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
            criteria.andCreateTimeLessThanOrEqualTo(endDate);
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
            criteria.andCreateTimeLessThanOrEqualTo(endDate);
        }
        if (StringUtil.isNotEmpty(racingNum)) {
            criteria.andRacingNumEqualTo(racingNum);
        }
        return mapper.countByExample(example);
    }
    
    public void updateIncome(UserRacingIncome racingIncome){
    	UserRacingIncomeExample example = new UserRacingIncomeExample();
    	example.createCriteria().andUserIdEqualTo(racingIncome.getUserId()).andRacingNumEqualTo(racingIncome.getRacingNum());
    	if(CollectionUtils.isEmpty(mapper.selectByExample(example))){
    		racingIncome.setCreateTime(new Date());
    		racingIncome.setMembersDeficitAmount(racingIncome.getMembersStakeAmount().negate());
    		racingIncome.setTotalDeficitAmount(racingIncome.getMembersStakeAmount().add(racingIncome.getUserStakeAmount()).negate());
    		racingIncome.setUserDeficitAmount(racingIncome.getUserStakeAmount().negate());
    		mapper.insertSelective(racingIncome);
    	}else{
    		mapper.updateIncome(racingIncome);
    	}
    }
    
    public UserRacingIncome selectByRacingNumAndUserId(String racingNum, Integer userId){
    	UserRacingIncomeExample example = new UserRacingIncomeExample();
    	example.createCriteria().andUserIdEqualTo(userId).andRacingNumEqualTo(racingNum);
    	List<UserRacingIncome> list = mapper.selectByExample(example);
    	if(CollectionUtils.isNotEmpty(list)){
    		return list.get(0);
    	}
    	return null;
    }

    public List<UserRacingIncome> selectByRacingNum(Integer userId, String racingNum) {
        UserRacingIncomeExample example = new UserRacingIncomeExample();
        UserRacingIncomeExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
        if (StringUtil.isNotEmpty(racingNum)) {
            criteria.andRacingNumEqualTo(racingNum);
        }
        return mapper.selectByExample(example);
    }
}
