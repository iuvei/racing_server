package com.racing.model.repo;

import com.racing.model.mapper.MembersDayCountIncomeMapper;
import com.racing.model.po.MembersDayCountIncome;
import com.racing.model.po.MembersDayCountIncomeExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MembersDayCountIncomeRepo {

	@Autowired
	private MembersDayCountIncomeMapper mapper;

	public MembersDayCountIncome getByMemberIdAndDay(Integer memberId, String day){
		MembersDayCountIncomeExample example = new MembersDayCountIncomeExample();
		example.createCriteria().andDayEqualTo(day).andMembersIdEqualTo(memberId);
		List<MembersDayCountIncome> list = mapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	
	public void updateIncome(MembersDayCountIncome record){
		if(this.getByMemberIdAndDay(record.getMembersId(), record.getDay()) == null){
			record.setDeficitAmount(record.getIncomeAmount().subtract(record.getIncomeAmount()));
			mapper.insertSelective(record);
		}else{
			mapper.updateIncome(record);
		}
	}

	public List<MembersDayCountIncome> selectByDate(Integer memberId, String startDate, String endDate, PageUtil pageUtil) {
		MembersDayCountIncomeExample example = new MembersDayCountIncomeExample();
		MembersDayCountIncomeExample.Criteria criteria=example.createCriteria().andMembersIdEqualTo(memberId);
		if (StringUtil.isNotEmpty(startDate)) {
			criteria.andDayGreaterThanOrEqualTo(startDate);
		}
		if (StringUtil.isNotEmpty(endDate)) {
			criteria.andDayLessThanOrEqualTo(endDate);
		}
		example.setOrderByClause(" id desc " + pageUtil.getLimit());
		List<MembersDayCountIncome> list = mapper.selectByExample(example);
		return list;
	}

	public int selectCountByDate(Integer memberId, String startDate, String endDate) {
		MembersDayCountIncomeExample example = new MembersDayCountIncomeExample();
		MembersDayCountIncomeExample.Criteria criteria=example.createCriteria().andMembersIdEqualTo(memberId);
		if (StringUtil.isNotEmpty(startDate)) {
			criteria.andDayGreaterThanOrEqualTo(startDate);
		}
		if (StringUtil.isNotEmpty(endDate)) {
			criteria.andDayLessThanOrEqualTo(endDate);
		}
		return mapper.countByExample(example);
	}
}
