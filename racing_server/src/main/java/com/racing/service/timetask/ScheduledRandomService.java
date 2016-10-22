package com.racing.service.timetask;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.racing.model.po.RecordResult;
import com.racing.model.po.User;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.TotalAppointStakeRepo;
import com.racing.model.repo.TotalCommonStakeRepo;
import com.racing.model.repo.TotalDayCountIncomeRepo;
import com.racing.model.repo.TotalRankingStakeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.service.calc.CalculationHandle;
import com.racing.service.statistics.TotalStatisticsService;
import com.racing.service.statistics.UserStatisticsInvoke;
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

//  @Autowired
//  private TotalRacingIncomeRepo totalRacingIncomeRepo; 
  
  @Autowired
  private TotalDayCountIncomeRepo totalDayCountIncomeRepo;
  
  /**
   * 生成当天所有比赛的期号及预先设置的比赛结果
   * 每天早上8点50分开始执行，预计执行10~15分钟
   * 生成的信息是9点7分开始第一场比赛，之后每5分钟一场，即第二场比赛9点12分
   */
//  @Scheduled(cron = "0 50 8 * * ?")
  @Scheduled(cron = "0 10 7 * * ?")
  public void reportCurrentTime() {

    Date racingStartTime = DateUtil.setDateHHmmss(new Date(), 7, 22, 0);

//    for (int i = 0; i < 350; i++) {
   for (int i = 0; i < 200; i++) {
      int target = new Random().nextInt(CalculationHandle.allResult.size());

      Integer[] result = CalculationHandle.allResult.get(target);

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
   
    totalDayCountIncomeRepo.initIncome(racingStartTime);
    
  }
  
  @Autowired
  private TotalStatisticsService totalStatisticsService;
  
  /**
   * 计算最优解
   * 每天9点~23点的1分7秒开始，每5分钟一次（9点7分开始第一场比赛，6分7秒开始计算，即当前比赛倒计时53秒时）
   */
  @Scheduled(cron = "7 1/5 0-23 * * ?")
  public void invokeDealRecordResultOptimalCalculation() {
	  totalStatisticsService.dealRecordResultOptimalCalculation();
  }
  
  /**
   * 统计总盘的按期号盈亏和押注（取当前时间的上一场比赛，进行统计）
   * 每天9点~23点7分5秒开始，没五分钟一次（9点7分开始第一场比赛，7分5秒开始统计上一场比赛结果，即新一轮比赛倒计时295秒时）
   */
  @Scheduled(cron = "5 2/5 0-23 * * ?")
  public void invokeDealTotalIncome(){
	  totalStatisticsService.dealTotalIncome();
  }

  @Autowired
  private UserStatisticsInvoke userStatisticsInvoke;
  
  @Autowired
  private UserRepo userRepo;
  
  /**
   * 统计分盘的按期号盈亏和押注（取当前时间的上一场比赛，进行统计）
   * 每天9点~23点7分10秒开始，每五分钟一次（9点7分开始第一场比赛，7分10秒开始统计上一场比赛结果，即新一轮比赛倒计时290秒时）
   */
  @Scheduled(cron = "10 2/5 0-23 * * ?")
  public void invokeDealUserIncome(){
	  List<User> userList = userRepo.selectUser();
	  for(User user : userList){
		  userStatisticsInvoke.asyncDealUserIncome(user.getId());
	  }
  }
  
}
