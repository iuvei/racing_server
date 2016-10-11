package com.racing.service.members;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MemberStakeVo;
import com.racing.controller.vo.StakeVo;
import com.racing.model.po.Members;
import com.racing.model.po.User;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.MembersStakeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.model.stake.StakeCountInfoVo;
import com.racing.model.stake.util.StakeVoUtil;

@Service
public class MemberStakeService {

  @Autowired
  private UserRepo repo;

  @Autowired
  private MembersStakeRepo membersStakeRepo;

  @Autowired
  private MembersRepo membersRepo;

  public ApiResult memberStake(Integer userId, List<MemberStakeVo> stakeList) {

    User user = repo.selectById(userId);

    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int totalStakeCount = 0;
    if (stakeList != null) {
      for (MemberStakeVo stake : stakeList) {
        StakeCountInfoVo countInfoVo = this.invokeMemberStake(stake, userId);
        totalStakeAmount = totalStakeAmount.add(countInfoVo.getTotalStakeAmount());
        totalStakeCount = totalStakeCount + countInfoVo.getTotalStakeCount();
      }
    }


    return ApiResult.createSuccessReuslt();
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



    }
    result.setTotalStakeAmount(totalStakeAmount);
    result.setTotalStakeCount(totalStakeCount);
    return result;
  }

}
