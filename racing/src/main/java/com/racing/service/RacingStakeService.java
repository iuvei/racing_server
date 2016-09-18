package com.racing.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.racing.controller.vo.ApiResutl;
import com.racing.controller.vo.AppointStakeVo;
import com.racing.controller.vo.CommonStakeVo;
import com.racing.controller.vo.DayCountStakeVo;
import com.racing.controller.vo.RankingStakeVo;
import com.racing.controller.vo.StakeConfigVo;
import com.racing.controller.vo.StakeOperationVo;
import com.racing.controller.vo.StakeVo;
import com.racing.model.po.AppointStake;
import com.racing.model.po.CommonStake;
import com.racing.model.po.DayCountStake;
import com.racing.model.po.RankingStake;
import com.racing.model.po.RecordResult;
import com.racing.model.po.util.RecordResultPOUtil;
import com.racing.model.repo.AppointStakeRepo;
import com.racing.model.repo.CommonStakeRepo;
import com.racing.model.repo.DayCountStakeRepo;
import com.racing.model.repo.RankingStakeRepo;
import com.racing.model.repo.RecordResultRepo;
import com.racing.service.calc.CalculationService;
import com.racing.util.DateUtil;

@Service
public class RacingStakeService {

  @Autowired
  private AppointStakeRepo appointStakeRepo;

  @Autowired
  private CommonStakeRepo commonStakeRepo;

  @Autowired
  private RankingStakeRepo rankingStakeRepo;

  @Autowired
  private RecordResultRepo recordResultRepo;

  @Autowired
  private DayCountStakeRepo dayCountStakeRepo;

  @Autowired
  private CalculationService calculationService;

  @Transactional(rollbackFor = Exception.class)
  public ApiResutl addNewStake(StakeVo req) {
    Date nowDate = new Date();
    RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
    if (recordResult == null) {
      return ApiResutl.createErrorReuslt("未找到当前的比赛信息");
    }
    String racingNum = recordResult.getRacingNum();
    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
    if (betweenTime <= 55) {// 原本是60秒，此处多加5秒用作缓冲
      return ApiResutl.createErrorReuslt("当前" + racingNum + "的比赛已过押注时间");
    }

    List<AppointStakeVo> appointStakeList = req.getAppointStakeList();
    if (appointStakeList.size() != 10) {
      return ApiResutl.createErrorReuslt("车号指定录入数据不正确，请正确输入每一个车号(共十个)押注对应名次的金额");
    }
    List<RankingStakeVo> rankingStakeList = req.getRankingStakeList();
    if (rankingStakeList.size() != 10) {
      return ApiResutl.createErrorReuslt("名次指定录入数据不正确，请正确输入每一个名次的对应情况押注金额");
    }

    CommonStakeVo commonStake = req.getCommonStake();
    if (commonStake == null) {
      return ApiResutl.createErrorReuslt("普通押注的不正确，请正确输入每一种押注的金额");
    }

    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    int addTotalStakeCount = 0;

    if (commonStake.getFirstUp() != null && commonStake.getFirstUp().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstUp());
      addTotalStakeCount++;
    }

    if (commonStake.getFirstDowm() != null && commonStake.getFirstDowm().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstDowm());
      addTotalStakeCount++;
    }

    if (commonStake.getSecondUp() != null && commonStake.getSecondUp().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getSecondUp());
      addTotalStakeCount++;
    }

    if (commonStake.getSecondDowm() != null && commonStake.getSecondDowm().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getSecondDowm());
      addTotalStakeCount++;
    }

    if (commonStake.getThirdUp() != null && commonStake.getThirdUp().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getThirdUp());
      addTotalStakeCount++;
    }

    if (commonStake.getThirdDowm() != null && commonStake.getThirdDowm().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getThirdDowm());
      addTotalStakeCount++;
    }

    if (commonStake.getFourthUp() != null && commonStake.getFourthUp().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFourthUp());
      addTotalStakeCount++;
    }

    if (commonStake.getFourthDowm() != null && commonStake.getFourthDowm().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFourthDowm());
      addTotalStakeCount++;
    }

    if (commonStake.getFifthUp() != null && commonStake.getFifthUp().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFifthUp());
      addTotalStakeCount++;
    }
    if (commonStake.getFifthDowm() != null && commonStake.getFifthDowm().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFifthDowm());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond3() != null && commonStake.getFirstSecond3().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond3());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond4() != null && commonStake.getFirstSecond4().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond4());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond5() != null && commonStake.getFirstSecond5().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond5());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond6() != null && commonStake.getFirstSecond6().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond6());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond7() != null && commonStake.getFirstSecond7().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond7());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond8() != null && commonStake.getFirstSecond8().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond8());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond9() != null && commonStake.getFirstSecond9().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond9());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond10() != null && commonStake.getFirstSecond10().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond10());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond11() != null && commonStake.getFirstSecond11().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond11());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond12() != null && commonStake.getFirstSecond12().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond12());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond13() != null && commonStake.getFirstSecond13().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond13());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond14() != null && commonStake.getFirstSecond14().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond14());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond15() != null && commonStake.getFirstSecond15().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond15());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond16() != null && commonStake.getFirstSecond16().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond16());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond17() != null && commonStake.getFirstSecond17().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond17());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond18() != null && commonStake.getFirstSecond18().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond18());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecond19() != null && commonStake.getFirstSecond19().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecond19());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecondBig() != null && commonStake.getFirstSecondBig().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecondBig());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecondEven() != null && commonStake.getFirstSecondEven().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecondEven());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecondOdd() != null && commonStake.getFirstSecondOdd().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecondOdd());
      addTotalStakeCount++;
    }
    if (commonStake.getFirstSecondSmall() != null && commonStake.getFirstSecondSmall().compareTo(BigDecimal.ZERO) > 0) {
      totalStakeAmount = totalStakeAmount.add(commonStake.getFirstSecondSmall());
      addTotalStakeCount++;
    }


    CommonStake oldCommonStake = commonStakeRepo.getCommonStakeByRacingNum(racingNum);
    if (oldCommonStake == null) {
      oldCommonStake = new CommonStake();
      oldCommonStake.setFirstDowm(commonStake.getFirstDowm());
      oldCommonStake.setFirstUp(commonStake.getFirstUp());
      oldCommonStake.setSecondDowm(commonStake.getSecondDowm());
      oldCommonStake.setSecondUp(commonStake.getSecondUp());
      oldCommonStake.setThirdDowm(commonStake.getThirdDowm());
      oldCommonStake.setThirdUp(commonStake.getThirdUp());
      oldCommonStake.setFourthDowm(commonStake.getFourthDowm());
      oldCommonStake.setFourthUp(commonStake.getFourthUp());
      oldCommonStake.setFifthDowm(commonStake.getFifthDowm());
      oldCommonStake.setFifthUp(commonStake.getFifthUp());
      oldCommonStake.setFirstSecond3(commonStake.getFirstSecond3());
      oldCommonStake.setFirstSecond4(commonStake.getFirstSecond4());
      oldCommonStake.setFirstSecond5(commonStake.getFirstSecond5());
      oldCommonStake.setFirstSecond6(commonStake.getFirstSecond6());
      oldCommonStake.setFirstSecond7(commonStake.getFirstSecond7());
      oldCommonStake.setFirstSecond8(commonStake.getFirstSecond8());
      oldCommonStake.setFirstSecond9(commonStake.getFirstSecond9());
      oldCommonStake.setFirstSecond10(commonStake.getFirstSecond10());
      oldCommonStake.setFirstSecond11(commonStake.getFirstSecond11());
      oldCommonStake.setFirstSecond12(commonStake.getFirstSecond12());
      oldCommonStake.setFirstSecond13(commonStake.getFirstSecond13());
      oldCommonStake.setFirstSecond14(commonStake.getFirstSecond14());
      oldCommonStake.setFirstSecond15(commonStake.getFirstSecond15());
      oldCommonStake.setFirstSecond16(commonStake.getFirstSecond16());
      oldCommonStake.setFirstSecond17(commonStake.getFirstSecond17());
      oldCommonStake.setFirstSecond18(commonStake.getFirstSecond18());
      oldCommonStake.setFirstSecond19(commonStake.getFirstSecond19());
      oldCommonStake.setFirstSecondBig(commonStake.getFirstSecondBig());
      oldCommonStake.setFirstSecondEven(commonStake.getFirstSecondEven());
      oldCommonStake.setFirstSecondOdd(commonStake.getFirstSecondOdd());
      oldCommonStake.setFirstSecondSmall(commonStake.getFirstSecondSmall());
      commonStakeRepo.addNewCommonStake(oldCommonStake, racingNum);
    } else {
      oldCommonStake.setFirstUp(oldCommonStake.getFirstUp().add(commonStake.getFirstUp() == null ? BigDecimal.ZERO : commonStake.getFirstUp()));
      oldCommonStake.setFirstDowm(oldCommonStake.getFirstDowm().add(commonStake.getFirstDowm() == null ? BigDecimal.ZERO : commonStake.getFirstDowm()));
      oldCommonStake.setSecondUp(oldCommonStake.getSecondUp().add(commonStake.getSecondUp() == null ? BigDecimal.ZERO : commonStake.getSecondUp()));
      oldCommonStake.setSecondDowm(oldCommonStake.getSecondDowm().add(commonStake.getSecondDowm() == null ? BigDecimal.ZERO : commonStake.getSecondDowm()));
      oldCommonStake.setThirdUp(oldCommonStake.getThirdUp().add(commonStake.getThirdUp() == null ? BigDecimal.ZERO : commonStake.getThirdUp()));
      oldCommonStake.setThirdDowm(oldCommonStake.getThirdDowm().add(commonStake.getThirdDowm() == null ? BigDecimal.ZERO : commonStake.getThirdDowm()));
      oldCommonStake.setFourthUp(oldCommonStake.getFourthUp().add(commonStake.getFourthUp() == null ? BigDecimal.ZERO : commonStake.getFourthUp()));
      oldCommonStake.setFourthDowm(oldCommonStake.getFourthDowm().add(commonStake.getFourthDowm() == null ? BigDecimal.ZERO : commonStake.getFourthDowm()));
      oldCommonStake.setFifthUp(oldCommonStake.getFifthUp().add(commonStake.getFifthUp() == null ? BigDecimal.ZERO : commonStake.getFifthUp()));
      oldCommonStake.setFifthDowm(oldCommonStake.getFifthDowm().add(commonStake.getFifthDowm() == null ? BigDecimal.ZERO : commonStake.getFifthDowm()));
      oldCommonStake.setFirstSecond3(oldCommonStake.getFirstSecond3().add(commonStake.getFirstSecond3() == null ? BigDecimal.ZERO : commonStake.getFirstSecond3()));
      oldCommonStake.setFirstSecond4(oldCommonStake.getFirstSecond4().add(commonStake.getFirstSecond4() == null ? BigDecimal.ZERO : commonStake.getFirstSecond4()));
      oldCommonStake.setFirstSecond5(oldCommonStake.getFirstSecond5().add(commonStake.getFirstSecond5() == null ? BigDecimal.ZERO : commonStake.getFirstSecond5()));
      oldCommonStake.setFirstSecond6(oldCommonStake.getFirstSecond6().add(commonStake.getFirstSecond6() == null ? BigDecimal.ZERO : commonStake.getFirstSecond6()));
      oldCommonStake.setFirstSecond7(oldCommonStake.getFirstSecond7().add(commonStake.getFirstSecond7() == null ? BigDecimal.ZERO : commonStake.getFirstSecond7()));
      oldCommonStake.setFirstSecond8(oldCommonStake.getFirstSecond8().add(commonStake.getFirstSecond8() == null ? BigDecimal.ZERO : commonStake.getFirstSecond8()));
      oldCommonStake.setFirstSecond9(oldCommonStake.getFirstSecond9().add(commonStake.getFirstSecond9() == null ? BigDecimal.ZERO : commonStake.getFirstSecond9()));
      oldCommonStake.setFirstSecond10(oldCommonStake.getFirstSecond10().add(commonStake.getFirstSecond10() == null ? BigDecimal.ZERO : commonStake.getFirstSecond10()));
      oldCommonStake.setFirstSecond11(oldCommonStake.getFirstSecond11().add(commonStake.getFirstSecond11() == null ? BigDecimal.ZERO : commonStake.getFirstSecond11()));
      oldCommonStake.setFirstSecond12(oldCommonStake.getFirstSecond12().add(commonStake.getFirstSecond12() == null ? BigDecimal.ZERO : commonStake.getFirstSecond12()));
      oldCommonStake.setFirstSecond13(oldCommonStake.getFirstSecond13().add(commonStake.getFirstSecond13() == null ? BigDecimal.ZERO : commonStake.getFirstSecond13()));
      oldCommonStake.setFirstSecond14(oldCommonStake.getFirstSecond14().add(commonStake.getFirstSecond14() == null ? BigDecimal.ZERO : commonStake.getFirstSecond14()));
      oldCommonStake.setFirstSecond15(oldCommonStake.getFirstSecond15().add(commonStake.getFirstSecond15() == null ? BigDecimal.ZERO : commonStake.getFirstSecond15()));
      oldCommonStake.setFirstSecond16(oldCommonStake.getFirstSecond16().add(commonStake.getFirstSecond16() == null ? BigDecimal.ZERO : commonStake.getFirstSecond16()));
      oldCommonStake.setFirstSecond17(oldCommonStake.getFirstSecond17().add(commonStake.getFirstSecond17() == null ? BigDecimal.ZERO : commonStake.getFirstSecond17()));
      oldCommonStake.setFirstSecond18(oldCommonStake.getFirstSecond18().add(commonStake.getFirstSecond18() == null ? BigDecimal.ZERO : commonStake.getFirstSecond18()));
      oldCommonStake.setFirstSecond19(oldCommonStake.getFirstSecond19().add(commonStake.getFirstSecond19() == null ? BigDecimal.ZERO : commonStake.getFirstSecond19()));
      oldCommonStake.setFirstSecondBig(oldCommonStake.getFirstSecondBig().add(commonStake.getFirstSecondBig() == null ? BigDecimal.ZERO : commonStake.getFirstSecondBig()));
      oldCommonStake.setFirstSecondEven(oldCommonStake.getFirstSecondEven().add(commonStake.getFirstSecondEven() == null ? BigDecimal.ZERO : commonStake.getFirstSecondEven()));
      oldCommonStake.setFirstSecondOdd(oldCommonStake.getFirstSecondOdd().add(commonStake.getFirstSecondOdd() == null ? BigDecimal.ZERO : commonStake.getFirstSecondOdd()));
      oldCommonStake.setFirstSecondSmall(oldCommonStake.getFirstSecondSmall().add(commonStake.getFirstSecondSmall() == null ? BigDecimal.ZERO : commonStake.getFirstSecondSmall()));
      commonStakeRepo.updateCommonStakeById(oldCommonStake);
    }

    Map<Integer, AppointStake> appointStakeMap = appointStakeRepo.getAppointStakeListByRacingNum(racingNum);
    for (AppointStakeVo appointStakeVo : appointStakeList) {

      if (appointStakeVo.getFirst() != null && appointStakeVo.getFirst().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getFirst());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getSecond() != null && appointStakeVo.getSecond().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getSecond());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getThird() != null && appointStakeVo.getThird().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getThird());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getFourth() != null && appointStakeVo.getFourth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getFourth());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getFifth() != null && appointStakeVo.getFifth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getFifth());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getSixth() != null && appointStakeVo.getSixth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getSixth());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getSeventh() != null && appointStakeVo.getSeventh().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getSeventh());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getEighth() != null && appointStakeVo.getEighth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getEighth());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getNinth() != null && appointStakeVo.getNinth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getNinth());
        addTotalStakeCount++;
      }
      if (appointStakeVo.getTenth() != null && appointStakeVo.getTenth().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(appointStakeVo.getTenth());
        addTotalStakeCount++;
      }

      AppointStake old = appointStakeMap.get(appointStakeVo.getCarNum());
      if (old == null) {
        old = new AppointStake();
        old.setCarNum(appointStakeVo.getCarNum());
        old.setFirst(appointStakeVo.getFirst());
        old.setSecond(appointStakeVo.getSecond());
        old.setThird(appointStakeVo.getThird());
        old.setFourth(appointStakeVo.getFourth());
        old.setFifth(appointStakeVo.getFifth());
        old.setSixth(appointStakeVo.getSixth());
        old.setSeventh(appointStakeVo.getSeventh());
        old.setEighth(appointStakeVo.getEighth());
        old.setNinth(appointStakeVo.getNinth());
        old.setTenth(appointStakeVo.getTenth());
        old.setRacingNum(racingNum);
        appointStakeRepo.addAppointStake(old);
      } else {
        old.setFirst(old.getFirst().add(appointStakeVo.getFirst() == null ? BigDecimal.ZERO : appointStakeVo.getFirst()));
        old.setSecond(old.getSecond().add(appointStakeVo.getSecond() == null ? BigDecimal.ZERO : appointStakeVo.getSecond()));
        old.setThird(old.getThird().add(appointStakeVo.getThird() == null ? BigDecimal.ZERO : appointStakeVo.getThird()));
        old.setFourth(old.getFourth().add(appointStakeVo.getFourth() == null ? BigDecimal.ZERO : appointStakeVo.getFourth()));
        old.setFifth(old.getFifth().add(appointStakeVo.getFifth() == null ? BigDecimal.ZERO : appointStakeVo.getFifth()));
        old.setSixth(old.getSixth().add(appointStakeVo.getSixth() == null ? BigDecimal.ZERO : appointStakeVo.getSixth()));
        old.setSeventh(old.getSeventh().add(appointStakeVo.getSeventh() == null ? BigDecimal.ZERO : appointStakeVo.getSeventh()));
        old.setEighth(old.getEighth().add(appointStakeVo.getEighth() == null ? BigDecimal.ZERO : appointStakeVo.getEighth()));
        old.setNinth(old.getNinth().add(appointStakeVo.getNinth() == null ? BigDecimal.ZERO : appointStakeVo.getNinth()));
        old.setTenth(old.getTenth().add(appointStakeVo.getTenth() == null ? BigDecimal.ZERO : appointStakeVo.getTenth()));
        appointStakeRepo.updateAppointStakeById(old);
      }
    }
    Map<Integer, RankingStake> oldRankingStakeMap = rankingStakeRepo.getRankingStakeListByRacingNum(racingNum);
    for (RankingStakeVo rankingStakeVo : rankingStakeList) {

      if (rankingStakeVo.getBig() != null && rankingStakeVo.getBig().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(rankingStakeVo.getBig());
        addTotalStakeCount++;
      }
      if (rankingStakeVo.getEven() != null && rankingStakeVo.getEven().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(rankingStakeVo.getEven());
        addTotalStakeCount++;
      }
      if (rankingStakeVo.getOdd() != null && rankingStakeVo.getOdd().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(rankingStakeVo.getOdd());
        addTotalStakeCount++;
      }
      if (rankingStakeVo.getSmall() != null && rankingStakeVo.getSmall().compareTo(BigDecimal.ZERO) > 0) {
        totalStakeAmount = totalStakeAmount.add(rankingStakeVo.getSmall());
        addTotalStakeCount++;
      }

      RankingStake old = oldRankingStakeMap.get(rankingStakeVo.getRankingNum());
      if (old == null) {
        old = new RankingStake();
        old.setBig(rankingStakeVo.getBig());
        old.setEven(rankingStakeVo.getEven());
        old.setOdd(rankingStakeVo.getOdd());
        old.setSmall(rankingStakeVo.getSmall());
        old.setRankingNum(rankingStakeVo.getRankingNum());
        old.setRacingNum(racingNum);
        rankingStakeRepo.addRankingStake(old);
      } else {
        old.setBig(old.getBig().add(rankingStakeVo.getBig() == null ? BigDecimal.ZERO : rankingStakeVo.getBig()));
        old.setEven(old.getEven().add(rankingStakeVo.getEven() == null ? BigDecimal.ZERO : rankingStakeVo.getEven()));
        old.setOdd(old.getOdd().add(rankingStakeVo.getOdd() == null ? BigDecimal.ZERO : rankingStakeVo.getOdd()));
        old.setSmall(old.getSmall().add(rankingStakeVo.getSmall() == null ? BigDecimal.ZERO : rankingStakeVo.getSmall()));
        rankingStakeRepo.updateRankingStakeById(old);
      }
    }

    recordResultRepo.upaddTotalStakeAmount(racingNum, totalStakeAmount, addTotalStakeCount);

    return ApiResutl.createSuccessReuslt();
  }

  public StakeOperationVo getNowRacingNum() {
    StakeOperationVo result = new StakeOperationVo();
    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
    RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
    result.setServerTime(nowDate);
    if (recordResult == null) {
      return null;
    }
    result.setRacingNum(recordResult.getRacingNum());
    result.setStartTime(recordResult.getStartTime());
    result.setResult(RecordResultPOUtil.convertResult(recordResult));

    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);

    result.setEndStakeTime(DateUtil.addSecond(recordResult.getStartTime(), -60));// 比赛前的60（55）秒为停止押注时间
    result.setStartModifyTime(DateUtil.addSecond(recordResult.getStartTime(), -40));// 比赛前60~40秒为计算时间
    result.setEndModifyTime(DateUtil.addSecond(recordResult.getStartTime(), -20));// 比赛前20秒到40秒为可进行修改比赛结果时间

    result.setIsCanStake(betweenTime > 60);// 六十秒以后不可押注
    result.setIsCanModifyResult(betweenTime > 20 && betweenTime < 40);// 20~40秒为修改时间

    return result;
  }

  public StakeConfigVo getStakeConfig() {
    StakeConfigVo result = new StakeConfigVo();
    Date nowDate = DateUtil.setDateMillisecondZero(new Date());
    RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
    if (recordResult == null) {
      return null;
    }
    result.setRacingNum(recordResult.getRacingNum());
    result.setResult(RecordResultPOUtil.convertResult(recordResult));

    result.setStartRacingTime(recordResult.getStartTime().getTime() - nowDate.getTime());
    result.setEndStakeTime(result.getStartRacingTime() - 60 * 1000);

    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);

    if (betweenTime > 60) {
      result.setStage(1);// 下注阶段
    } else if (betweenTime >= 40 && betweenTime <= 60) {
      result.setStage(2);// 计算阶段
    } else if (betweenTime > 20 && betweenTime < 40) {
      result.setStage(3);// 修改比赛结果阶段
    } else {
      result.setStage(4);// 停止操作阶段
    }

    RecordResult preRecordResult = recordResultRepo.getNowBeforLastRecordResult(nowDate);
    if (preRecordResult != null) {
      result.setPreRacingNum(preRecordResult.getRacingNum());
      result.setPreResult(RecordResultPOUtil.convertResult(preRecordResult));
    }

    DayCountStake countStake = dayCountStakeRepo.getDayCountStake(nowDate);
    result.setTodayIncome(countStake.getTotalStakeAmount().subtract(countStake.getTotalDeficitAmount()).setScale(2, BigDecimal.ROUND_CEILING));// 今日盈亏，临时死值，需要统计获取

    return result;
  }

  public ApiResutl updateRacingResult(Integer[] racingResult, String racingNum) {
    Date nowDate = new Date();
    RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
    if (recordResult == null) {
      return ApiResutl.createErrorReuslt("未找到" + racingNum + "的比赛信息");
    }
    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
    if (!(betweenTime >= 15 && betweenTime <= 40)) {// 原本是20~40秒可修改，以防万一，缓冲5秒
      return ApiResutl.createErrorReuslt("当前" + racingNum + "的比赛暂不支持修改比赛结果");
    }

    if (racingResult.length != 10) {
      return ApiResutl.createErrorReuslt("车号必须为十个，请确认调整的车号");
    }

    Map<Integer, Boolean> resultMap = new HashMap<Integer, Boolean>();
    for (Integer carNum : racingResult) {
      if (resultMap.get(carNum) == null || resultMap.get(carNum) == false) {
        resultMap.put(carNum, true);
      } else {
        return ApiResutl.createErrorReuslt("车号有重复的，请确认调整的车号");
      }
    }

    recordResult.setFirst(racingResult[0]);
    recordResult.setSecond(racingResult[1]);
    recordResult.setThird(racingResult[2]);
    recordResult.setFourth(racingResult[3]);
    recordResult.setFifth(racingResult[4]);
    recordResult.setSixth(racingResult[5]);
    recordResult.setSeventh(racingResult[6]);
    recordResult.setEighth(racingResult[7]);
    recordResult.setNinth(racingResult[8]);
    recordResult.setTenth(racingResult[9]);

    recordResult.setFirstAddSecond(racingResult[0] + racingResult[1]);
    recordResult.setIsFirstSecondBig((racingResult[0] + racingResult[1]) > 11);
    recordResult.setIsFirstSecondOdd((racingResult[0] + racingResult[1]) % 2 == 0);
    recordResult.setIsFirstUp(racingResult[0] > racingResult[9]);
    recordResult.setIsSecondUp(racingResult[1] > racingResult[8]);
    recordResult.setIsThirdUp(racingResult[2] > racingResult[7]);
    recordResult.setIsFourthUp(racingResult[3] > racingResult[6]);
    recordResult.setIsFifthUp(racingResult[4] > racingResult[5]);

    CommonStake commonStake = commonStakeRepo.getCommonStakeByRacingNum(recordResult.getRacingNum());
    List<AppointStake> appointStakeList = appointStakeRepo.getAppointStakeList(recordResult.getRacingNum());
    List<RankingStake> rankingStakeList = rankingStakeRepo.getRankingStakeList(recordResult.getRacingNum());

    recordResult.setTotalDeficitAmount(calculationService.dealCalculation(racingResult, appointStakeList, commonStake, rankingStakeList));

    recordResultRepo.updateRecordResultByRacingNum(recordResult, racingNum);
    return ApiResutl.createSuccessReuslt("结果修改成功！");
  }

  public ApiResutl getDayCountStake() throws ParseException {
    List<DayCountStakeVo> result = new ArrayList<DayCountStakeVo>();
    Date nowDate = new Date();
    Date startDay = DateUtil.getPreviousWeekFirstDate(nowDate);
    Date endDay = DateUtil.getWeekLastDate(nowDate);
    List<DayCountStake> countStakeList = dayCountStakeRepo.getDayCountStake(startDay, endDay);
    if (CollectionUtils.isEmpty(countStakeList)) {
      for (int i = 0; i < 14; i++) {
        DayCountStakeVo vo = new DayCountStakeVo();
        vo.setDay(DateUtil.parseToString(startDay, DateUtil.DateFormat_yyyy_MM_dd) + DateUtil.getWeekOfDate(startDay));
        vo.setTotalDeficitAmount(BigDecimal.ZERO);
        vo.setTotalStakeAmount(BigDecimal.ZERO);
        vo.setTotalCommissionAmount(BigDecimal.ZERO);
        vo.setTotalIncomeAmount(vo.getTotalStakeAmount().subtract(vo.getTotalDeficitAmount()));
        vo.setTotalStakeCount(0);
        result.add(vo);
        if (i == 6 || i == 13) {
          DayCountStakeVo countWeekVo = new DayCountStakeVo();
          if (i == 6) {
            countWeekVo.setDay("上周");
          } else {
            countWeekVo.setDay("本周");
          }
          countWeekVo.setTotalDeficitAmount(BigDecimal.ZERO);
          countWeekVo.setTotalStakeAmount(BigDecimal.ZERO);
          countWeekVo.setTotalCommissionAmount(BigDecimal.ZERO);
          countWeekVo.setTotalIncomeAmount(BigDecimal.ZERO);
          countWeekVo.setTotalStakeCount(0);
          result.add(countWeekVo);
        }
        startDay = DateUtil.addDay(startDay, 1);
      }
    } else {
      BigDecimal weekTotalDeficitAmount = BigDecimal.ZERO;
      BigDecimal weekTotalStakeAmoun = BigDecimal.ZERO;
      Integer weekTotalStakeCount = 0;
      for (int i = 0, j = 0; i < 14;) {
        if (j >= countStakeList.size() || DateUtil.daysBetweenTwoDate(DateUtil.parseToDate(countStakeList.get(j).getDay(), DateUtil.DateFormat_yyyy_MM_dd), startDay) != 0) {
          DayCountStakeVo vo = new DayCountStakeVo();
          vo.setDay(DateUtil.parseToString(startDay, DateUtil.DateFormat_yyyy_MM_dd) + " " + DateUtil.getWeekOfDate(startDay));
          vo.setTotalDeficitAmount(BigDecimal.ZERO);
          vo.setTotalStakeAmount(BigDecimal.ZERO);
          vo.setTotalCommissionAmount(BigDecimal.ZERO);
          vo.setTotalIncomeAmount(BigDecimal.ZERO);
          vo.setTotalStakeCount(0);
          result.add(vo);
        } else {
          DayCountStake countStake = countStakeList.get(j);
          DayCountStakeVo vo = new DayCountStakeVo();
          vo.setDay(DateUtil.parseToString(startDay, DateUtil.DateFormat_yyyy_MM_dd) + " " + DateUtil.getWeekOfDate(startDay));

          vo.setTotalDeficitAmount(countStake.getTotalDeficitAmount());
          weekTotalDeficitAmount = weekTotalDeficitAmount.add(countStake.getTotalDeficitAmount());

          vo.setTotalStakeAmount(countStake.getTotalStakeAmount());
          weekTotalStakeAmoun = weekTotalStakeAmoun.add(countStake.getTotalStakeAmount());

          vo.setTotalStakeCount(countStake.getTotalStakeCount());
          weekTotalStakeCount = weekTotalStakeCount + countStake.getTotalStakeCount();

          vo.setTotalCommissionAmount(BigDecimal.ZERO);
          vo.setTotalIncomeAmount(vo.getTotalStakeAmount().subtract(vo.getTotalDeficitAmount()));
          result.add(vo);
          j++;
        }
        if (i == 6 || i == 13) {
          DayCountStakeVo countWeekVo = new DayCountStakeVo();
          if (i == 6) {
            countWeekVo.setDay("上周");
          } else {
            countWeekVo.setDay("本周");
          }
          countWeekVo.setTotalDeficitAmount(weekTotalDeficitAmount);
          countWeekVo.setTotalStakeAmount(weekTotalStakeAmoun);
          countWeekVo.setTotalCommissionAmount(BigDecimal.ZERO);
          countWeekVo.setTotalStakeCount(weekTotalStakeCount);
          countWeekVo.setTotalIncomeAmount(countWeekVo.getTotalStakeAmount().subtract(countWeekVo.getTotalDeficitAmount()));
          result.add(countWeekVo);

          weekTotalDeficitAmount = BigDecimal.ZERO;
          weekTotalStakeAmoun = BigDecimal.ZERO;
          weekTotalStakeCount = 0;
        }
        startDay = DateUtil.addDay(startDay, 1);
        i++;
      }
    }
    return ApiResutl.createSuccessReuslt(result);
  }

}
