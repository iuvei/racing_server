package com.racing.service.calc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.service.calc.bo.CalcRate;
import com.racing.service.calc.bo.CalcResultVo;

public class CalculationHandle {

	public static List<Integer[]> allResult = new ArrayList<Integer[]>();

	static {
		char array[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		Arrange(array, 0, array.length - 1);
	}

	/**
	 * 指定车号是第几名的赔率
	 */
	private BigDecimal appointStakeRate = new BigDecimal("9.7");

	/**
	 * 名次对应的车号是大是小是单是双情况赔率
	 */
	private BigDecimal rankingStakeRate = new BigDecimal("1.94");

	/**
	 * 名次1~5的车号龙虎赔率
	 */
	private BigDecimal upOrDownRate = new BigDecimal("1.94");

	/**
	 * 冠亚和单赔率
	 */
	private BigDecimal firstAddSecondOddRate = new BigDecimal("1.63");
	/**
	 * 冠亚和双赔率
	 */
	private BigDecimal firstAddSecondEvenRate = new BigDecimal("2");

	/**
	 * 冠亚和大赔率
	 */
	private BigDecimal firstAddSecondBigRate = new BigDecimal("2");
	/**
	 * 冠亚和小赔率
	 */
	private BigDecimal firstAddSecondSmallRate = new BigDecimal("1.63");

	/**
	 * 冠亚和指定赔率
	 */
	private BigDecimal firstAddSecondAppoint3StakeRate = new BigDecimal("41");
	private BigDecimal firstAddSecondAppoint4StakeRate = new BigDecimal("41");
	private BigDecimal firstAddSecondAppoint5StakeRate = new BigDecimal("21");
	private BigDecimal firstAddSecondAppoint6StakeRate = new BigDecimal("21");
	private BigDecimal firstAddSecondAppoint7StakeRate = new BigDecimal("12");
	private BigDecimal firstAddSecondAppoint8StakeRate = new BigDecimal("12");
	private BigDecimal firstAddSecondAppoint9StakeRate = new BigDecimal("10.3");
	private BigDecimal firstAddSecondAppoint10StakeRate = new BigDecimal("10.3");
	private BigDecimal firstAddSecondAppoint11StakeRate = new BigDecimal("8.3");
	private BigDecimal firstAddSecondAppoint12StakeRate = new BigDecimal("10.3");
	private BigDecimal firstAddSecondAppoint13StakeRate = new BigDecimal("10.3");
	private BigDecimal firstAddSecondAppoint14StakeRate = new BigDecimal("12");
	private BigDecimal firstAddSecondAppoint15StakeRate = new BigDecimal("12");
	private BigDecimal firstAddSecondAppoint16StakeRate = new BigDecimal("21");
	private BigDecimal firstAddSecondAppoint17StakeRate = new BigDecimal("21");
	private BigDecimal firstAddSecondAppoint18StakeRate = new BigDecimal("41");
	private BigDecimal firstAddSecondAppoint19StakeRate = new BigDecimal("41");

	public CalculationHandle(CalcRate calcDefaultRate) {
		this.appointStakeRate = calcDefaultRate.getAppointStakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getAppointStakeRate();
		this.rankingStakeRate = calcDefaultRate.getRankingStakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getRankingStakeRate();
		this.upOrDownRate = calcDefaultRate.getUpOrDownRate() == null ? BigDecimal.ZERO : calcDefaultRate.getUpOrDownRate();
		this.firstAddSecondOddRate = calcDefaultRate.getFirstAddSecondOddRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondOddRate();
		this.firstAddSecondEvenRate = calcDefaultRate.getFirstAddSecondEvenRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondEvenRate();
		this.firstAddSecondBigRate = calcDefaultRate.getFirstAddSecondBigRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondBigRate();
		this.firstAddSecondSmallRate = calcDefaultRate.getFirstAddSecondSmallRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondSmallRate();
		
		this.firstAddSecondAppoint3StakeRate = calcDefaultRate.getFirstAddSecondAppoint3StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint3StakeRate();
		this.firstAddSecondAppoint4StakeRate = calcDefaultRate.getFirstAddSecondAppoint4StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint4StakeRate();
		this.firstAddSecondAppoint5StakeRate = calcDefaultRate.getFirstAddSecondAppoint5StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint5StakeRate();
		this.firstAddSecondAppoint6StakeRate = calcDefaultRate.getFirstAddSecondAppoint6StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint6StakeRate();
		this.firstAddSecondAppoint7StakeRate = calcDefaultRate.getFirstAddSecondAppoint7StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint7StakeRate();
		this.firstAddSecondAppoint8StakeRate = calcDefaultRate.getFirstAddSecondAppoint8StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint8StakeRate();
		this.firstAddSecondAppoint9StakeRate = calcDefaultRate.getFirstAddSecondAppoint9StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint9StakeRate();
		this.firstAddSecondAppoint10StakeRate = calcDefaultRate.getFirstAddSecondAppoint10StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint10StakeRate();
		this.firstAddSecondAppoint11StakeRate = calcDefaultRate.getFirstAddSecondAppoint11StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint11StakeRate();
		this.firstAddSecondAppoint12StakeRate = calcDefaultRate.getFirstAddSecondAppoint12StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint12StakeRate();
		this.firstAddSecondAppoint13StakeRate = calcDefaultRate.getFirstAddSecondAppoint13StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint13StakeRate();
		this.firstAddSecondAppoint14StakeRate = calcDefaultRate.getFirstAddSecondAppoint14StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint14StakeRate();
		this.firstAddSecondAppoint15StakeRate = calcDefaultRate.getFirstAddSecondAppoint15StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint15StakeRate();
		this.firstAddSecondAppoint16StakeRate = calcDefaultRate.getFirstAddSecondAppoint16StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint16StakeRate();
		this.firstAddSecondAppoint17StakeRate = calcDefaultRate.getFirstAddSecondAppoint17StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint17StakeRate();
		this.firstAddSecondAppoint18StakeRate = calcDefaultRate.getFirstAddSecondAppoint18StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint18StakeRate();
		this.firstAddSecondAppoint19StakeRate = calcDefaultRate.getFirstAddSecondAppoint19StakeRate() == null ? BigDecimal.ZERO : calcDefaultRate.getFirstAddSecondAppoint19StakeRate();
		
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
	public CalcResultVo dealOptimalCalculation(String racingNum, List<AppointStake> appointStakeList,
			CommonStake commonStake, List<RankingStake> rankingStakeList) {
		Map<Integer, Map<Integer, BigDecimal>> appointStakeMap = this.convertAppointStake(appointStakeList);
		Map<Integer, RankingStake> rankingStakeMap = this.convertRankingStake(rankingStakeList);
		List<Integer[]> calcResultList = new ArrayList<Integer[]>();
		CalcResultVo preCalcResult = new CalcResultVo();
		Map<String, Object> calcResultMap;
		for (Integer[] result : allResult) {
			calcResultMap = this.dealCalculation(result, racingNum, appointStakeMap, rankingStakeMap, commonStake,
					preCalcResult, calcResultList);
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
	 * 根据押注情况以及比赛结果计算出庄家应出金额
	 * 
	 * @param result
	 * @param appointStakeList
	 * @param commonStake
	 * @param rankingStakeList
	 * @return
	 */
	public BigDecimal dealCalculation(Integer[] result, List<AppointStake> appointStakeList, CommonStake commonStake,
			List<RankingStake> rankingStakeList) {
		Map<Integer, Map<Integer, BigDecimal>> appointStakeMap = this.convertAppointStake(appointStakeList);
		Map<Integer, RankingStake> rankingStakeMap = this.convertRankingStake(rankingStakeList);
		return this.dealCalculation(result, appointStakeMap, rankingStakeMap, commonStake);
	}
	
	/**
	 * 计算结果集
	 * 
	 * @param racingNum
	 * @param appointStakeList
	 * @param commonStake
	 * @return
	 */
	private Map<String, Object> dealCalculation(Integer[] result, String racingNum,
			Map<Integer, Map<Integer, BigDecimal>> appointStakeMap, Map<Integer, RankingStake> rankingStakeMap,
			CommonStake commonStake, CalcResultVo preCalcResult, List<Integer[]> calcResultList) {
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
	 * @param appointStakeMap
	 * @param rankingStakeMap
	 * @param commonStake
	 * @return
	 */
	private BigDecimal dealCalculation(Integer[] result, Map<Integer, Map<Integer, BigDecimal>> appointStakeMap,
			Map<Integer, RankingStake> rankingStakeMap, CommonStake commonStake) {

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

		BigDecimal upOrDownResultAllAmount = firstUpOrDownResultAmount.add(secondUpOrDownResultAmount)
				.add(thirdUpOrDownResultAmount).add(fourthUpOrDownResultAmount).add(fifthUpOrDownResultAmount);
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

		BigDecimal resultAmount = appointStakeResultAmount.add(rankingStakeResultAmount).add(upOrDownResultAllAmount)
				.add(firstSecondOddOrEvenResultAmount).add(firstSecondBigOrSmallResultAmount)
				.add(firstSecondAddAppointAmount);

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
