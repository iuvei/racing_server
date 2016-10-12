package com.racing.service.members;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.constant.MembersConstant;
import com.racing.constant.UserConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MemberStakeVo;
import com.racing.model.po.MemberStakeWithBLOBs;
import com.racing.model.po.Members;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.po.TotalRacingIncome;
import com.racing.model.po.User;
import com.racing.model.po.UserAccountRecord;
import com.racing.model.po.UserAppointStake;
import com.racing.model.po.UserCommonStake;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.po.UserRankingStake;
import com.racing.model.repo.MembersAccountRecordRepo;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.MembersStakeRepo;
import com.racing.model.repo.TotalAppointStakeRepo;
import com.racing.model.repo.TotalCommonStakeRepo;
import com.racing.model.repo.TotalRacingIncomeRepo;
import com.racing.model.repo.TotalRankingStakeRepo;
import com.racing.model.repo.UserAccountRecordRepo;
import com.racing.model.repo.UserAppointStakeRepo;
import com.racing.model.repo.UserCommonStakeRepo;
import com.racing.model.repo.UserRacingIncomeRepo;
import com.racing.model.repo.UserRankingStakeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeCountInfoVo;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.JsonUtils;

@Service
public class StakeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StakeService.class);
	
  @Autowired
  private UserRepo userRepo;

  @Autowired
  private MembersStakeRepo membersStakeRepo;

  @Autowired
  private MembersAccountRecordRepo membersAccountRecordRepo;
  
  @Autowired
  private UserCommonStakeRepo userCommonStakeRepo;
  
  @Autowired
  private UserRankingStakeRepo userRankingStakeRepo;
  
  @Autowired
  private UserAppointStakeRepo userAppointStakeRepo;

  @Autowired
  private TotalCommonStakeRepo totalCommonStakeRepo;
  
  @Autowired
  private TotalRankingStakeRepo totalRankingStakeRepo;
  
  @Autowired
  private TotalAppointStakeRepo totalAppointStakeRepo;
  
  @Autowired
  private MembersRepo membersRepo;
  
  @Autowired
  private UserAccountRecordRepo userAccountRecordRepo;
  
  @Autowired
  private UserRacingIncomeRepo userRacingIncomeRepo;

  @Autowired
  private TotalRacingIncomeRepo totalRacingIncomeRepo;
  
  public ApiResult memberStake(Integer userId, List<MemberStakeVo> stakeList) {

    User user = userRepo.selectById(userId);
    if(user == null){
    	throw new RuntimeException("分盘用户不存在！");
    }
    
    Date operationDate = new Date();
    
    String racingNum = "";//TODO 期号应该通过时间获取当前比赛可押注的期号
    StakeVo userTotalStakeVo = StakeVoUtil.createNewStake(racingNum);
    
    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int totalStakeCount = 0;
    
    //--------玩家处理---------开始---------
    if (stakeList != null) {
      for (MemberStakeVo stake : stakeList) {
        StakeCountInfoVo countInfoVo = this.invokeMemberStake(stake, userId, operationDate);
        totalStakeAmount = totalStakeAmount.add(countInfoVo.getTotalStakeAmount());
        totalStakeCount = totalStakeCount + countInfoVo.getTotalStakeCount();
        userTotalStakeVo = StakeVoUtil.stakeAdd(userTotalStakeVo, stake.getStakeVo());
      }
    }
    //--------玩家处理---------结束---------
    
    if(user.getTotalPoints().compareTo(totalStakeAmount)<0){
    	throw new RuntimeException("分盘整体积分不足，无法报盘！");
    }
    
    //--------分盘处理---------开始---------
    this.invokeCheckUserStakeIsHave(userId, userTotalStakeVo.getRacingNum());
    
    userCommonStakeRepo.updateUserStake(userId, racingNum, userTotalStakeVo.getCommonStake());
    userRankingStakeRepo.updateUserStake(userId, racingNum, userTotalStakeVo.getRankingStakeList());
    userAppointStakeRepo.updateUserStake(userId, racingNum, userTotalStakeVo.getAppointStakeList());
    //处理分盘积分操作记录
    this.invokeStakeToUserAccountRecord(userId, totalStakeAmount, BigDecimal.ZERO, operationDate);
    //处理分盘期号统计
    this.invokeUserRacingIncome(userId, racingNum, totalStakeAmount, BigDecimal.ZERO, totalStakeCount, 0);
    //--------总盘处理---------结束---------
    
    
    //--------总盘处理---------开始---------
    totalCommonStakeRepo.updateStake(racingNum, userTotalStakeVo.getCommonStake());
    totalRankingStakeRepo.updateStake(racingNum, userTotalStakeVo.getRankingStakeList());
    totalAppointStakeRepo.updateStake(racingNum, userTotalStakeVo.getAppointStakeList());
    this.invokeTotalRacingIncome(racingNum, totalStakeAmount, totalStakeCount);
    //--------总盘处理---------结束---------
    return ApiResult.createSuccessReuslt();
  }
  
  private void invokeTotalRacingIncome(String racingNum, BigDecimal stakeAmount, int stakeCount){
	  TotalRacingIncome racingIncome = new TotalRacingIncome();
	  racingIncome.setDeficitAmount(BigDecimal.ZERO);
	  racingIncome.setIncomeAmount(BigDecimal.ZERO);
	  racingIncome.setRacingNum(racingNum);
	  racingIncome.setStakeAmount(stakeAmount);
	  racingIncome.setStakeCount(stakeCount);
	  totalRacingIncomeRepo.updateRacingIncome(racingIncome);
  }
  
  /**
   * 处理分盘期号统计
   * @param userId
   * @param racingNum
   * @param memberStakeAmount
   * @param userStakeAmount
   * @param memberStakeCount
   * @param userStakeCount
   */
  private void invokeUserRacingIncome(Integer userId, String racingNum, BigDecimal memberStakeAmount, BigDecimal userStakeAmount, int memberStakeCount, int userStakeCount){
	  UserRacingIncome racingIncome = new UserRacingIncome();
	  racingIncome.setUserId(userId);
	  racingIncome.setRacingNum(racingNum);
	  racingIncome.setMembersDeficitAmount(BigDecimal.ZERO);
	  racingIncome.setMembersIncomeAmount(BigDecimal.ZERO);
	  racingIncome.setMembersStakeAmount(memberStakeAmount);
	  racingIncome.setMembersStakeCount(memberStakeCount);
	  racingIncome.setTotalDeficitAmount(BigDecimal.ZERO);
	  racingIncome.setTotalIncomeAmount(BigDecimal.ZERO);
	  racingIncome.setTotalStakeAmount(memberStakeAmount.add(userStakeAmount));
	  racingIncome.setTotalStakeCount(userStakeCount + memberStakeCount);
	  racingIncome.setUserDeficitAmount(BigDecimal.ZERO);
	  racingIncome.setUserIncomeAmount(BigDecimal.ZERO);
	  racingIncome.setUserStakeAmount(userStakeAmount);
	  racingIncome.setUserStakeCount(userStakeCount);
	  userRacingIncomeRepo.updateIncome(racingIncome);
  }
  
  /**
   * 处理报盘时分盘用户的积分
   * @param userId
   * @param accountRecordType
   * @param memberStakeAmount
   * @param userStakeAmount
   * @param operationDate
   */
  private void invokeStakeToUserAccountRecord(Integer userId, BigDecimal memberStakeAmount, BigDecimal userStakeAmount, Date operationDate){
	  if(userStakeAmount == null){
		  userStakeAmount = BigDecimal.ZERO;
	  }
	  if(memberStakeAmount == null){
		  memberStakeAmount = BigDecimal.ZERO;
	  }
	  userRepo.updatePoint(userId, userStakeAmount.negate(), memberStakeAmount.negate());
	  
	  User user = userRepo.selectById(userId);
	  
	  UserAccountRecord userAccountRecord = new UserAccountRecord();
      userAccountRecord.setUserId(user.getId());
      userAccountRecord.setType(UserConstant.ACCOUNT_RECORD_TYPE_OFFER);
      userAccountRecord.setOperationTotalPoints(userStakeAmount.add(memberStakeAmount).negate());
      userAccountRecord.setResultTotalPoints(user.getTotalPoints());
      userAccountRecord.setOperationUserPoints(userStakeAmount.negate());
      userAccountRecord.setResultUserPoints(user.getUserPoints());
      userAccountRecord.setOperationMembersPoints(memberStakeAmount.negate());
      userAccountRecord.setResultMembersPoints(user.getMembersPoints());
      userAccountRecord.setOperationTime(operationDate);
      userAccountRecordRepo.insert(userAccountRecord);
  }

  /**
   * 该期号没有押注初始化出来押注数据
   * @param userId
   * @param racingNum
   * @param totalStakeCount
   * @param totalStakeAmount
   */
  private synchronized void invokeCheckUserStakeIsHave(Integer userId, String racingNum){
	  UserCommonStake oldUserCommonStake = userCommonStakeRepo.getByRacingNumAndUserId(racingNum, userId);
	  if(oldUserCommonStake == null){
		  oldUserCommonStake = new UserCommonStake();
		  try {
	            PropertyUtils.copyProperties(oldUserCommonStake, new CommonStake());
	        } catch (Exception e) {
	            LOGGER.error("拷贝属性出现异常", e);
	        }
		  userCommonStakeRepo.addNew(oldUserCommonStake, userId, racingNum);
	  }
	  
	  List<UserRankingStake> oldUserRankingStakeList = userRankingStakeRepo.getByRacingNumAndUserId(racingNum, userId);
	  if(CollectionUtils.isEmpty(oldUserRankingStakeList)){
		  oldUserRankingStakeList = new ArrayList<UserRankingStake>();
		  for(int i = 0; i<10; i++){
			  UserRankingStake rankingStake = new UserRankingStake();
			  RankingStake newRankingStake = new RankingStake();
			  newRankingStake.setRankingNum(i+1);
			  try {
		            PropertyUtils.copyProperties(rankingStake, newRankingStake);
		        } catch (Exception e) {
		            LOGGER.error("拷贝属性出现异常", e);
		        }
			  oldUserRankingStakeList.add(rankingStake);
		  }
		  userRankingStakeRepo.addNew(oldUserRankingStakeList, userId, racingNum);
	  }
	  
	  List<UserAppointStake> oldUserAppointStakeList =  userAppointStakeRepo.getByRacingNumAndUserId(racingNum, userId);
	  if(CollectionUtils.isEmpty(oldUserAppointStakeList)){
		  oldUserAppointStakeList = new ArrayList<UserAppointStake>();
		  for(int i = 0; i<10; i++){
			  UserAppointStake userAppointStake = new UserAppointStake();
			  AppointStake newAppointStake = new AppointStake();
			  newAppointStake.setCarNum(i+1);
			  try {
		            PropertyUtils.copyProperties(userAppointStake, newAppointStake);
		        } catch (Exception e) {
		            LOGGER.error("拷贝属性出现异常", e);
		        }
			  oldUserAppointStakeList.add(userAppointStake);
		  }
		  userAppointStakeRepo.addNew(oldUserAppointStakeList, userId, racingNum);
	  }
	  
  }

  private StakeCountInfoVo invokeMemberStake(MemberStakeVo stake, Integer userId, Date operationDate) {
    StakeCountInfoVo result = new StakeCountInfoVo();
    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int totalStakeCount = 0;
    if (stake != null) {
      Members members = membersRepo.getById(stake.getMemberId());
      if (members == null || !members.getUserId().equals(userId)) {// 未查询到members或members的userId不是该用户的ID
        throw new RuntimeException("memberId为" + stake.getMemberId() + "的用户不存在！");
      }
      
      StakeVo stakeVo = stake.getStakeVo();
      StakeCountInfoVo stakeCountInfoVo = StakeVoUtil.getStakeCountInfo(stakeVo);
      totalStakeAmount = stakeCountInfoVo.getTotalStakeAmount();
      totalStakeCount = stakeCountInfoVo.getTotalStakeCount();

      if(members.getPoints().compareTo(totalStakeAmount)<0){//玩家当前积分小于下注积分，不进行下注
    	  throw new RuntimeException("memberId为" + stake.getMemberId() + "的用户积分不足，无法进行下注！");
      }
      membersRepo.updatePoints(stake.getMemberId(), totalStakeAmount.negate());//更新玩家的剩余积分
      
      MemberStakeWithBLOBs memberStake = new MemberStakeWithBLOBs();
      memberStake.setCreateTime(operationDate);
      memberStake.setMembersId(stake.getMemberId());
      memberStake.setRacingNum(stakeVo.getRacingNum());
      memberStake.setTotalDeficitAmount(BigDecimal.ZERO);
      memberStake.setTotalIncomeAmount(BigDecimal.ZERO);
      memberStake.setTotalStakeAmount(totalStakeAmount);
      memberStake.setTotalStakeCount(totalStakeCount);
      
      memberStake.setAppointStake(JsonUtils.toJsonHasNullKey(stakeVo.getAppointStakeList()));
      memberStake.setCommonStake(JsonUtils.toJsonHasNullKey(stakeVo.getCommonStake()));
      memberStake.setRankingStake(JsonUtils.toJsonHasNullKey(stakeVo.getRankingStakeList()));
      
      membersStakeRepo.addNew(memberStake);
      MembersAccountRecord accountRecord = new MembersAccountRecord();
      accountRecord.setMembersId(stake.getMemberId());
      accountRecord.setOperationPoints(totalStakeAmount.negate());
      accountRecord.setOperationTime(operationDate);
      accountRecord.setResultPoints(members.getPoints().subtract(totalStakeAmount));
      accountRecord.setType(MembersConstant.ACCOUNT_RECORD_TYPE_STAKE);//下注
      
      
      membersAccountRecordRepo.addNew(accountRecord);

    }
    result.setTotalStakeAmount(totalStakeAmount);
    result.setTotalStakeCount(totalStakeCount);
    return result;
  }

}
