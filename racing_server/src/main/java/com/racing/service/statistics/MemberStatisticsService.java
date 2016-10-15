package com.racing.service.statistics;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.racing.constant.MembersConstant;
import com.racing.constant.UserConstant;
import com.racing.model.po.MemberStakeWithBLOBs;
import com.racing.model.po.Members;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.po.MembersDayCountIncome;
import com.racing.model.po.RecordResult;
import com.racing.model.po.User;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.po.UserDayCountIncomeWithBLOBs;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.util.MemberStakeConvertUtil;
import com.racing.model.repo.MembersAccountRecordRepo;
import com.racing.model.repo.MembersDayCountIncomeRepo;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.MembersStakeRepo;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.UserAccountRecordRepo;
import com.racing.model.repo.UserDayCountIncomeRepo;
import com.racing.model.repo.UserRacingIncomeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.model.stake.StakeVo;
import com.racing.service.calc.CalculationHandle;
import com.racing.service.calc.bo.CalcRate;
import com.racing.util.DateUtil;

@Service
public class MemberStatisticsService {

	@Autowired
	private RecordResultRepo recordResultRepo;
	
	@Autowired
	private UserRacingIncomeRepo userRacingIncomeRepo; 
	
	@Autowired
	private UserDayCountIncomeRepo userDayCountIncomeRepo;
	
	@Autowired
	private UserAccountRecordRepo userAccountRecordRepo;
	
	@Autowired
	private MembersStakeRepo membersStakeRepo;
	
	@Autowired
	private MembersRepo membersRepo;
	
	@Autowired
	private MembersDayCountIncomeRepo membersDayCountIncomeRepo;
	
	@Autowired
	private MembersAccountRecordRepo membersAccountRecordRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Transactional(rollbackFor = Exception.class)
	public BigDecimal dealMemberIncome(Integer[] recordResult, String racingNum, Integer memberId, CalcRate calcRate){
		
		MemberStakeWithBLOBs stakeWithBLOBs = membersStakeRepo.getStakeInfoByMembersIdAndTacingNum(memberId, racingNum);
		if(stakeWithBLOBs == null||stakeWithBLOBs.getTotalStakeAmount().compareTo(BigDecimal.ZERO)==0){
			return BigDecimal.ZERO;
		}
		
		StakeVo stakeVo = MemberStakeConvertUtil.convertUserStakeJsonToBean(stakeWithBLOBs);
		BigDecimal result = new CalculationHandle(calcRate).dealCalculation(recordResult, stakeVo.getAppointStakeList(), stakeVo.getCommonStake(), stakeVo.getRankingStakeList());
		
		MemberStakeWithBLOBs memberStake = new MemberStakeWithBLOBs();
		memberStake.setTotalIncomeAmount(result);
		memberStake.setTotalStakeAmount(BigDecimal.ZERO);
		memberStake.setTotalStakeCount(0);
		memberStake.setRacingNum(racingNum);
		memberStake.setMembersId(memberId);
		memberStake.setIsComplateStatistics(true);
		membersStakeRepo.updateIncome(memberStake);
		
		membersRepo.updatePoints(memberId, result);// 更新玩家的剩余积分
		
		Members members = membersRepo.getById(memberId);
		
		membersStakeRepo.addNew(memberStake);
		MembersAccountRecord accountRecord = new MembersAccountRecord();
		accountRecord.setMembersId(memberId);
		accountRecord.setOperationPoints(result);
		accountRecord.setOperationTime(new Date());
		accountRecord.setResultPoints(members.getPoints());
		accountRecord.setType(MembersConstant.ACCOUNT_RECORD_TYPE_LOTTERY);// 下注
		membersAccountRecordRepo.add(accountRecord);

		MembersDayCountIncome dayCountIncome = new MembersDayCountIncome();
		dayCountIncome.setDay(DateUtil.parseToString(new Date(), DateUtil.DateFormat_yyyy_MM_dd));
		dayCountIncome.setMembersId(memberId);
		dayCountIncome.setIncomeAmount(result);
		dayCountIncome.setStakeAmount(stakeWithBLOBs.getTotalStakeAmount());
		dayCountIncome.setStakeCount(stakeWithBLOBs.getTotalStakeCount());
		membersDayCountIncomeRepo.updateIncome(dayCountIncome);
		
		return result;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void completedStatistics(String racingNum, Integer userId, BigDecimal totalMemberIncomeAmount){
		
		//处理按期号逻辑
		UserRacingIncome racingIncome = new UserRacingIncome();
		racingIncome.setUserId(userId);
		racingIncome.setRacingNum(racingNum);
		racingIncome.setMembersIncomeAmount(totalMemberIncomeAmount);
		racingIncome.setMembersStakeAmount(BigDecimal.ZERO);
		racingIncome.setMembersStakeCount(0);
		racingIncome.setTotalIncomeAmount(BigDecimal.ZERO);
		racingIncome.setTotalStakeAmount(BigDecimal.ZERO);
		racingIncome.setTotalStakeCount(0);
		racingIncome.setUserIncomeAmount(totalMemberIncomeAmount.negate());//按期号统计中，分盘用户积分收入=总收入(此处数据库中存储的就是总收入，在计算分盘统计时放入的)-玩家收入
		racingIncome.setUserStakeAmount(BigDecimal.ZERO);
		racingIncome.setUserStakeCount(0);
		racingIncome.setIsComplateStatistics(true);
		
		userRacingIncomeRepo.updateIncome(racingIncome);
		
		//处理按日期逻辑
		RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
		
		UserDayCountIncomeWithBLOBs dayCountIncome = new UserDayCountIncomeWithBLOBs();
		dayCountIncome.setDay(DateUtil.parseToString(recordResult.getStartTime(), DateUtil.DateFormat_yyyy_MM_dd));
		dayCountIncome.setUserId(userId);
		
		dayCountIncome.setMembersIncomeAmount(totalMemberIncomeAmount);
		dayCountIncome.setMembersStakeAmount(BigDecimal.ZERO);
		dayCountIncome.setMembersStakeCount(0);
		dayCountIncome.setTotalIncomeAmount(BigDecimal.ZERO);
		dayCountIncome.setTotalStakeAmount(BigDecimal.ZERO);
		dayCountIncome.setTotalStakeCount(0);
		dayCountIncome.setUserIncomeAmount(totalMemberIncomeAmount.negate());//按天统计中，分盘用户的收入积分=总收入积分(此处数据库中存储的就是总收入，在计算分盘统计时放入的)-玩家收入积分
		dayCountIncome.setUserStakeAmount(BigDecimal.ZERO);
		dayCountIncome.setUserStakeCount(0);

		userDayCountIncomeRepo.updateIncomeWithoutStake(dayCountIncome);
		
		UserRacingIncome newUserRacingIncome = userRacingIncomeRepo.selectByRacingNumAndUserId(racingNum, userId);
		
		//分盘用户结余积分=本期比赛分盘总收入积分-玩家收入积分
		userRepo.updatePoint(userId, newUserRacingIncome.getUserIncomeAmount(), newUserRacingIncome.getMembersIncomeAmount());

		User user = userRepo.selectById(userId);

		UserAccountRecord userAccountRecord = new UserAccountRecord();
		userAccountRecord.setUserId(user.getId());
		userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_LOTTERY);
		userAccountRecord.setOperationTotalPoints(newUserRacingIncome.getTotalIncomeAmount());
		userAccountRecord.setResultTotalPoints(user.getTotalPoints());
		//本次开奖改变的分盘用户积分=本期比赛分盘总收入积分-玩家收入积分
		userAccountRecord.setOperationUserPoints(newUserRacingIncome.getUserIncomeAmount());
		userAccountRecord.setResultUserPoints(user.getUserPoints());
		userAccountRecord.setOperationMembersPoints(newUserRacingIncome.getMembersIncomeAmount());
		userAccountRecord.setResultMembersPoints(user.getMembersPoints());
		userAccountRecord.setOperationTime(new Date());
		userAccountRecordRepo.insert(userAccountRecord);
		
		
	}
	
}
