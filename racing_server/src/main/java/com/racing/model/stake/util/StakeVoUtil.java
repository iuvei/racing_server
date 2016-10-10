package com.racing.model.stake.util;

import java.math.BigDecimal;
import java.util.List;

import com.racing.controller.vo.AppointStakeVo;
import com.racing.controller.vo.CommonStakeVo;
import com.racing.controller.vo.StakeVo;
import com.racing.model.stake.StakeCountInfoVo;

public class StakeVoUtil {

  public StakeCountInfoVo getStakeCountInfo(StakeVo stakeVo) {

    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int totalStakeCount = 0;

    CommonStakeVo commonStake = stakeVo.getCommonStake();
    if (commonStake == null) {
      commonStake = new CommonStakeVo();
    } else {
      if (commonStake.getFirstUp() != null && commonStake.getFirstUp().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getFirstUp());
        totalStakeCount++;
      } else {
        commonStake.setFirstUp(BigDecimal.ZERO);
      }
      if (commonStake.getFirstDowm() != null && commonStake.getFirstDowm().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getFirstDowm());
        totalStakeCount++;
      } else {
        commonStake.setFirstDowm(BigDecimal.ZERO);
      }
      if (commonStake.getSecondUp() != null && commonStake.getSecondUp().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getSecondUp());
        totalStakeCount++;
      } else {
        commonStake.setSecondUp(BigDecimal.ZERO);
      }
      if (commonStake.getSecondDowm() != null && commonStake.getSecondDowm().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getSecondDowm());
        totalStakeCount++;
      } else {
        commonStake.setSecondDowm(BigDecimal.ZERO);
      }
      if (commonStake.getThirdUp() != null && commonStake.getThirdUp().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getThirdUp());
        totalStakeCount++;
      } else {
        commonStake.setThirdUp(BigDecimal.ZERO);
      }
      if (commonStake.getThirdDowm() != null && commonStake.getThirdDowm().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getThirdDowm());
        totalStakeCount++;
      } else {
        commonStake.setThirdDowm(BigDecimal.ZERO);
      }
      if (commonStake.getFourthUp() != null && commonStake.getFourthUp().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getFourthUp());
        totalStakeCount++;
      } else {
        commonStake.setFourthUp(BigDecimal.ZERO);
      }
      if (commonStake.getFourthDowm() != null && commonStake.getFourthDowm().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getFourthDowm());
        totalStakeCount++;
      } else {
        commonStake.setFourthDowm(BigDecimal.ZERO);
      }
      if (commonStake.getFifthUp() != null && commonStake.getFifthUp().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getFifthUp());
        totalStakeCount++;
      } else {
        commonStake.setFifthUp(BigDecimal.ZERO);
      }
      if (commonStake.getFifthDowm() != null && commonStake.getFifthDowm().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(commonStake.getFifthDowm());
        totalStakeCount++;
      } else {
        commonStake.setFifthDowm(BigDecimal.ZERO);
      }
    }

    List<AppointStakeVo> appointStakeList = stakeVo.getAppointStakeList();



    return null;
  }

}
