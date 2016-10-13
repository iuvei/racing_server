package com.racing.controller.manager;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.service.stake.StakeInfoService;

@RestController
public class ManagerStakeInfoController {

	@Autowired
	private StakeInfoService stakeInfoService;
	
	@RequestMapping(value = "/manager/stake/racingnum/info", method = RequestMethod.GET)
	public Object getManagerStakeInfoByRacingNum(@RequestParam("racingNum")String racingNum){
		return stakeInfoService.getManagerStakeInfoByRacingNum(racingNum);
	}

	@RequestMapping(value = "/manager/stake/day/info", method = RequestMethod.GET)
	public Object getManagerStakeInfoByDay(@RequestParam("day")String day) throws ParseException{
		return stakeInfoService.getManagerStakeInfoByDay(day);
	}
	
}
