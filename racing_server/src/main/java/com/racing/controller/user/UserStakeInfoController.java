package com.racing.controller.user;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResult;
import com.racing.service.stake.StakeInfoService;
import com.racing.util.LoginStatusSaveUtil;

@RestController
public class UserStakeInfoController {

	@Autowired
	private StakeInfoService stakeInfoService;
	
	@RequestMapping(value = "/user/stake/racingnum/info", method = RequestMethod.GET)
	public Object getUserStakeInfoByRacingNum(@RequestParam("racingNum")String racingNum){
		Integer userId = LoginStatusSaveUtil.getUserWebId();
		if(userId == null){
			return ApiResult.createNoLoginReuslt();
		}
		return stakeInfoService.getUserStakeInfoByRacingNum(userId,racingNum);
	}

	@RequestMapping(value = "/user/stake/day/info", method = RequestMethod.GET)
	public Object getUserStakeInfoByDay(@RequestParam("day")String day) throws ParseException{
		Integer userId = LoginStatusSaveUtil.getUserWebId();
		if(userId == null){
			return ApiResult.createNoLoginReuslt();
		}
		return stakeInfoService.getUserStakeInfoByDay(userId, day);
	}
	
}
