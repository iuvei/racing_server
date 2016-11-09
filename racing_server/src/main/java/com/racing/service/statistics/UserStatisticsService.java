package com.racing.service.statistics;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.racing.constant.DefaultRacteConstant;
import com.racing.model.po.RecordResult;
import com.racing.model.po.User;
import com.racing.model.po.UserAppointStake;
import com.racing.model.po.UserCommonStake;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.UserRankingStake;
import com.racing.model.po.UserStakeWithBLOBs;
import com.racing.model.po.util.UserStakeConvertUtil;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.UserAppointStakeRepo;
import com.racing.model.repo.UserCommonStakeRepo;
import com.racing.model.repo.UserDayCountIncomeRepo;
import com.racing.model.repo.UserRacingIncomeRepo;
import com.racing.model.repo.UserRankingStakeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.model.repo.UserStakeRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.service.calc.CalculationHandle;
import com.racing.service.calc.bo.CalcRate;
import com.racing.util.DateUtil;
import com.racing.util.JsonUtils;

@Service
public class UserStatisticsService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RecordResultRepo recordResultRepo;
	
	@Autowired
	private UserCommonStakeRepo commonStakeRepo;
	
	@Autowired
	private UserAppointStakeRepo appointStakeRepo;

	@Autowired
	private UserRankingStakeRepo rankingStakeRepo;
	
	@Autowired
	private UserRacingIncomeRepo userRacingIncomeRepo;
	
	@Autowired
	private UserStakeRepo userStakeRepo;
	
	@Autowired
	private UserDayCountIncomeRepo userDayCountIncomeRepo;
	
	@Autowired
	private MemberStatisticsInvoke memberStatisticsInvoke;
	
	private CalcRate userDefaultCalcRate;
	
	@PostConstruct
	public void init() {
		userDefaultCalcRate = DefaultRacteConstant.totalDefaultCalcRate;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void dealUserIncome(Integer userId){
		Date nowDate = new Date();
		User user = userRepo.selectById(userId);
		if(user == null){
			return;
		}
		RecordResult recordResult = recordResultRepo.getNowBeforLastRecordResult(new Date());
		if(recordResult == null){
			return;
		}else {
			long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
			if(betweenTime>300){
				return;
			}
		}
		Integer[] racingResult = RecordResultPOUtil.convertResult(recordResult);
		
		String racingNum = recordResult.getRacingNum();
		
		UserRacingIncome oldUserRacingIncome = userRacingIncomeRepo.selectByRacingNumAndUserId(racingNum, userId);
		if(oldUserRacingIncome!=null && oldUserRacingIncome.getIsComplateStatistics()){
			return;
		}
		
		StakeVo newTotalUserStakeVo = this.getUserTotalStake(racingNum, userId);
		BigDecimal totalUserResult = new CalculationHandle(userDefaultCalcRate).dealCalculation(racingResult, newTotalUserStakeVo.getAppointStakeList(), newTotalUserStakeVo.getCommonStake(), newTotalUserStakeVo.getRankingStakeList());
		
		StakeVo newUserStakeVo = this.getUserStake(racingNum, userId);
		BigDecimal userResult = new CalculationHandle(userDefaultCalcRate).dealCalculation(racingResult, newUserStakeVo.getAppointStakeList(), newUserStakeVo.getCommonStake(), newUserStakeVo.getRankingStakeList());
		
		UserStakeWithBLOBs userStake = new UserStakeWithBLOBs();
		userStake.setTotalIncomeAmount(userResult);
		userStake.setTotalStakeAmount(BigDecimal.ZERO);
		userStake.setTotalStakeCount(0);
		userStake.setRacingNum(racingNum);
		userStake.setUserId(userId);
		userStakeRepo.updateIncome(userStake);
		
		UserRacingIncome racingIncome = new UserRacingIncome();
		racingIncome.setUserId(userId);
		racingIncome.setRacingNum(racingNum);
		racingIncome.setMembersIncomeAmount(BigDecimal.ZERO);
		racingIncome.setMembersStakeAmount(BigDecimal.ZERO);
		racingIncome.setMembersStakeCount(0);
		racingIncome.setTotalIncomeAmount(totalUserResult);
		racingIncome.setTotalStakeAmount(BigDecimal.ZERO);
		racingIncome.setTotalStakeCount(0);
		racingIncome.setUserIncomeAmount(totalUserResult);//分盘用户的收入，此处为临时值，存入总的收入，真实值后面会更新掉，真实值=总的收入-玩家的收入（玩家的收入=分盘赔率通过玩家押注计算出来的积分）
		racingIncome.setUserStakeAmount(BigDecimal.ZERO);
		racingIncome.setUserStakeCount(0);
		racingIncome.setIsComplateStatistics(false);
		
		userRacingIncomeRepo.updateIncome(racingIncome);
		
		UserRacingIncome newRacingIncome = userRacingIncomeRepo.selectByRacingNumAndUserId(racingNum, userId);
		
		UserDayCountIncomeWithBLOBs oldDayCountIncome = userDayCountIncomeRepo.getByDay(nowDate, userId);
		StakeVo oldDayStakeVo = UserStakeConvertUtil.convertUserDayStakeJsonToBean(oldDayCountIncome);
		
		newTotalUserStakeVo = StakeVoUtil.stakeAdd(oldDayStakeVo, newTotalUserStakeVo);
		
		UserDayCountIncomeWithBLOBs dayCountIncome = new UserDayCountIncomeWithBLOBs();
		dayCountIncome.setDay(DateUtil.parseToString(nowDate, DateUtil.DateFormat_yyyy_MM_dd));
		dayCountIncome.setUserId(userId);
		
		dayCountIncome.setMembersIncomeAmount(BigDecimal.ZERO);
		dayCountIncome.setMembersStakeAmount(newRacingIncome.getMembersStakeAmount());
		dayCountIncome.setMembersStakeCount(newRacingIncome.getMembersStakeCount());
		dayCountIncome.setTotalIncomeAmount(totalUserResult);
		dayCountIncome.setTotalStakeAmount(newRacingIncome.getTotalStakeAmount());
		dayCountIncome.setTotalStakeCount(newRacingIncome.getTotalStakeCount());
		dayCountIncome.setUserIncomeAmount(totalUserResult);//分盘用户的收入，此处为临时值，存入总的收入，真实值后面会更新掉，真实值=总的收入-玩家的收入（玩家的收入=分盘赔率通过玩家押注计算出来的积分）
		dayCountIncome.setUserStakeAmount(newRacingIncome.getUserStakeAmount());
		dayCountIncome.setUserStakeCount(newRacingIncome.getUserStakeCount());
		
		dayCountIncome.setAppointStake(JsonUtils.toJsonHasNullKey(newTotalUserStakeVo.getAppointStakeList()));
		dayCountIncome.setCommonStake(JsonUtils.toJsonHasNullKey(newTotalUserStakeVo.getCommonStake()));
		dayCountIncome.setRankingStake(JsonUtils.toJsonHasNullKey(newTotalUserStakeVo.getRankingStakeList()));
		
		userDayCountIncomeRepo.updateIncome(dayCountIncome);
		
		
		memberStatisticsInvoke.asyncDealMemberIncome(racingResult, racingNum, userId);//异步执行玩家开奖逻辑
	}
	
	private StakeVo getUserTotalStake(String racingNum, Integer userId){
		StakeVo newStakeVo = new StakeVo(); 
		
		UserCommonStake userCommonStake = commonStakeRepo.getByRacingNumAndUserId(racingNum, userId);
		if(userCommonStake == null){
			newStakeVo = StakeVoUtil.createNewStake(racingNum);
			return newStakeVo;
		}
		CommonStake commonStake = UserStakeConvertUtil.commontStakPoToVo(userCommonStake);
		newStakeVo.setCommonStake(commonStake);
		
		List<UserAppointStake> userAppointStakeList = appointStakeRepo.getByRacingNumAndUserId(racingNum, userId);
		List<AppointStake> appointStakeList = UserStakeConvertUtil.appointStakPoToVo(userAppointStakeList);
		newStakeVo.setAppointStakeList(appointStakeList);
		
		List<UserRankingStake> userRankingStakeList = rankingStakeRepo.getByRacingNumAndUserId(racingNum, userId);
		List<RankingStake> rankingStakeList = UserStakeConvertUtil.rankingPoToVo(userRankingStakeList);
		newStakeVo.setRankingStakeList(rankingStakeList);
		return newStakeVo;
	}

	private StakeVo getUserStake(String racingNum, Integer userId){
		UserStakeWithBLOBs userStakeWithBLOBs = userStakeRepo.getByUserIdAndRacingNum(userId, racingNum);
		if(userStakeWithBLOBs == null){
			return StakeVoUtil.createNewStake(racingNum);
		}else{
			return UserStakeConvertUtil.convertUserStakeJsonToBean(userStakeWithBLOBs);
		}
	}
	
}
