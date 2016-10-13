package com.racing.service.calc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.model.po.RecordResult;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;

@Service
public class CalculationService {

  public static List<Integer[]> allResult = new ArrayList<Integer[]>();

  /**
   * 指定车号是第几名的赔率
   */
  private static BigDecimal appointStakeRate = new BigDecimal("9.7");

  /**
   * 名次对应的车号是大是小是单是双情况赔率
   */
  private static BigDecimal rankingStakeRate = new BigDecimal("1.94");

  /**
   * 名次1~5的车号龙虎赔率
   */
  private static BigDecimal upOrDownRate = new BigDecimal("1.94");

  /**
   * 冠亚和单赔率
   */
  private static BigDecimal firstAddSecondOddRate = new BigDecimal("1.63");
  /**
   * 冠亚和双赔率
   */
  private static BigDecimal firstAddSecondEvenRate = new BigDecimal("2");

  /**
   * 冠亚和大赔率
   */
  private static BigDecimal firstAddSecondBigRate = new BigDecimal("2");
  /**
   * 冠亚和小赔率
   */
  private static BigDecimal firstAddSecondSmallRate = new BigDecimal("1.63");

  /**
   * 冠亚和指定赔率
   */
  private static BigDecimal firstAddSecondAppoint3StakeRate = new BigDecimal("41");
  private static BigDecimal firstAddSecondAppoint4StakeRate = new BigDecimal("41");
  private static BigDecimal firstAddSecondAppoint5StakeRate = new BigDecimal("21");
  private static BigDecimal firstAddSecondAppoint6StakeRate = new BigDecimal("21");
  private static BigDecimal firstAddSecondAppoint7StakeRate = new BigDecimal("12");
  private static BigDecimal firstAddSecondAppoint8StakeRate = new BigDecimal("12");
  private static BigDecimal firstAddSecondAppoint9StakeRate = new BigDecimal("10.3");
  private static BigDecimal firstAddSecondAppoint10StakeRate = new BigDecimal("10.3");
  private static BigDecimal firstAddSecondAppoint11StakeRate = new BigDecimal("8.3");
  private static BigDecimal firstAddSecondAppoint12StakeRate = new BigDecimal("10.3");
  private static BigDecimal firstAddSecondAppoint13StakeRate = new BigDecimal("10.3");
  private static BigDecimal firstAddSecondAppoint14StakeRate = new BigDecimal("12");
  private static BigDecimal firstAddSecondAppoint15StakeRate = new BigDecimal("12");
  private static BigDecimal firstAddSecondAppoint16StakeRate = new BigDecimal("21");
  private static BigDecimal firstAddSecondAppoint17StakeRate = new BigDecimal("21");
  private static BigDecimal firstAddSecondAppoint18StakeRate = new BigDecimal("41");
  private static BigDecimal firstAddSecondAppoint19StakeRate = new BigDecimal("41");

  @Autowired
  private RecordResultRepo repo;

  @PostConstruct
  public void initAllRacingResult() {
    char array[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    Arrange(array, 0, array.length - 1);
  }

  // @Async
  public void calculation(String racingNum, List<AppointStake> appointStakeList, CommonStake commonStake, List<RankingStake> rankingStakeList) {
    CalcResultVo result = this.dealOptimalCalculation(racingNum, appointStakeList, commonStake, rankingStakeList);
    RecordResult recordResult = new RecordResult();
    recordResult.setRacingNum(racingNum);
    recordResult.setFirst(result.getRacingResult()[0]);
    recordResult.setSecond(result.getRacingResult()[1]);
    recordResult.setThird(result.getRacingResult()[2]);
    recordResult.setFourth(result.getRacingResult()[3]);
    recordResult.setFifth(result.getRacingResult()[4]);
    recordResult.setSixth(result.getRacingResult()[5]);
    recordResult.setSeventh(result.getRacingResult()[6]);
    recordResult.setEighth(result.getRacingResult()[7]);
    recordResult.setNinth(result.getRacingResult()[8]);
    recordResult.setTenth(result.getRacingResult()[9]);
    recordResult.setFirstAddSecond(result.getFirstAddSecond());
    recordResult.setIsFirstSecondBig(result.getIsFirstSecondBig());
    recordResult.setIsFirstSecondOdd(result.getIsFirstSecondOdd());
    recordResult.setIsFirstUp(result.getIsFirstUp());
    recordResult.setIsSecondUp(result.getIsSecondUp());
    recordResult.setIsThirdUp(result.getIsThirdUp());
    recordResult.setIsFourthUp(result.getIsFourthUp());
    recordResult.setIsFifthUp(result.getIsFifthUp());
    recordResult.setIsComplateCalculation(true);
    repo.updateRecordResultByRacingNum(recordResult, racingNum);
  }

  /**
   * 遍历全部结果，计算每一个结果的情况找出最优解
   * 
   * @param racingNum
   * @param appointStakeList
   * @param commonStake
   * @return
   */
  @SuppressWarnings("unchecked")
  private CalcResultVo dealOptimalCalculation(String racingNum, List<AppointStake> appointStakeList, CommonStake commonStake, List<RankingStake> rankingStakeList) {
    Map<Integer, Map<Integer, BigDecimal>> appointStakeMap = this.convertAppointStake(appointStakeList);
    Map<Integer, RankingStake> rankingStakeMap = this.convertRankingStake(rankingStakeList);
    List<Integer[]> calcResultList = new ArrayList<Integer[]>();
    CalcResultVo preCalcResult = new CalcResultVo();
    Map<String, Object> calcResultMap;
    for (Integer[] result : allResult) {
      calcResultMap = this.dealCalculation(result, racingNum, appointStakeMap, rankingStakeMap, commonStake, preCalcResult, calcResultList);
      preCalcResult = (CalcResultVo) calcResultMap.get("calcResultVo");
      calcResultList = ((ArrayList<Integer[]>) calcResultMap.get("calcResultList"));
    }
    int target = new Random().nextInt(calcResultList.size());
    Integer[] result = calcResultList.get(target);
    CalcResultVo calcResult = new CalcResultVo();
    calcResult.setRacingResult(result);
    // 重新计算一次庄家应出金额
    calcResult.setPreResultAmount(this.dealCalculation(result, appointStakeMap, rankingStakeMap, commonStake));

    int firstAddSecondResult = result[0] + result[1];
    calcResult.setFirstAddSecond(firstAddSecondResult);
    calcResult.setIsFirstSecondBig(firstAddSecondResult > 11);
    calcResult.setIsFirstSecondOdd(firstAddSecondResult % 2 != 0);
    calcResult.setIsFirstUp(result[0] > result[9]);
    calcResult.setIsSecondUp(result[1] > result[8]);
    calcResult.setIsThirdUp(result[2] > result[7]);
    calcResult.setIsFourthUp(result[3] > result[6]);
    calcResult.setIsFifthUp(result[4] > result[5]);

    return calcResult;
  }

  /**
   * 计算结果集
   * 
   * @param racingNum
   * @param appointStakeList
   * @param commonStake
   * @return
   */
  private Map<String, Object> dealCalculation(Integer[] result, String racingNum, Map<Integer, Map<Integer, BigDecimal>> appointStakeMap,
      Map<Integer, RankingStake> rankingStakeMap, CommonStake commonStake, CalcResultVo preCalcResult, List<Integer[]> calcResultList) {
    BigDecimal preResultAmount = preCalcResult.getPreResultAmount();

    CalcResultVo calcResultVo = new CalcResultVo();

    BigDecimal resultAmount = this.dealCalculation(result, appointStakeMap, rankingStakeMap, commonStake);

    Map<String, Object> resultMap = new HashMap<String, Object>();
    if (preResultAmount == null || resultAmount.compareTo(preResultAmount) < 0) {
      calcResultVo.setPreResultAmount(resultAmount);
      calcResultVo.setRacingResult(result);
      calcResultList = new ArrayList<Integer[]>();
      calcResultList.add(result);
      resultMap.put("calcResultVo", calcResultVo);
      resultMap.put("calcResultList", calcResultList);
      return resultMap;
    }
    if (resultAmount.compareTo(preResultAmount) == 0) {
      calcResultVo.setPreResultAmount(resultAmount);
      calcResultVo.setRacingResult(result);
      calcResultList.add(result);
      resultMap.put("calcResultVo", calcResultVo);
      resultMap.put("calcResultList", calcResultList);
      return resultMap;
    }
    resultMap.put("calcResultVo", preCalcResult);
    resultMap.put("calcResultList", calcResultList);
    return resultMap;
  }

  /**
   * 根据押注情况以及比赛结果计算出庄家应出金额
   * 
   * @param result
   * @param appointStakeList
   * @param commonStake
   * @param rankingStakeList
   * @return
   */
  public BigDecimal dealCalculation(Integer[] result, List<AppointStake> appointStakeList, CommonStake commonStake, List<RankingStake> rankingStakeList) {
    Map<Integer, Map<Integer, BigDecimal>> appointStakeMap = this.convertAppointStake(appointStakeList);
    Map<Integer, RankingStake> rankingStakeMap = this.convertRankingStake(rankingStakeList);
    return this.dealCalculation(result, appointStakeMap, rankingStakeMap, commonStake);
  }

  /**
   * 根据押注情况以及比赛结果计算出庄家应出金额
   * 
   * @param result
   * @param appointStakeMap
   * @param rankingStakeMap
   * @param commonStake
   * @return
   */
  private BigDecimal dealCalculation(Integer[] result, Map<Integer, Map<Integer, BigDecimal>> appointStakeMap, Map<Integer, RankingStake> rankingStakeMap,
      CommonStake commonStake) {

    BigDecimal appointStakeResultAmount = BigDecimal.ZERO;
    BigDecimal rankingStakeResultAmount = BigDecimal.ZERO;
    for (int i = 0; i < 10; i++) {
      BigDecimal amount = appointStakeMap.get(result[i]).get(i + 1);
      appointStakeResultAmount = appointStakeResultAmount.add(amount);

      RankingStake rankingStake = rankingStakeMap.get(i + 1);
      if (result[i] >= 6) {// 名次值大
        rankingStakeResultAmount = rankingStakeResultAmount.add(rankingStake.getBig());
      } else {// 名次值小
        rankingStakeResultAmount = rankingStakeResultAmount.add(rankingStake.getSmall());
      }

      if (result[i] % 2 == 0) {// 名次值双
        rankingStakeResultAmount = rankingStakeResultAmount.add(rankingStake.getEven());
      } else {// 名次值单
        rankingStakeResultAmount = rankingStakeResultAmount.add(rankingStake.getOdd());
      }

    }
    appointStakeResultAmount = appointStakeResultAmount.multiply(appointStakeRate);
    rankingStakeResultAmount = rankingStakeResultAmount.multiply(rankingStakeRate);


    BigDecimal firstUpOrDownResultAmount = BigDecimal.ZERO;
    if (result[0] > result[9]) {
      firstUpOrDownResultAmount = commonStake.getFirstUp();
    } else {
      firstUpOrDownResultAmount = commonStake.getFirstDowm();
    }

    BigDecimal secondUpOrDownResultAmount = BigDecimal.ZERO;
    if (result[1] > result[8]) {
      secondUpOrDownResultAmount = commonStake.getSecondUp();
    } else {
      secondUpOrDownResultAmount = commonStake.getSecondDowm();
    }

    BigDecimal thirdUpOrDownResultAmount = BigDecimal.ZERO;
    if (result[2] > result[7]) {
      thirdUpOrDownResultAmount = commonStake.getThirdUp();
    } else {
      thirdUpOrDownResultAmount = commonStake.getThirdDowm();
    }

    BigDecimal fourthUpOrDownResultAmount = BigDecimal.ZERO;
    if (result[3] > result[6]) {
      fourthUpOrDownResultAmount = commonStake.getFourthUp();
    } else {
      fourthUpOrDownResultAmount = commonStake.getFourthDowm();
    }

    BigDecimal fifthUpOrDownResultAmount = BigDecimal.ZERO;
    if (result[4] > result[5]) {
      fifthUpOrDownResultAmount = commonStake.getFifthUp();
    } else {
      fifthUpOrDownResultAmount = commonStake.getFifthDowm();
    }

    BigDecimal upOrDownResultAllAmount =
        firstUpOrDownResultAmount.add(secondUpOrDownResultAmount).add(thirdUpOrDownResultAmount).add(fourthUpOrDownResultAmount).add(fifthUpOrDownResultAmount);
    upOrDownResultAllAmount = upOrDownResultAllAmount.multiply(upOrDownRate);

    // 冠亚单双结果
    BigDecimal firstSecondOddOrEvenResultAmount = BigDecimal.ZERO;
    int firstAddSecondResult = result[0] + result[1];
    if (firstAddSecondResult % 2 == 0) {// 冠亚军双
      firstSecondOddOrEvenResultAmount = commonStake.getFirstSecondEven().multiply(firstAddSecondEvenRate);
    } else {// 单
      firstSecondOddOrEvenResultAmount = commonStake.getFirstSecondOdd().multiply(firstAddSecondOddRate);
    }

    // 冠亚大小结果
    BigDecimal firstSecondBigOrSmallResultAmount = BigDecimal.ZERO;
    if (firstAddSecondResult > 11) {// 冠亚军大
      firstSecondBigOrSmallResultAmount = commonStake.getFirstSecondBig().multiply(firstAddSecondBigRate);
    } else {// 小
      firstSecondBigOrSmallResultAmount = commonStake.getFirstSecondSmall().multiply(firstAddSecondSmallRate);
    }

    // 冠亚军和值指定
    BigDecimal firstSecondAddAppointAmount = this.firstSecondAddAppointAmount(result[0] + result[1], commonStake);

    BigDecimal resultAmount = appointStakeResultAmount.add(rankingStakeResultAmount).add(upOrDownResultAllAmount).add(firstSecondOddOrEvenResultAmount)
        .add(firstSecondBigOrSmallResultAmount).add(firstSecondAddAppointAmount);

    return resultAmount;

  }

  /**
   * 计算指定冠亚军和的指定值押注获胜结果金额
   * 
   * @param firstSecondResult
   * @param commonStake
   * @return
   */
  private BigDecimal firstSecondAddAppointAmount(Integer firstSecondResult, CommonStake commonStake) {
    switch (firstSecondResult) {
      case 3:
        return commonStake.getFirstSecond3().multiply(firstAddSecondAppoint3StakeRate);
      case 4:
        return commonStake.getFirstSecond4().multiply(firstAddSecondAppoint4StakeRate);
      case 5:
        return commonStake.getFirstSecond5().multiply(firstAddSecondAppoint5StakeRate);
      case 6:
        return commonStake.getFirstSecond6().multiply(firstAddSecondAppoint6StakeRate);
      case 7:
        return commonStake.getFirstSecond7().multiply(firstAddSecondAppoint7StakeRate);
      case 8:
        return commonStake.getFirstSecond8().multiply(firstAddSecondAppoint8StakeRate);
      case 9:
        return commonStake.getFirstSecond9().multiply(firstAddSecondAppoint9StakeRate);
      case 10:
        return commonStake.getFirstSecond10().multiply(firstAddSecondAppoint10StakeRate);
      case 11:
        return commonStake.getFirstSecond11().multiply(firstAddSecondAppoint11StakeRate);
      case 12:
        return commonStake.getFirstSecond12().multiply(firstAddSecondAppoint12StakeRate);
      case 13:
        return commonStake.getFirstSecond13().multiply(firstAddSecondAppoint13StakeRate);
      case 14:
        return commonStake.getFirstSecond14().multiply(firstAddSecondAppoint14StakeRate);
      case 15:
        return commonStake.getFirstSecond15().multiply(firstAddSecondAppoint15StakeRate);
      case 16:
        return commonStake.getFirstSecond16().multiply(firstAddSecondAppoint16StakeRate);
      case 17:
        return commonStake.getFirstSecond17().multiply(firstAddSecondAppoint17StakeRate);
      case 18:
        return commonStake.getFirstSecond18().multiply(firstAddSecondAppoint18StakeRate);
      case 19:
        return commonStake.getFirstSecond19().multiply(firstAddSecondAppoint19StakeRate);
      default:
        return BigDecimal.ZERO;
    }

  }

  /**
   * 组装类似于二维数组的一百种指定压住方式
   * 
   * @param appointStakeList
   * @return
   */
  private Map<Integer, Map<Integer, BigDecimal>> convertAppointStake(List<AppointStake> appointStakeList) {
    Map<Integer, Map<Integer, BigDecimal>> result = new HashMap<Integer, Map<Integer, BigDecimal>>();
    for (AppointStake appointStake : appointStakeList) {
      Map<Integer, BigDecimal> rankStakeAmount = new HashMap<Integer, BigDecimal>();
      rankStakeAmount.put(1, appointStake.getFirst());
      rankStakeAmount.put(2, appointStake.getSecond());
      rankStakeAmount.put(3, appointStake.getThird());
      rankStakeAmount.put(4, appointStake.getFourth());
      rankStakeAmount.put(5, appointStake.getFifth());
      rankStakeAmount.put(6, appointStake.getSixth());
      rankStakeAmount.put(7, appointStake.getSeventh());
      rankStakeAmount.put(8, appointStake.getEighth());
      rankStakeAmount.put(9, appointStake.getNinth());
      rankStakeAmount.put(10, appointStake.getTenth());
      result.put(appointStake.getCarNum(), rankStakeAmount);
    }
    return result;
  }

  /**
   * 组装名次情况押注方式
   * 
   * @param rankingStakeList
   * @return
   */
  private Map<Integer, RankingStake> convertRankingStake(List<RankingStake> rankingStakeList) {
    Map<Integer, RankingStake> result = new HashMap<Integer, RankingStake>();
    for (RankingStake rankingStake : rankingStakeList) {
      result.put(rankingStake.getRankingNum(), rankingStake);
    }
    return result;
  }

  private static void Arrange(char arr[], int st, int ed) {
    if (st == ed) {
      Integer[] result = new Integer[arr.length];
      for (int i = 0; i < arr.length; i++) {
        result[i] = Integer.parseInt(arr[i] + "") + 1;
      }
      allResult.add(result);
    } else {
      for (int i = st; i <= ed; i++) {
        Swap(arr, st, i);
        Arrange(arr, st + 1, ed);
        Swap(arr, i, st);
      }
    }
  }

  private static void Swap(char arr[], int i, int j) {
    if (i == j)
      return;
    else {
      char temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
    }
  }


}
