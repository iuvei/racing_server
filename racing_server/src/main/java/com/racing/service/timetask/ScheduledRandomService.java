package com.racing.service.timetask;

import com.racing.model.po.*;
import com.racing.model.repo.*;
import com.racing.service.calc.CalculationService;
import com.racing.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class ScheduledRandomService {

  @Autowired
  private RecordResultRepo repo;

  @Autowired
  private RankingStakeRepo rankingStakeRepo;

  @Autowired
  private AppointStakeRepo appointStakeRepo;

  @Autowired
  private CommonStakeRepo commonStakeRepo;

  @Autowired
  private DayCountStakeRepo dayCountStakeRepo;

  @Autowired
  private CalculationService calculationService;

  // @Scheduled(cron = "0 56 23 * * ?")
  @Scheduled(cron = "0 0 9 * * ?")
  public void reportCurrentTime() {

    Date racingStartTime = DateUtil.setDateHHmmss(new Date(), 9, 7, 0);

    for (int i = 0; i < 179; i++) {
      // for (int i = 0; i < 200; i++) {
      int target = new Random().nextInt(CalculationService.allResult.size());

      Integer[] result = CalculationService.allResult.get(target);

      RecordResult recordResult = new RecordResult();
      recordResult.setFirst(result[0]);
      recordResult.setSecond(result[1]);
      recordResult.setThird(result[2]);
      recordResult.setFourth(result[3]);
      recordResult.setFifth(result[4]);
      recordResult.setSixth(result[5]);
      recordResult.setSeventh(result[6]);
      recordResult.setEighth(result[7]);
      recordResult.setNinth(result[8]);
      recordResult.setTenth(result[9]);

      recordResult.setFirstAddSecond(result[0] + result[1]);
      recordResult.setIsFirstSecondBig((result[0] + result[1]) > 11);
      recordResult.setIsFirstSecondOdd((result[0] + result[1]) % 2 == 0);
      recordResult.setIsFirstUp(result[0] > result[9]);
      recordResult.setIsSecondUp(result[1] > result[8]);
      recordResult.setIsThirdUp(result[2] > result[7]);
      recordResult.setIsFourthUp(result[3] > result[6]);
      recordResult.setIsFifthUp(result[4] > result[5]);

      recordResult.setIsComplateCalculation(false);
      String racingNum = repo.getNewRecordResultRacingNum();
      recordResult.setRacingNum(racingNum);
      recordResult.setStartTime(racingStartTime);
      // recordResult.setStartTime(DateUtil.addSecond(new Date(), 300));

      repo.addNewRecordResult(recordResult);

      CommonStake commonStake = new CommonStake();
      commonStakeRepo.addNewCommonStake(commonStake, racingNum);

      List<AppointStake> appointStakeList = new ArrayList<AppointStake>();
      for (int j = 0; j < 10; j++) {
        AppointStake appointStake = new AppointStake();
        appointStake.setCarNum(j + 1);
        appointStakeList.add(appointStake);
      }
      appointStakeRepo.batchAddAppointStake(appointStakeList, racingNum);

      List<RankingStake> rankingStakeList = new ArrayList<RankingStake>();
      for (int j = 0; j < 10; j++) {
        RankingStake rankingStake = new RankingStake();
        rankingStake.setRankingNum(j + 1);
        rankingStakeList.add(rankingStake);
      }
      rankingStakeRepo.batchAddRankingStake(rankingStakeList, racingNum);

      racingStartTime = DateUtil.addSecond(racingStartTime, 300);
    }
  }

//  @Scheduled(cron = "7 6/5 0-23 * * ?")
  public void invokeCalculation() {
    Date nowDate = new Date();
    RecordResult recordResult = repo.getNowNextRecordResult(nowDate);
    if (recordResult == null) {
      return;
    }
    long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
    if (betweenTime > 120) {// 获取到的下一场比赛与当前的时间差超过120（粗略，其实应该超过55，或60）即该比赛无效
      return;
    }
    CommonStake commonStake = commonStakeRepo.getCommonStakeByRacingNum(recordResult.getRacingNum());
    List<AppointStake> appointStakeList = appointStakeRepo.getAppointStakeList(recordResult.getRacingNum());
    List<RankingStake> rankingStakeList = rankingStakeRepo.getRankingStakeList(recordResult.getRacingNum());
    calculationService.calculation(recordResult.getRacingNum(), appointStakeList, commonStake, rankingStakeList);
  }

//  @Scheduled(cron = "55 6/5 0-23 * * ?")
  public void invokeDayCountStake() throws ParseException {
    Date nowDate = new Date();
    List<RecordResult> recordResultList = repo.getRecordResultByStartTime(DateUtil.getBeginOfDay(nowDate), DateUtil.getEndOfDay(nowDate));
    BigDecimal totalStakeAmount = BigDecimal.ZERO;
    BigDecimal totalDeficitAmount = BigDecimal.ZERO;
    Integer totalStakeCount = 0;
    if (CollectionUtils.isNotEmpty(recordResultList)) {
      for (RecordResult recordResult : recordResultList) {
        totalStakeAmount = totalStakeAmount.add(recordResult.getTotalStakeAmount());
        totalDeficitAmount = totalDeficitAmount.add(recordResult.getTotalDeficitAmount());
        totalStakeCount = totalStakeCount + recordResult.getTotalStakeCount();
      }
    }

    DayCountStake todayDayCountStake = dayCountStakeRepo.getDayCountStake(nowDate);
    if (todayDayCountStake == null) {
      dayCountStakeRepo.addNewDayCountStake(totalStakeAmount, totalDeficitAmount, totalStakeCount, nowDate);
    } else {
      dayCountStakeRepo.updateTotalStakeAmountAndTotalDeficitAmount(nowDate, totalStakeAmount, totalDeficitAmount, totalStakeCount);
    }

  }


}
