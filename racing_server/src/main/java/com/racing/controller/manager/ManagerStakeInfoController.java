package com.racing.controller.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.service.stake.StakeInfoService;
import com.racing.util.LoginStatusSaveUtil;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ApiOperation("总盘--分盘押注报表—-押注情况-按期号查")
	@RequestMapping(value = "/manager/user/{userId}/stake/racingnum/info", method = RequestMethod.GET)
	public Object getUserStakeInfoByRacingNum(@RequestParam("racingNum")String racingNum, @PathVariable("userId")Integer userId){
		return stakeInfoService.getUserStakeInfoByRacingNum(userId,racingNum);
	}

	@ApiOperation("总盘--分盘押注报表—-押注情况-按日期查")
	@RequestMapping(value = "/manager/user/{userId/stake/day/info", method = RequestMethod.GET)
	public Object getUserStakeInfoByDay(@RequestParam("day")String day, @PathVariable("userId")Integer userId) throws ParseException{
		return stakeInfoService.getUserStakeInfoByDay(userId, day);
	}
}
