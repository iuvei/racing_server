package com.racing.service.stake;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.StakeConfigVo;
import com.racing.model.po.RecordResult;
import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.po.UserAppointStake;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import com.racing.model.po.util.TotalStakeConvertUtil;
import com.racing.model.po.util.UserStakeConvertUtil;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.TotalAppointStakeRepo;
import com.racing.model.repo.TotalCommonStakeRepo;
import com.racing.model.repo.TotalDayCountIncomeRepo;
import com.racing.model.repo.TotalRankingStakeRepo;
import com.racing.model.repo.UserAppointStakeRepo;
import com.racing.model.repo.UserCommonStakeRepo;
import com.racing.model.repo.UserDayCountIncomeRepo;
import com.racing.model.repo.UserRankingStakeRepo;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.DateUtil;

@Service
public class ConfigService {

	@Autowired
	private RecordResultRepo recordResultRepo;
	
	@Autowired
	private TotalDayCountIncomeRepo totalDayCountIncomeRepo;
	
	@Autowired
	private TotalAppointStakeRepo totalAppointStakeRepo;
	
	@Autowired
	private TotalCommonStakeRepo totalCommonStakeRepo;
	
	@Autowired
	private TotalRankingStakeRepo totalRankingStakeRepo;
	
	@Autowired
	private UserAppointStakeRepo userAppointStakeRepo;
	
	@Autowired
	private UserCommonStakeRepo userCommonStakeRepo;
	
	@Autowired
	private UserRankingStakeRepo userRankingStakeRepo;
	
	@Autowired
	private UserDayCountIncomeRepo userDayCountIncomeRepo;
	
	public ApiResult getWebStakeConfig(boolean isManager, Integer loginId, boolean isClient) {
	    StakeConfigVo result = new StakeConfigVo();
	    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
	    RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    if (recordResult == null) {
	      return ApiResult.createErrorReuslt("暂无比赛！");
	    }
	    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
	    
	    if(betweenTime>300){
	    	return ApiResult.createErrorReuslt("暂无比赛！");
	    }
	    result.setResult(null);
	    if(betweenTime>=280){//下一场比赛距离当前时间超过280秒，则继续上一场比赛，且停止押注操作
	    	nowDate = DateUtil.addSecond(nowDate, -21);//当前时间-10秒
	    	recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    	result.setStartRacingTime(0L);
	    	result.setEndStakeTime(0L);
	    	betweenTime = 10L;
	    }else{
	    	result.setStartRacingTime(recordResult.getStartTime().getTime() - nowDate.getTime());
	    	result.setEndStakeTime(result.getStartRacingTime() - 60 * 1000);
	    }
	    result.setRacingNum(recordResult.getRacingNum());
	    if(isManager){//总盘web
	    	if (betweenTime > 60) {
	    		result.setStage(1);// 下注阶段
	    		result.setStageName("下注阶段");
	    	} else if (betweenTime >= 40 && betweenTime <= 60) {
	    		result.setStage(2);// 计算阶段
	    		result.setStageName("计算阶段");
	    	} else if (betweenTime > 20 && betweenTime < 40) {
	    		result.setResult(RecordResultPOUtil.convertResult(recordResult));//计算出来的比赛结果
	    		result.setStage(3);// 修改比赛结果阶段
	    		result.setStageName("操作阶段");
	    	} else {
	    		result.setStage(4);// 停止操作阶段
	    		result.setStageName("封盘阶段");
	    	}
	    	TotalDayCountIncomeWithBLOBs totalDayCountIncomeWithBLOBs = totalDayCountIncomeRepo.getByDay(nowDate);
	    	if(totalDayCountIncomeWithBLOBs != null){
	    		result.setTodayIncome(totalDayCountIncomeWithBLOBs.getStakeAmount().subtract(totalDayCountIncomeWithBLOBs.getDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取
	    	}else{
	    		result.setTodayIncome(BigDecimal.ZERO);
	    	}
	    }else{//分盘web
	    	if(isClient){//客户端
	    		if (betweenTime > 70) {
	    			result.setStage(1);// 下注阶段
	    			result.setStageName("下注阶段");
	    		} else if(betweenTime > 60){
	    			result.setStage(2);// 停止操作阶段
	    			result.setStageName("上报阶段");
	    		}else {
	    			result.setStage(3);// 停止操作阶段
	    			result.setStageName("封盘阶段");
	    		}
	    	}else{
	    		if (betweenTime > 60) {
	    			result.setStage(1);// 下注阶段
	    			result.setStageName("下注阶段");
	    		} else {
	    			result.setStage(4);// 停止操作阶段
	    			result.setStageName("封盘阶段");
	    		}
	    	}
	    	UserDayCountIncomeWithBLOBs userDayCountIncomeWithBLOBs = userDayCountIncomeRepo.getByDay(nowDate, loginId);
	    	if(userDayCountIncomeWithBLOBs!=null){
	    		result.setTodayIncome(userDayCountIncomeWithBLOBs.getTotalStakeAmount().subtract(userDayCountIncomeWithBLOBs.getTotalDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取
	    	}else{
	    		result.setTodayIncome(BigDecimal.ZERO);
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
	    	return ApiResult.createErrorReuslt("暂无比赛！");
	    }
	    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
	    if(betweenTime>300){
	    	return ApiResult.createErrorReuslt("暂无比赛！");
	    }
	    result.setResult(null);
	    if(betweenTime>=280&&!isManager){//下一场比赛距离当前时间超过290秒，则继续上一场比赛，且停止押注操作,如果是总盘用户，则不执行该逻辑
	    	nowDate = DateUtil.addSecond(nowDate, -21);//当前时间-10秒
	    	recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
	    	result.setStartRacingTime(0L);
	    	result.setEndStakeTime(0L);
	    	betweenTime = 10L;
	    }else{
	    	result.setStartRacingTime(recordResult.getStartTime().getTime() - nowDate.getTime());
	    	result.setEndStakeTime(result.getStartRacingTime() - 60 * 1000);
	    }
	    
	    result.setRacingNum(recordResult.getRacingNum());
	    
	    if(isManager){//总盘web
	    	if (betweenTime > 60) {
	    		result.setStage(1);// 下注阶段
	    		result.setStageName("下注阶段");
	    	} else if (betweenTime >= 40 && betweenTime <= 60) {
	    		result.setStage(2);// 计算阶段
	    		result.setStageName("计算阶段");
	    	} else if (betweenTime > 20 && betweenTime < 40) {
	    		result.setResult(RecordResultPOUtil.convertResult(recordResult));//计算出来的比赛结果
	    		result.setStage(3);// 修改比赛结果阶段
	    		result.setStageName("操作阶段");
	    	} else {
	    		result.setStage(4);// 停止操作阶段
	    		result.setStageName("封盘阶段");
	    	}
	    	TotalDayCountIncomeWithBLOBs totalDayCountIncomeWithBLOBs = totalDayCountIncomeRepo.getByDay(nowDate);
	    	if(totalDayCountIncomeWithBLOBs != null){
	    		result.setTodayIncome(totalDayCountIncomeWithBLOBs.getDeficitAmount());// 今日盈亏，临时死值，需要统计获取
	    	}else{
	    		result.setTodayIncome(BigDecimal.ZERO);
	    	}
	    	StakeVo stakeVo = new StakeVo();
	    	List<TotalAppointStake> appointStakeList = totalAppointStakeRepo.getByRacingNum(recordResult.getRacingNum());
	    	if(CollectionUtils.isNotEmpty(appointStakeList)){
	    		stakeVo.setAppointStakeList(TotalStakeConvertUtil.appointStakPoToVo(appointStakeList));
	    		stakeVo.setCommonStake(TotalStakeConvertUtil.commontStakPoToVo(totalCommonStakeRepo.getRacingNum(recordResult.getRacingNum())));
	    		stakeVo.setRankingStakeList(TotalStakeConvertUtil.rankingPoToVo(totalRankingStakeRepo.getRacingNum(recordResult.getRacingNum())));
	    	}else{
	    		stakeVo = StakeVoUtil.createNewStake(recordResult.getRacingNum());
	    	}
	    	result.setStakeVo(stakeVo);
	    		
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
	    		result.setTodayIncome(userDayCountIncomeWithBLOBs.getTotalDeficitAmount());// 今日盈亏，临时死值，需要统计获取
	    	}else{
	    		result.setTodayIncome(BigDecimal.ZERO);
	    	}
	    	
	    	StakeVo stakeVo = new StakeVo();
	    	List<UserAppointStake> appointStakeList = userAppointStakeRepo.getByRacingNumAndUserId(recordResult.getRacingNum(), loginId);
	    	if(CollectionUtils.isNotEmpty(appointStakeList)){
	    		stakeVo.setAppointStakeList(UserStakeConvertUtil.appointStakPoToVo(appointStakeList));
	    		stakeVo.setCommonStake(UserStakeConvertUtil.commontStakPoToVo(userCommonStakeRepo.getByRacingNumAndUserId(recordResult.getRacingNum(), loginId)));
	    		stakeVo.setRankingStakeList(UserStakeConvertUtil.rankingPoToVo(userRankingStakeRepo.getByRacingNumAndUserId(recordResult.getRacingNum(), loginId)));
	    	}else{
	    		stakeVo = StakeVoUtil.createNewStake(recordResult.getRacingNum());
	    	}
	    	result.setStakeVo(stakeVo);
	    	
	    }

	    RecordResult preRecordResult = recordResultRepo.getNowBeforLastRecordResult(nowDate);
	    if (preRecordResult != null) {
	      result.setPreRacingNum(preRecordResult.getRacingNum());
	      result.setPreResult(RecordResultPOUtil.convertResult(preRecordResult));
	    }


	    return ApiResult.createSuccessReuslt(result);
	  }
}
