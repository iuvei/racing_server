package com.racing.service.members;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.constant.MembersConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MemberStakeVo;
import com.racing.model.po.MemberStakeWithBLOBs;
import com.racing.model.po.Members;
import com.racing.model.po.MembersAccountRecord;
import com.racing.model.po.User;
import com.racing.model.po.UserCommonStake;
import com.racing.model.repo.MembersAccountRecordRepo;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.MembersStakeRepo;
import com.racing.model.repo.UserCommonStakeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.model.stake.StakeCountInfoVo;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.util.JsonUtils;

@Service
public class StakeService {

  @Autowired
  private UserRepo repo;

  @Autowired
  private MembersStakeRepo membersStakeRepo;

  @Autowired
  private MembersAccountRecordRepo membersAccountRecordRepo;
  
  @Autowired
  private UserCommonStakeRepo userCommonStakeRepo;
  
  @Autowired
  private MembersRepo membersRepo;
  
  

  public ApiResult memberStake(Integer userId, List<MemberStakeVo> stakeList) {

    User user = repo.selectById(userId);
    if(user == null){
    	throw new RuntimeException("分盘用户不存在！");
    }

    StakeVo userTotalStakeVo = StakeVoUtil.createNewStake("");//TODO 期号应该通过时间获取当前比赛可押注的期号
    
    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int totalStakeCount = 0;
    if (stakeList != null) {
      for (MemberStakeVo stake : stakeList) {
        StakeCountInfoVo countInfoVo = this.invokeMemberStake(stake, userId);
        totalStakeAmount = totalStakeAmount.add(countInfoVo.getTotalStakeAmount());
        totalStakeCount = totalStakeCount + countInfoVo.getTotalStakeCount();
        userTotalStakeVo = StakeVoUtil.stakeAdd(userTotalStakeVo, stake.getStakeVo());
      }
    }


    return ApiResult.createSuccessReuslt();
  }

  private boolean invokeUserStake(Integer userId, StakeVo userTotalStakeVo, int totalStakeCount, BigDecimal totalStakeAmount){
	  
	  
	  return true;
  }

  private StakeCountInfoVo invokeMemberStake(MemberStakeVo stake, Integer userId) {
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
      
      Date operationDate = new Date();
      
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
