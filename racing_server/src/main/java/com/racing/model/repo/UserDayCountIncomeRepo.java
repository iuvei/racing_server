package com.racing.model.repo;

import com.racing.model.mapper.UserDayCountIncomeMapper;
import com.racing.model.po.UserDayCountIncome;
import com.racing.model.po.UserDayCountIncomeExample;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import com.racing.util.DateUtil;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserDayCountIncomeRepo {
	@Autowired
	UserDayCountIncomeMapper mapper;

	public List<UserDayCountIncome> selectByDate(Integer userId, String startDate, String endDate, PageUtil page) {
		UserDayCountIncomeExample example = new UserDayCountIncomeExample();
		UserDayCountIncomeExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
		if (StringUtil.isNotEmpty(startDate)) {
			criteria.andDayGreaterThanOrEqualTo(startDate);
		}
		if (StringUtil.isNotEmpty(endDate)) {
			criteria.andDayLessThanOrEqualTo(endDate);
		}
		example.setOrderByClause(" day desc " + page.getLimit());
		return mapper.selectByExample(example);
	}

	public int selectCountByDate(Integer userId, String startDate, String endDate) {
		UserDayCountIncomeExample example = new UserDayCountIncomeExample();
		UserDayCountIncomeExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
		if (StringUtil.isNotEmpty(startDate)) {
			criteria.andDayGreaterThanOrEqualTo(startDate);
		}
		if (StringUtil.isNotEmpty(endDate)) {
			criteria.andDayLessThanOrEqualTo(endDate);
		}
		return mapper.countByExample(example);
	}

	public UserDayCountIncomeWithBLOBs getByDay(Date day, Integer userId) {
		UserDayCountIncomeExample example = new UserDayCountIncomeExample();
		example.createCriteria().andDayEqualTo(DateUtil.parseToString(day, DateUtil.DateFormat_yyyy_MM_dd))
				.andUserIdEqualTo(userId);
		List<UserDayCountIncomeWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void updateIncome(UserDayCountIncomeWithBLOBs record) {
		UserDayCountIncomeExample example = new UserDayCountIncomeExample();
		example.createCriteria().andDayEqualTo(record.getDay()).andUserIdEqualTo(record.getUserId());
		List<UserDayCountIncomeWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(list)) {
			record.setMembersDeficitAmount(record.getMembersIncomeAmount().subtract(record.getMembersStakeAmount()));
			record.setUserDeficitAmount(record.getUserIncomeAmount().subtract(record.getUserStakeAmount()));
			record.setTotalDeficitAmount(record.getTotalIncomeAmount().subtract(record.getTotalStakeAmount()));
			mapper.insertSelective(record);
		} else {
			mapper.updateIncome(record);
		}
	}

	public void updateIncomeWithoutStake(UserDayCountIncomeWithBLOBs record) {
		UserDayCountIncomeExample example = new UserDayCountIncomeExample();
		example.createCriteria().andDayEqualTo(record.getDay()).andUserIdEqualTo(record.getUserId());
		List<UserDayCountIncomeWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(list)) {
			record.setMembersDeficitAmount(record.getMembersIncomeAmount().subtract(record.getMembersStakeAmount()));
			record.setUserDeficitAmount(record.getUserIncomeAmount().subtract(record.getUserStakeAmount()));
			record.setTotalDeficitAmount(record.getTotalIncomeAmount().subtract(record.getTotalStakeAmount()));
			mapper.insertSelective(record);
		} else {
			mapper.updateIncomeWithoutStake(record);
		}
	}

}
