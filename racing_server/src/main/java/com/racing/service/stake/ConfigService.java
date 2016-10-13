package com.racing.service.stake;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.StakeConfigVo;
import com.racing.model.po.RecordResult;
import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.TotalDayCountIncomeRepo;
import com.racing.model.repo.UserDayCountIncomeRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.DateUtil;
import com.racing.util.JsonUtils;

@Service
public class ConfigService {

	@Autowired
	private RecordResultRepo recordResultRepo;
	
	@Autowired
	private TotalDayCountIncomeRepo totalDayCountIncomeRepo;
	
	@Autowired
	private UserDayCountIncomeRepo userDayCountIncomeRepo;
	
	public ApiResult getWebStakeConfig(boolean isManager, Integer loginId) {
	    StakeConfigVo result = new StakeConfigVo();
	    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
	    RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    if (recordResult == null) {
	      return null;
	    }
	    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
	    if(betweenTime>=280){//下一场比赛距离当前时间超过290秒，则继续上一场比赛，且停止押注操作
	    	nowDate = DateUtil.addSecond(nowDate, -20);//当前时间-10秒
	    	recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    	result.setStartRacingTime(0L);
	    	result.setEndStakeTime(0L);
	    	betweenTime = 10L;
	    }else{
	    	result.setRacingNum(recordResult.getRacingNum());
	    	result.setStartRacingTime(recordResult.getStartTime().getTime() - nowDate.getTime());
	    	result.setEndStakeTime(result.getStartRacingTime() - 60 * 1000);
	    }
	    
	    if(isManager){//总盘web
	    	if (betweenTime > 60) {
	    		result.setStage(1);// 下注阶段
	    		result.setStageName("下注阶段");
	    	} else if (betweenTime >= 40 && betweenTime <= 60) {
	    		result.setStage(2);// 计算阶段
	    		result.setStageName("计算阶段");
	    	} else if (betweenTime > 20 && betweenTime < 40) {
	    		result.setStage(3);// 修改比赛结果阶段
	    		result.setStageName("操作阶段");
	    		result.setResult(RecordResultPOUtil.convertResult(recordResult));//计算出来的比赛结果
	    	} else {
	    		result.setStage(4);// 停止操作阶段
	    		result.setStageName("封盘阶段");
	    	}
	    	TotalDayCountIncomeWithBLOBs totalDayCountIncomeWithBLOBs = totalDayCountIncomeRepo.getByDay(nowDate);
	    	if(totalDayCountIncomeWithBLOBs != null){
	    		result.setTodayIncome(totalDayCountIncomeWithBLOBs.getStakeAmount().subtract(totalDayCountIncomeWithBLOBs.getDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取
	    	}
	    }else{//分盘web
	    	if (betweenTime > 60) {
	    		result.setStage(1);// 下注阶段
	    		result.setStageName("下注阶段");
	    	} else {
	    		result.setStage(4);// 停止操作阶段
	    		result.setStageName("封盘阶段");
	    	}
	    	UserDayCountIncomeWithBLOBs userDayCountIncomeWithBLOBs = userDayCountIncomeRepo.getByDay(nowDate, loginId);
	    	if(userDayCountIncomeWithBLOBs!=null){
	    		result.setTodayIncome(userDayCountIncomeWithBLOBs.getTotalStakeAmount().subtract(userDayCountIncomeWithBLOBs.getTotalDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取
	    	}
	    }

	    RecordResult preRecordResult = recordResultRepo.getNowBeforLastRecordResult(nowDate);
	    if (preRecordResult != null) {
	      result.setPreRacingNum(preRecordResult.getRacingNum());
	      result.setPreResult(RecordResultPOUtil.convertResult(preRecordResult));
	    }


	    return ApiResult.createSuccessReuslt(result);
	  }
	
	public ApiResult getWebStakeConfigAndStakeInfo(boolean isManager, Integer loginId) {
	    StakeConfigVo result = new StakeConfigVo();
	    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
	    RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    if (recordResult == null) {
	      return null;
	    }
	    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
	    if(betweenTime>=280){//下一场比赛距离当前时间超过290秒，则继续上一场比赛，且停止押注操作
	    	nowDate = DateUtil.addSecond(nowDate, -20);//当前时间-10秒
	    	recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    	result.setStartRacingTime(0L);
	    	result.setEndStakeTime(0L);
	    	betweenTime = 10L;
	    }else{
	    	result.setRacingNum(recordResult.getRacingNum());
	    	result.setStartRacingTime(recordResult.getStartTime().getTime() - nowDate.getTime());
	    	result.setEndStakeTime(result.getStartRacingTime() - 60 * 1000);
	    }
	    if(isManager){//总盘web
	    	if (betweenTime > 60) {
	    		result.setStage(1);// 下注阶段
	    		result.setStageName("下注阶段");
	    	} else if (betweenTime >= 40 && betweenTime <= 60) {
	    		result.setStage(2);// 计算阶段
	    		result.setStageName("计算阶段");
	    	} else if (betweenTime > 20 && betweenTime < 40) {
	    		result.setStage(3);// 修改比赛结果阶段
	    		result.setStageName("操作阶段");
	    		result.setResult(RecordResultPOUtil.convertResult(recordResult));//计算出来的比赛结果
	    	} else {
	    		result.setStage(4);// 停止操作阶段
	    		result.setStageName("封盘阶段");
	    	}
	    	TotalDayCountIncomeWithBLOBs totalDayCountIncomeWithBLOBs = totalDayCountIncomeRepo.getByDay(nowDate);
	    	if(totalDayCountIncomeWithBLOBs != null){
	    		result.setTodayIncome(totalDayCountIncomeWithBLOBs.getStakeAmount().subtract(totalDayCountIncomeWithBLOBs.getDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取
	    		StakeVo stakeVo = new StakeVo();
	    		stakeVo.setAppointStakeList(JsonUtils.toObjList(totalDayCountIncomeWithBLOBs.getAppointStake(), AppointStake.class));
	    		stakeVo.setCommonStake(JsonUtils.toObj(totalDayCountIncomeWithBLOBs.getCommonStake(), CommonStake.class));
	    		stakeVo.setRankingStakeList(JsonUtils.toObjList(totalDayCountIncomeWithBLOBs.getRankingStake(), RankingStake.class));
	    		stakeVo.setRacingNum(recordResult.getRacingNum());
	    		result.setStakeVo(stakeVo);
	    	}else{
	    		result.setTodayIncome(BigDecimal.ZERO);
	    		result.setStakeVo(StakeVoUtil.createNewStake(recordResult.getRacingNum()));
	    	}
	    		
	    }else{//分盘web
	    	if (betweenTime > 60) {
	    		result.setStage(1);// 下注阶段
	    		result.setStageName("下注阶段");
	    	} else {
	    		result.setStage(4);// 停止操作阶段
	    		result.setStageName("封盘阶段");
	    	}
	    	UserDayCountIncomeWithBLOBs userDayCountIncomeWithBLOBs = userDayCountIncomeRepo.getByDay(nowDate, loginId);
	    	if(userDayCountIncomeWithBLOBs!=null){
	    		result.setTodayIncome(userDayCountIncomeWithBLOBs.getTotalStakeAmount().subtract(userDayCountIncomeWithBLOBs.getTotalDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取
	    		StakeVo stakeVo = new StakeVo();
	    		stakeVo.setAppointStakeList(JsonUtils.toObjList(userDayCountIncomeWithBLOBs.getAppointStake(), AppointStake.class));
	    		stakeVo.setCommonStake(JsonUtils.toObj(userDayCountIncomeWithBLOBs.getCommonStake(), CommonStake.class));
	    		stakeVo.setRankingStakeList(JsonUtils.toObjList(userDayCountIncomeWithBLOBs.getRankingStake(), RankingStake.class));
	    		stakeVo.setRacingNum(recordResult.getRacingNum());
	    		result.setStakeVo(stakeVo);
	    	}else{
	    		result.setTodayIncome(BigDecimal.ZERO);
	    		result.setStakeVo(StakeVoUtil.createNewStake(recordResult.getRacingNum()));
	    	}
	    }

	    RecordResult preRecordResult = recordResultRepo.getNowBeforLastRecordResult(nowDate);
	    if (preRecordResult != null) {
	      result.setPreRacingNum(preRecordResult.getRacingNum());
	      result.setPreResult(RecordResultPOUtil.convertResult(preRecordResult));
	    }


	    return ApiResult.createSuccessReuslt(result);
	  }
}
