package com.racing.service.timetask;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.racing.model.po.RecordResult;
import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalRankingStake;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.TotalAppointStakeRepo;
import com.racing.model.repo.TotalCommonStakeRepo;
import com.racing.model.repo.TotalRankingStakeRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.service.calc.CalculationService;
import com.racing.util.DateUtil;

@Component
public class ScheduledRandomService {

  @Autowired
  private RecordResultRepo repo;
  
  @Autowired
  private TotalCommonStakeRepo commonStakeRepo;

  @Autowired
  private TotalRankingStakeRepo rankingStakeRepo;
  
  @Autowired
  private TotalAppointStakeRepo appointStakeRepo;


  // @Scheduled(cron = "0 56 23 * * ?")
  @Scheduled(cron = "0 50 8 * * ?")
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

      commonStakeRepo.initNewStake(racingNum);

      appointStakeRepo.initNewStake(racingNum);

      rankingStakeRepo.initNewStake(racingNum);

      racingStartTime = DateUtil.addSecond(racingStartTime, 300);
    }
  }

}
