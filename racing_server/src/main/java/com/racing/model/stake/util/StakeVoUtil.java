package com.racing.model.stake.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.racing.controller.vo.AppointStakeVo;
import com.racing.controller.vo.CommonStakeVo;
import com.racing.controller.vo.RankingStakeVo;
import com.racing.controller.vo.StakeVo;
import com.racing.model.stake.StakeCountInfoVo;

public class StakeVoUtil {

  public static StakeCountInfoVo getStakeCountInfo(StakeVo stakeVo) {
    StakeCountInfoVo result = new StakeCountInfoVo();
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

    if (CollectionUtils.isEmpty(appointStakeList)) {
      appointStakeList = new ArrayList<AppointStakeVo>();
      for (int i = 0; i < 10; i++) {
        AppointStakeVo vo = new AppointStakeVo();
        vo.setCarNum(i + 1);
        appointStakeList.add(vo);
      }
    }
    for (AppointStakeVo vo : appointStakeList) {
      if (vo.getFirst() != null && vo.getFirst().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getFirst());
        totalStakeCount++;
      } else {
        vo.setFirst(BigDecimal.ZERO);
      }
      if (vo.getSecond() != null && vo.getSecond().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getSecond());
        totalStakeCount++;
      } else {
        vo.setSecond(BigDecimal.ZERO);
      }
      if (vo.getThird() != null && vo.getThird().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getThird());
        totalStakeCount++;
      } else {
        vo.setThird(BigDecimal.ZERO);
      }
      if (vo.getFourth() != null && vo.getFourth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getFourth());
        totalStakeCount++;
      } else {
        vo.setFourth(BigDecimal.ZERO);
      }
      if (vo.getFifth() != null && vo.getFifth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getFifth());
        totalStakeCount++;
      } else {
        vo.setFifth(BigDecimal.ZERO);
      }
      if (vo.getSixth() != null && vo.getSixth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getSixth());
        totalStakeCount++;
      } else {
        vo.setSixth(BigDecimal.ZERO);
      }
      if (vo.getSeventh() != null && vo.getSeventh().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getSeventh());
        totalStakeCount++;
      } else {
        vo.setSeventh(BigDecimal.ZERO);
      }
      if (vo.getEighth() != null && vo.getEighth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getEighth());
        totalStakeCount++;
      } else {
        vo.setEighth(BigDecimal.ZERO);
      }
      if (vo.getNinth() != null && vo.getNinth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getNinth());
        totalStakeCount++;
      } else {
        vo.setNinth(BigDecimal.ZERO);
      }
      if (vo.getTenth() != null && vo.getTenth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getTenth());
        totalStakeCount++;
      } else {
        vo.setTenth(BigDecimal.ZERO);
      }
    }

    List<RankingStakeVo> rankingStakeVoList = stakeVo.getRankingStakeList();
    if (CollectionUtils.isEmpty(rankingStakeVoList)) {
      rankingStakeVoList = new ArrayList<RankingStakeVo>();
      for (int i = 0; i < 10; i++) {
        RankingStakeVo vo = new RankingStakeVo();
        vo.setRankingNum(i + 1);
        rankingStakeVoList.add(vo);
      }
    }

    for (RankingStakeVo vo : rankingStakeVoList) {

      if (vo.getBig() != null && vo.getBig().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getBig());
        totalStakeCount++;
      } else {
        vo.setBig(BigDecimal.ZERO);
      }
      if (vo.getSmall() != null && vo.getSmall().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getSmall());
        totalStakeCount++;
      } else {
        vo.setSmall(BigDecimal.ZERO);
      }

      if (vo.getEven() != null && vo.getEven().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getEven());
        totalStakeCount++;
      } else {
        vo.setEven(BigDecimal.ZERO);
      }
      if (vo.getOdd() != null && vo.getOdd().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(vo.getOdd());
        totalStakeCount++;
      } else {
        vo.setOdd(BigDecimal.ZERO);
      }

    }

    result.setTotalStakeAmount(totalStakeAmount);
    result.setTotalStakeCount(totalStakeCount);
    return result;
  }

}
