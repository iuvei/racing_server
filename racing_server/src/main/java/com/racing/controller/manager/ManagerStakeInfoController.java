package com.racing.controller.manager;

import com.racing.service.stake.StakeInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class ManagerStakeInfoController {

	@Autowired
	private StakeInfoService stakeInfoService;

	@ApiOperation("总盘-押注情况-按期号查")
	@RequestMapping(value = "/manager/stake/racingnum/info", method = RequestMethod.GET)
	public Object getManagerStakeInfoByRacingNum(@RequestParam("racingNum")String racingNum){
		return stakeInfoService.getManagerStakeInfoByRacingNum(racingNum);
	}

	@ApiOperation("总盘-押注情况-按日期查")
	@RequestMapping(value = "/manager/stake/day/info", method = RequestMethod.GET)
	public Object getManagerStakeInfoByDay(@RequestParam("day")String day) throws ParseException{
		return stakeInfoService.getManagerStakeInfoByDay(day);
	}
	
}
