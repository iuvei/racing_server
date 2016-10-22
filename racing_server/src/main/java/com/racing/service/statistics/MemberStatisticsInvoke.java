package com.racing.service.statistics;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.racing.constant.DefaultRacteConstant;
import com.racing.model.po.Members;
import com.racing.model.po.WechatClient;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.WechatClientRepo;
import com.racing.service.calc.bo.CalcRate;

@Service
public class MemberStatisticsInvoke {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberStatisticsInvoke.class);
	
	@Autowired
	private MemberStatisticsService memberStatisticsService;
	
	@Autowired
	private MembersRepo membersRepo;
	
	@Autowired
	private WechatClientRepo wechatClientRepo;
	
	@Async
	public void asyncDealMemberIncome(Integer[] recordResult,String racingNum, Integer userId){
		BigDecimal totalMemberIncomeAmount = BigDecimal.ZERO;
		List<Members> memberList = membersRepo.getListByUserId(userId);
		if(CollectionUtils.isNotEmpty(memberList)){
			CalcRate calcRate = new CalcRate();
			WechatClient wechatClient = wechatClientRepo.select(userId);
			if(wechatClient == null){
				calcRate = DefaultRacteConstant.totalDefaultCalcRate;
			}else{
				try {
					PropertyUtils.copyProperties(calcRate, wechatClient);
				} catch (Exception e) {
					LOGGER.error("拷贝属性出现异常", e);
				}
			}
			for(Members members : memberList){
				BigDecimal memberIncomeAmount = memberStatisticsService.dealMemberIncome(recordResult, racingNum, members.getId(), calcRate);
				totalMemberIncomeAmount = totalMemberIncomeAmount.add(memberIncomeAmount);
			}
		}
		memberStatisticsService.completedStatistics(racingNum, userId, totalMemberIncomeAmount);
	}
	
}
