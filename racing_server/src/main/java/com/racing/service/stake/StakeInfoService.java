package com.racing.service.stake;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.StakeInfoByDayVo;
import com.racing.controller.vo.StakeInfoByRacingNumVo;
import com.racing.model.po.RecordResult;
import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalCommonStake;
import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.po.TotalRacingIncome;
import com.racing.model.po.TotalRankingStake;
import com.racing.model.po.UserAppointStake;
import com.racing.model.po.UserCommonStake;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.UserRankingStake;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.TotalAppointStakeRepo;
import com.racing.model.repo.TotalCommonStakeRepo;
import com.racing.model.repo.TotalDayCountIncomeRepo;
import com.racing.model.repo.TotalRacingIncomeRepo;
import com.racing.model.repo.TotalRankingStakeRepo;
import com.racing.model.repo.UserAppointStakeRepo;
import com.racing.model.repo.UserCommonStakeRepo;
import com.racing.model.repo.UserDayCountIncomeRepo;
import com.racing.model.repo.UserRacingIncomeRepo;
import com.racing.model.repo.UserRankingStakeRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.DateUtil;
import com.racing.util.JsonUtils;

@Service
public class StakeInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StakeInfoService.class);
	
	@Autowired
	private RecordResultRepo recordResultRepo; 
	
	@Autowired
	private TotalAppointStakeRepo totalAppointStakeRepo;
	
	@Autowired
	private TotalCommonStakeRepo totalCommonStakeRepo;
	
	@Autowired
	private TotalRankingStakeRepo totalRankingStakeRepo;
	
	@Autowired
	private TotalRacingIncomeRepo totalRacingIncomeRepo;
	
	@Autowired
	private TotalDayCountIncomeRepo totalDayCountIncomeRepo;

	@Autowired
	private UserAppointStakeRepo userAppointStakeRepo;
	
	@Autowired
	private UserCommonStakeRepo userCommonStakeRepo;
	
	@Autowired
	private UserRankingStakeRepo userRankingStakeRepo;
	
	@Autowired
	private UserRacingIncomeRepo userRacingIncomeRepo;
	
	@Autowired
	private UserDayCountIncomeRepo userDayCountIncomeRepo;
	
	public ApiResult getManagerStakeInfoByRacingNum(String racingNum){
		StakeInfoByRacingNumVo result = new StakeInfoByRacingNumVo();
		RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
		if(recordResult == null){
			return ApiResult.createSuccessReuslt("比赛不存在！");
		}
		if(recordResult.getStartTime().after(new Date())){
			return ApiResult.createSuccessReuslt("暂无比赛结果！");
		}
		result.setRacingNum(racingNum);
		if(DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), new Date())>20){//时间差超过20秒显示开奖结果
			result.setResult(RecordResultPOUtil.convertResult(recordResult));
		}
		
		TotalRacingIncome totalRacingIncome = totalRacingIncomeRepo.selectByRacingNum(racingNum);
		if(totalRacingIncome == null){
			result.setDeficitAmount(BigDecimal.ZERO);
			result.setIncomeAmount(BigDecimal.ZERO);
			result.setStakeAmount(BigDecimal.ZERO);
			result.setStakeCount(0);
		}else{
			result.setDeficitAmount(totalRacingIncome.getDeficitAmount());
			result.setIncomeAmount(totalRacingIncome.getIncomeAmount());
			result.setStakeAmount(totalRacingIncome.getStakeAmount());
			result.setStakeCount(totalRacingIncome.getStakeCount());
		}
		
		List<TotalAppointStake> totalAppointStakeList = totalAppointStakeRepo.getByRacingNum(racingNum);
		List<AppointStake> appointStakeList = new ArrayList<AppointStake>();
		for(TotalAppointStake totalAppointStake : totalAppointStakeList){
			AppointStake appointStake = new AppointStake();
			 try {
                 PropertyUtils.copyProperties(appointStake, totalAppointStake);
             } catch (Exception e) {
                 LOGGER.error("拷贝属性出现异常", e);
             }
			 appointStakeList.add(appointStake);
		}
		
		TotalCommonStake totalCommonStake = totalCommonStakeRepo.getRacingNum(racingNum);
		CommonStake commonStake = new CommonStake();
		try {
            PropertyUtils.copyProperties(commonStake, totalCommonStake);
        } catch (Exception e) {
            LOGGER.error("拷贝属性出现异常", e);
        }
		
		List<TotalRankingStake> totalRankingStakeList = totalRankingStakeRepo.getRacingNum(racingNum);
		List<RankingStake> rankingStakeList = new ArrayList<RankingStake>();
		for(TotalRankingStake totalRankingStake : totalRankingStakeList){
			RankingStake rankingStake = new RankingStake();
			try {
                PropertyUtils.copyProperties(rankingStake, totalRankingStake);
            } catch (Exception e) {
                LOGGER.error("拷贝属性出现异常", e);
            }
			rankingStakeList.add(rankingStake);
		}
		
		StakeVo stakeVo = new StakeVo();
		stakeVo.setRacingNum(racingNum);
		stakeVo.setAppointStakeList(appointStakeList);
		stakeVo.setCommonStake(commonStake);
		stakeVo.setRankingStakeList(rankingStakeList);
		
		result.setStakeVo(stakeVo);
		return ApiResult.createSuccessReuslt(result);
	}
	
	public ApiResult getManagerStakeInfoByDay(String day) throws ParseException{
		StakeInfoByDayVo result = new StakeInfoByDayVo();
		TotalDayCountIncomeWithBLOBs dayCountIncomeWithBLOBs = totalDayCountIncomeRepo.getByDay(DateUtil.parseToDate(day, DateUtil.DateFormat_yyyy_MM_dd));
		result.setDay(day);
		if(dayCountIncomeWithBLOBs == null){
			result.setDeficitAmount(BigDecimal.ZERO);
			result.setIncomeAmount(BigDecimal.ZERO);
			result.setStakeAmount(BigDecimal.ZERO);
			result.setStakeCount(0);
			result.setStakeVo(StakeVoUtil.createNewStake(""));
		}else{
			result.setDeficitAmount(dayCountIncomeWithBLOBs.getDeficitAmount());
			result.setIncomeAmount(dayCountIncomeWithBLOBs.getIncomeAmount());
			result.setStakeAmount(dayCountIncomeWithBLOBs.getStakeAmount());
			result.setStakeCount(0);
			StakeVo stakeVo = new StakeVo();
			stakeVo.setAppointStakeList(JsonUtils.toObjList(dayCountIncomeWithBLOBs.getAppointStake(), AppointStake.class));
			stakeVo.setCommonStake(JsonUtils.toObj(dayCountIncomeWithBLOBs.getCommonStake(), CommonStake.class));
			stakeVo.setRankingStakeList(JsonUtils.toObjList(dayCountIncomeWithBLOBs.getRankingStake(), RankingStake.class));
			stakeVo.setRacingNum("");
			result.setStakeVo(stakeVo);
		}
		return ApiResult.createSuccessReuslt(result);
	}
	
	public ApiResult getUserStakeInfoByRacingNum(Integer userId, String racingNum){
		StakeInfoByRacingNumVo result = new StakeInfoByRacingNumVo();
		RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
		if(recordResult == null){
			return ApiResult.createSuccessReuslt("比赛不存在！");
		}
		if(recordResult.getStartTime().after(new Date())){
			return ApiResult.createSuccessReuslt("暂无比赛结果！");
		}
		result.setRacingNum(racingNum);
		if(DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), new Date())>20){//时间差超过20秒显示开奖结果
			result.setResult(RecordResultPOUtil.convertResult(recordResult));
		}
		
		UserRacingIncome userRacingIncome = userRacingIncomeRepo.selectByRacingNumAndUserId(racingNum, userId);
		if(userRacingIncome == null){
			result.setDeficitAmount(BigDecimal.ZERO);
			result.setIncomeAmount(BigDecimal.ZERO);
			result.setStakeAmount(BigDecimal.ZERO);
			result.setStakeCount(0);
		}else{
			result.setDeficitAmount(userRacingIncome.getTotalDeficitAmount());
			result.setIncomeAmount(userRacingIncome.getTotalIncomeAmount());
			result.setStakeAmount(userRacingIncome.getTotalStakeAmount());
			result.setStakeCount(userRacingIncome.getTotalStakeCount());
		}
		
		
		List<UserAppointStake> userAppointStakeList = userAppointStakeRepo.getByRacingNumAndUserId(racingNum, userId);
		List<AppointStake> appointStakeList = new ArrayList<AppointStake>();
		for(UserAppointStake userAppointStake : userAppointStakeList){
			AppointStake appointStake = new AppointStake();
			 try {
                 PropertyUtils.copyProperties(appointStake, userAppointStake);
             } catch (Exception e) {
                 LOGGER.error("拷贝属性出现异常", e);
             }
			 appointStakeList.add(appointStake);
		}
		
		UserCommonStake userCommonStake = userCommonStakeRepo.getByRacingNumAndUserId(racingNum, userId);
		CommonStake commonStake = new CommonStake();
		try {
            PropertyUtils.copyProperties(commonStake, userCommonStake);
        } catch (Exception e) {
            LOGGER.error("拷贝属性出现异常", e);
        }
		
		List<UserRankingStake> userRankingStakeList = userRankingStakeRepo.getByRacingNumAndUserId(racingNum, userId);
		List<RankingStake> rankingStakeList = new ArrayList<RankingStake>();
		for(UserRankingStake userRankingStake : userRankingStakeList){
			RankingStake rankingStake = new RankingStake();
			try {
                PropertyUtils.copyProperties(rankingStake, userRankingStake);
            } catch (Exception e) {
                LOGGER.error("拷贝属性出现异常", e);
            }
			rankingStakeList.add(rankingStake);
		}
		
		StakeVo stakeVo = new StakeVo();
		stakeVo.setRacingNum(racingNum);
		stakeVo.setAppointStakeList(appointStakeList);
		stakeVo.setCommonStake(commonStake);
		stakeVo.setRankingStakeList(rankingStakeList);
		
		result.setStakeVo(stakeVo);
		return ApiResult.createSuccessReuslt(result);
	}
	
	public ApiResult getUserStakeInfoByDay(Integer userId, String day) throws ParseException{
		StakeInfoByDayVo result = new StakeInfoByDayVo();
		UserDayCountIncomeWithBLOBs dayCountIncomeWithBLOBs = userDayCountIncomeRepo.getByDay(DateUtil.parseToDate(day, DateUtil.DateFormat_yyyy_MM_dd), userId);
		result.setDay(day);
		if(dayCountIncomeWithBLOBs == null){
			result.setDeficitAmount(BigDecimal.ZERO);
			result.setIncomeAmount(BigDecimal.ZERO);
			result.setStakeAmount(BigDecimal.ZERO);
			result.setStakeCount(0);
			result.setStakeVo(StakeVoUtil.createNewStake(""));
		}else{
			result.setDeficitAmount(dayCountIncomeWithBLOBs.getTotalDeficitAmount());
			result.setIncomeAmount(dayCountIncomeWithBLOBs.getTotalIncomeAmount());
			result.setStakeAmount(dayCountIncomeWithBLOBs.getTotalStakeAmount());
			result.setStakeCount(0);
			StakeVo stakeVo = new StakeVo();
			stakeVo.setAppointStakeList(JsonUtils.toObjList(dayCountIncomeWithBLOBs.getAppointStake(), AppointStake.class));
			stakeVo.setCommonStake(JsonUtils.toObj(dayCountIncomeWithBLOBs.getCommonStake(), CommonStake.class));
			stakeVo.setRankingStakeList(JsonUtils.toObjList(dayCountIncomeWithBLOBs.getRankingStake(), RankingStake.class));
			stakeVo.setRacingNum("");
			result.setStakeVo(stakeVo);
		}
		return ApiResult.createSuccessReuslt(result);
	}
	
	
}
