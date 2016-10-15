package com.racing.model.repo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.MembersDayCountIncomeMapper;
import com.racing.model.po.MembersDayCountIncome;
import com.racing.model.po.MembersDayCountIncomeExample;

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
	
}
