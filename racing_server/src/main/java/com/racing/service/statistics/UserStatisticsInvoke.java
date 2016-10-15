package com.racing.service.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserStatisticsInvoke {

	@Autowired
	private UserStatisticsService userStatisticsService;
	
	@Async
	public void asyncDealUserIncome(Integer userId){
		userStatisticsService.dealUserIncome(userId);
	}
	
}
