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
        totalStakeAmount = totalStakeAmount.add(this.invokeMemberStake(stake, userId, totalStakeCount));
      }
    }


    return ApiResult.createSuccessReuslt();
  }


  private BigDecimal invokeMemberStake(MemberStakeVo stake, Integer userId, int totalStakeCount) {
    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    if (stake != null) {
      Members members = membersRepo.getById(stake.getMemberId());
      if (members == null || !members.getUserId().equals(userId)) {// 未查询到members或members的userId不是该用户的ID
        throw new RuntimeException("memberId为" + stake.getMemberId() + "的用户不存在！");
      }
      StakeVo stakeVo = stake.getStakeVo();

    }
    return null;
  }

}
