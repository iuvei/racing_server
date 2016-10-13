package com.racing.controller.stake;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MemberStakeVo;
import com.racing.controller.vo.ModifyRacordResultVo;
import com.racing.model.stake.StakeVo;
import com.racing.service.stake.ConfigService;
import com.racing.service.stake.RecordResultService;
import com.racing.service.stake.StakeService;
import com.racing.util.LoginStatusSaveUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class StakeController {
	@Autowired
	private StakeService stakeService;

	@Autowired
	private ConfigService configService;
	
	@Autowired
	private RecordResultService recordResultService; 
	
	@ApiOperation("客户端-押注")
	@RequestMapping(value = "/member/stake", method = RequestMethod.POST)
	public Object memberStake(@RequestBody List<MemberStakeVo> stakeList) {
		Integer userId = LoginStatusSaveUtil.getUserClientId();
		if (userId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return stakeService.memberStake(userId, stakeList);
	}

	@ApiOperation("分盘-押注")
	@RequestMapping(value = "/user/stake", method = RequestMethod.POST)
	public Object UserStake(@RequestBody StakeVo stakeVo) {
		Integer userId = LoginStatusSaveUtil.getUserClientId();
		if (userId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return stakeService.userStake(userId, stakeVo);
	}

	@ApiOperation("分盘-实时开奖")
	@RequestMapping(value = "/user/stake/configer/info", method = RequestMethod.GET)
	public Object getUserStakeConfigerAndStakeInfo() {
		Integer loginId = LoginStatusSaveUtil.getUserClientId();
		if (loginId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return configService.getWebStakeConfigAndStakeInfo(false, loginId);
	}

	@ApiOperation("分盘-押注控制")
	@RequestMapping(value = "/user/stake/configer", method = RequestMethod.GET)
	public Object getUserStakeConfiger() {
		Integer loginId = LoginStatusSaveUtil.getUserClientId();
		if (loginId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return configService.getWebStakeConfig(false, loginId);
	}
	
	@ApiOperation("客户端-押注控制")
	@RequestMapping(value = "/user/client/stake/configer", method = RequestMethod.GET)
	public Object getClientStakeConfiger() {
		Integer loginId = LoginStatusSaveUtil.getUserClientId();
		if (loginId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return configService.getWebStakeConfig(false, loginId);
	}
	
	@ApiOperation("总盘-实时开奖")
	@RequestMapping(value = "/manager/stake/configer", method = RequestMethod.GET)
	public Object getManagerStakeConfiger() {
		Integer loginId = LoginStatusSaveUtil.getManagerId();
		if (loginId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return configService.getWebStakeConfigAndStakeInfo(true, loginId);
	}

	@ApiOperation("总盘-修改比赛结果")
	@RequestMapping(value = "/manager/stake/configer", method = RequestMethod.PUT)
	public Object managerModifyRacingResult(@RequestBody ModifyRacordResultVo req){
		Integer loginId = LoginStatusSaveUtil.getManagerId();
		if (loginId == null) {
			return ApiResult.createNoLoginReuslt();
		}
		return recordResultService.updateRacingResult(req.getResult().toArray(new Integer[req.getResult().size()]), req.getRacingNum());
	}
	
	
}
