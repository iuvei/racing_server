package com.racing.model.stake.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeCountInfoVo;
import com.racing.model.stake.StakeVo;

public class StakeVoUtil {

	/**
	 * 获取该押注对象的总押注金额和总押注数
	 * @param stakeVo
	 * @return
	 */
  public static StakeCountInfoVo getStakeCountInfo(StakeVo stakeVo) {
    StakeCountInfoVo result = new StakeCountInfoVo();
    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int totalStakeCount = 0;

    CommonStake commonStake = stakeVo.getCommonStake();
    if (commonStake == null) {
      commonStake = new CommonStake();
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

    List<AppointStake> appointStakeList = stakeVo.getAppointStakeList();

    if (CollectionUtils.isEmpty(appointStakeList)) {
      appointStakeList = new ArrayList<AppointStake>();
      for (int i = 0; i < 10; i++) {
    	  AppointStake vo = new AppointStake();
        vo.setCarNum(i + 1);
        appointStakeList.add(vo);
      }
    }
    for (AppointStake vo : appointStakeList) {
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

    List<RankingStake> rankingStakeVoList = stakeVo.getRankingStakeList();
    if (CollectionUtils.isEmpty(rankingStakeVoList)) {
      rankingStakeVoList = new ArrayList<RankingStake>();
      for (int i = 0; i < 10; i++) {
    	  RankingStake vo = new RankingStake();
        vo.setRankingNum(i + 1);
        rankingStakeVoList.add(vo);
      }
    }

    for (RankingStake vo : rankingStakeVoList) {

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
  
  /**
   * 将新的押注累加到老的押注中
   * @param oldStake
   * @param newStake
   * @return
   */
  public static StakeVo stakeAdd(StakeVo oldStake, StakeVo newStake){
	  CommonStake oldCommonStake = oldStake.getCommonStake();
	  CommonStake newCommonStake = newStake.getCommonStake();
	  oldCommonStake.setFirstUp(oldCommonStake.getFirstUp().add(newCommonStake.getFirstUp()));
	  oldCommonStake.setFirstDowm(oldCommonStake.getFirstDowm().add(newCommonStake.getFirstDowm()));
	  oldCommonStake.setSecondUp(oldCommonStake.getSecondUp().add(newCommonStake.getSecondUp()));
	  oldCommonStake.setSecondDowm(oldCommonStake.getSecondDowm().add(newCommonStake.getSecondDowm()));
	  oldCommonStake.setThirdUp(oldCommonStake.getThirdUp().add(newCommonStake.getThirdUp()));
	  oldCommonStake.setThirdDowm(oldCommonStake.getThirdDowm().add(newCommonStake.getThirdDowm()));
	  oldCommonStake.setFourthUp(oldCommonStake.getFourthUp().add(newCommonStake.getFourthUp()));
	  oldCommonStake.setFourthDowm(oldCommonStake.getFourthDowm().add(newCommonStake.getFourthDowm()));
	  oldCommonStake.setFifthUp(oldCommonStake.getFifthUp().add(newCommonStake.getFifthUp()));
	  oldCommonStake.setFifthDowm(oldCommonStake.getFifthDowm().add(newCommonStake.getFifthDowm()));
	  
	  oldCommonStake.setFirstSecondBig(oldCommonStake.getFirstSecondBig().add(newCommonStake.getFirstSecondBig()));
	  oldCommonStake.setFirstSecondSmall(oldCommonStake.getFirstSecondSmall().add(newCommonStake.getFirstSecondSmall()));
	  oldCommonStake.setFirstSecondOdd(oldCommonStake.getFirstSecondOdd().add(newCommonStake.getFirstSecondOdd()));
	  oldCommonStake.setFirstSecondEven(oldCommonStake.getFirstSecondEven().add(newCommonStake.getFirstSecondEven()));

	  oldCommonStake.setFirstSecond3(oldCommonStake.getFirstSecond3().add(newCommonStake.getFirstSecond3()));
	  oldCommonStake.setFirstSecond4(oldCommonStake.getFirstSecond4().add(newCommonStake.getFirstSecond4()));
	  oldCommonStake.setFirstSecond5(oldCommonStake.getFirstSecond5().add(newCommonStake.getFirstSecond5()));
	  oldCommonStake.setFirstSecond6(oldCommonStake.getFirstSecond6().add(newCommonStake.getFirstSecond6()));
	  oldCommonStake.setFirstSecond7(oldCommonStake.getFirstSecond7().add(newCommonStake.getFirstSecond7()));
	  oldCommonStake.setFirstSecond8(oldCommonStake.getFirstSecond8().add(newCommonStake.getFirstSecond8()));
	  oldCommonStake.setFirstSecond9(oldCommonStake.getFirstSecond9().add(newCommonStake.getFirstSecond9()));
	  oldCommonStake.setFirstSecond10(oldCommonStake.getFirstSecond10().add(newCommonStake.getFirstSecond10()));
	  oldCommonStake.setFirstSecond11(oldCommonStake.getFirstSecond11().add(newCommonStake.getFirstSecond11()));
	  oldCommonStake.setFirstSecond12(oldCommonStake.getFirstSecond12().add(newCommonStake.getFirstSecond12()));
	  oldCommonStake.setFirstSecond13(oldCommonStake.getFirstSecond13().add(newCommonStake.getFirstSecond13()));
	  oldCommonStake.setFirstSecond14(oldCommonStake.getFirstSecond14().add(newCommonStake.getFirstSecond14()));
	  oldCommonStake.setFirstSecond15(oldCommonStake.getFirstSecond15().add(newCommonStake.getFirstSecond15()));
	  oldCommonStake.setFirstSecond16(oldCommonStake.getFirstSecond16().add(newCommonStake.getFirstSecond16()));
	  oldCommonStake.setFirstSecond17(oldCommonStake.getFirstSecond17().add(newCommonStake.getFirstSecond17()));
	  oldCommonStake.setFirstSecond18(oldCommonStake.getFirstSecond18().add(newCommonStake.getFirstSecond18()));
	  oldCommonStake.setFirstSecond19(oldCommonStake.getFirstSecond19().add(newCommonStake.getFirstSecond19()));
	  
	  List<AppointStake> oldAppointStakeList = oldStake.getAppointStakeList();
	  List<AppointStake> newAppointStakeList = newStake.getAppointStakeList();
	  for(int i = 0 ; i < 10 ; i++){
		  AppointStake oldAppointStakeVo = oldAppointStakeList.get(i);
		  AppointStake newAppointStakeVo = newAppointStakeList.get(i);
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
		  oldAppointStakeVo.setFirst(oldAppointStakeVo.getFirst().add(newAppointStakeVo.getFirst()));
	  }
	  
	  List<RankingStake> oldRankingStakeList = oldStake.getRankingStakeList();
	  List<RankingStake> newRankingStakeList = newStake.getRankingStakeList();
	  for(int i = 0 ; i < 10 ; i++){
		  RankingStake oldRankingStake = oldRankingStakeList.get(i);
		  RankingStake newRankingStake = newRankingStakeList.get(i);
		  oldRankingStake.setBig(oldRankingStake.getBig().add(newRankingStake.getBig()));
		  oldRankingStake.setSmall(oldRankingStake.getSmall().add(newRankingStake.getSmall()));
		  oldRankingStake.setOdd(oldRankingStake.getOdd().add(newRankingStake.getOdd()));
		  oldRankingStake.setEven(oldRankingStake.getEven().add(newRankingStake.getEven()));
	  }
	  
	  return oldStake;
  }

  /**
   * 根据期号创建一个新的押注对象
   * @param racingNum
   * @return
   */
  public static StakeVo createNewStake(String racingNum){
	  StakeVo stake = new StakeVo();
	  CommonStake commonStake = new CommonStake();
	  List<AppointStake> appointStakeList = new ArrayList<AppointStake>();
	  for(int i = 0 ; i < 10 ; i ++){
		  AppointStake appointStake = new AppointStake();
		  appointStake.setCarNum(i+1);
		  appointStakeList.add(appointStake);
	  }
	  List<RankingStake> rankingStakeList = new ArrayList<RankingStake>();
	  for(int i = 0 ; i < 10 ; i ++){
		  RankingStake rankingStake = new RankingStake();
		  rankingStake.setRankingNum(i + 1);
		  rankingStakeList.add(rankingStake);
	  }
	  
	  stake.setAppointStakeList(appointStakeList);
	  stake.setCommonStake(commonStake);
	  stake.setRankingStakeList(rankingStakeList);
	  stake.setRacingNum(racingNum);
	  return stake;
  }
  
}
