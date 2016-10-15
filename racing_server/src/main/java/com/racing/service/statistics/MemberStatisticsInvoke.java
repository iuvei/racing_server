package com.racing.service.statistics;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.racing.model.po.Members;
import com.racing.model.repo.MembersRepo;

@Service
public class MemberStatisticsInvoke {

	@Autowired
	private MemberStatisticsService memberStatisticsService;
	
	@Autowired
	private MembersRepo membersRepo;
	
	@Async
	public void asyncDealMemberIncome(String racingNum, Integer userId){
		BigDecimal totalMemberIncomeAmount = BigDecimal.ZERO;
		List<Members> memberList = membersRepo.getListByUserId(userId);
		if(CollectionUtils.isNotEmpty(memberList)){
			for(Members members : memberList){
				BigDecimal memberIncomeAmount = memberStatisticsService.dealMemberIncome(racingNum, members.getId());
				totalMemberIncomeAmount = totalMemberIncomeAmount.add(memberIncomeAmount);
			}
		}
		memberStatisticsService.completedStatistics(racingNum, userId, totalMemberIncomeAmount);
	}
	
}
