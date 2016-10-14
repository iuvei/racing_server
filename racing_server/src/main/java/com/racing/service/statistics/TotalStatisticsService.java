package com.racing.service.statistics;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.model.po.RecordResult;
import com.racing.model.po.TotalAppointStake;
import com.racing.model.po.TotalCommonStake;
import com.racing.model.po.TotalDayCountIncomeWithBLOBs;
import com.racing.model.po.TotalRacingIncome;
import com.racing.model.po.TotalRankingStake;
import com.racing.model.po.util.TotalDayStakeConvertUtil;
import com.racing.model.po.util.TotalStakeConvertUtil;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.TotalAppointStakeRepo;
import com.racing.model.repo.TotalCommonStakeRepo;
import com.racing.model.repo.TotalDayCountIncomeRepo;
import com.racing.model.repo.TotalRacingIncomeRepo;
import com.racing.model.repo.TotalRankingStakeRepo;
import com.racing.model.stake.AppointStake;
import com.racing.model.stake.CommonStake;
import com.racing.model.stake.RankingStake;
import com.racing.model.stake.StakeVo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.service.calc.CalculationHandle;
import com.racing.service.calc.bo.CalcRate;
import com.racing.service.calc.bo.CalcResultVo;
import com.racing.util.DateUtil;
import com.racing.util.JsonUtils;

@Service
public class TotalStatisticsService {

	@Autowired
	private RecordResultRepo recordResultRepo;
	
	@Autowired
	private TotalCommonStakeRepo commonStakeRepo;
	
	@Autowired
	private TotalAppointStakeRepo appointStakeRepo;

	@Autowired
	private TotalRankingStakeRepo rankingStakeRepo;
	
	@Autowired
	private TotalRacingIncomeRepo totalRacingIncomeRepo;
	
	@Autowired
	private TotalDayCountIncomeRepo totalDayCountIncomeRepo;
	
	private CalcRate totalDefaultCalcRate;
	
	@PostConstruct
	public void init() {
		totalDefaultCalcRate = new CalcRate();
		totalDefaultCalcRate.setAppointStakeRate(new BigDecimal("9.7"));
		totalDefaultCalcRate.setRankingStakeRate(new BigDecimal("1.94"));
		totalDefaultCalcRate.setUpOrDownRate(new BigDecimal("1.94"));
		totalDefaultCalcRate.setFirstAddSecondOddRate(new BigDecimal("1.63"));
		totalDefaultCalcRate.setFirstAddSecondEvenRate(new BigDecimal("2"));
		totalDefaultCalcRate.setFirstAddSecondBigRate(new BigDecimal("2"));
		totalDefaultCalcRate.setFirstAddSecondSmallRate(new BigDecimal("1.63"));
		totalDefaultCalcRate.setFirstAddSecondAppoint3StakeRate(new BigDecimal("41"));
		totalDefaultCalcRate.setFirstAddSecondAppoint4StakeRate(new BigDecimal("41"));
		totalDefaultCalcRate.setFirstAddSecondAppoint5StakeRate(new BigDecimal("21"));
		totalDefaultCalcRate.setFirstAddSecondAppoint6StakeRate(new BigDecimal("21"));
		totalDefaultCalcRate.setFirstAddSecondAppoint7StakeRate(new BigDecimal("12"));
		totalDefaultCalcRate.setFirstAddSecondAppoint8StakeRate(new BigDecimal("12"));
		totalDefaultCalcRate.setFirstAddSecondAppoint9StakeRate(new BigDecimal("10.3"));
		totalDefaultCalcRate.setFirstAddSecondAppoint10StakeRate(new BigDecimal("10.3"));
		totalDefaultCalcRate.setFirstAddSecondAppoint11StakeRate(new BigDecimal("8.3"));
		totalDefaultCalcRate.setFirstAddSecondAppoint12StakeRate(new BigDecimal("10.3"));
		totalDefaultCalcRate.setFirstAddSecondAppoint13StakeRate(new BigDecimal("10.3"));
		totalDefaultCalcRate.setFirstAddSecondAppoint14StakeRate(new BigDecimal("12"));
		totalDefaultCalcRate.setFirstAddSecondAppoint15StakeRate(new BigDecimal("12"));
		totalDefaultCalcRate.setFirstAddSecondAppoint16StakeRate(new BigDecimal("21"));
		totalDefaultCalcRate.setFirstAddSecondAppoint17StakeRate(new BigDecimal("21"));
		totalDefaultCalcRate.setFirstAddSecondAppoint18StakeRate(new BigDecimal("41"));
		totalDefaultCalcRate.setFirstAddSecondAppoint19StakeRate(new BigDecimal("41"));
	}

	public void dealTotalStatistics() {
		Date nowDate = new Date();
		RecordResult recordResult = recordResultRepo.getNowNextRecordResult(nowDate);
		if (recordResult == null) {
			return;
		}
		long betweenTime = DateUtil.secondBetweenTwoDate(recordResult.getStartTime(), nowDate);
		if (betweenTime > 120) {// 获取到的下一场比赛与当前的时间差超过120（粗略，其实应该超过55，或60）即该比赛无效
			return;
		}
		
		StakeVo newStakeVo = this.getStake(recordResult.getRacingNum()); 
		
		//------------计算比赛结果------------
		
		CalcResultVo result = new CalculationHandle(totalDefaultCalcRate).dealOptimalCalculation(recordResult.getRacingNum(), newStakeVo.getAppointStakeList(), newStakeVo.getCommonStake(), newStakeVo.getRankingStakeList());
		RecordResult newRecordResult = new RecordResult();
		newRecordResult.setRacingNum(recordResult.getRacingNum());
		newRecordResult.setFirst(result.getRacingResult()[0]);
		newRecordResult.setSecond(result.getRacingResult()[1]);
		newRecordResult.setThird(result.getRacingResult()[2]);
		newRecordResult.setFourth(result.getRacingResult()[3]);
		newRecordResult.setFifth(result.getRacingResult()[4]);
		newRecordResult.setSixth(result.getRacingResult()[5]);
		newRecordResult.setSeventh(result.getRacingResult()[6]);
		newRecordResult.setEighth(result.getRacingResult()[7]);
		newRecordResult.setNinth(result.getRacingResult()[8]);
		newRecordResult.setTenth(result.getRacingResult()[9]);
		newRecordResult.setFirstAddSecond(result.getFirstAddSecond());
		newRecordResult.setIsFirstSecondBig(result.getIsFirstSecondBig());
		newRecordResult.setIsFirstSecondOdd(result.getIsFirstSecondOdd());
		newRecordResult.setIsFirstUp(result.getIsFirstUp());
		newRecordResult.setIsSecondUp(result.getIsSecondUp());
		newRecordResult.setIsThirdUp(result.getIsThirdUp());
		newRecordResult.setIsFourthUp(result.getIsFourthUp());
		newRecordResult.setIsFifthUp(result.getIsFifthUp());
		newRecordResult.setIsComplateCalculation(true);
		newRecordResult.setComplateCalculationTime(new Date());
		recordResultRepo.updateRecordResultByRacingNum(recordResult, recordResult.getRacingNum());
		
	}

	public void dealTotalIncome(String racingNum){
		RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
		if(recordResult.getIsComplateStatistics()){
			return;
		}
		Integer[] racingResult = RecordResultPOUtil.convertResult(recordResult);
		
		StakeVo newStakeVo = this.getStake(racingNum); 
		
		BigDecimal result = new CalculationHandle(totalDefaultCalcRate).dealCalculation(racingResult, newStakeVo.getAppointStakeList(), newStakeVo.getCommonStake(), newStakeVo.getRankingStakeList());
		TotalRacingIncome racingIncome = new TotalRacingIncome();
		racingIncome.setIncomeAmount(result);
		racingIncome.setRacingNum(racingNum);
		racingIncome.setStakeAmount(BigDecimal.ZERO);
		racingIncome.setStakeCount(0);
		totalRacingIncomeRepo.updateRacingIncome(racingIncome);
		
		Date nowDate = new Date();
		
		TotalDayCountIncomeWithBLOBs oldDayCountIncomeWithBLOBs = totalDayCountIncomeRepo.getByDay(nowDate);
		StakeVo oldStakeVo = TotalDayStakeConvertUtil.commontStakPoToVo(oldDayCountIncomeWithBLOBs);
		
		StakeVo resultStake = StakeVoUtil.stakeAdd(oldStakeVo, newStakeVo);
		
		TotalRacingIncome newRacingIncome = totalRacingIncomeRepo.selectByRacingNum(racingNum);
		
		TotalDayCountIncomeWithBLOBs dayCountIncomeWithBLOBs = new TotalDayCountIncomeWithBLOBs(); 
		dayCountIncomeWithBLOBs.setDay(DateUtil.parseToString(nowDate, DateUtil.DateFormat_yyyy_MM_dd));
		
		dayCountIncomeWithBLOBs.setAppointStake(JsonUtils.toJsonHasNullKey(resultStake.getAppointStakeList()));
		dayCountIncomeWithBLOBs.setCommonStake(JsonUtils.toJsonHasNullKey(resultStake.getCommonStake()));
		dayCountIncomeWithBLOBs.setRankingStake(JsonUtils.toJsonHasNullKey(resultStake.getRankingStakeList()));
		dayCountIncomeWithBLOBs.setIncomeAmount(result);
		dayCountIncomeWithBLOBs.setStakeCount(0);
		dayCountIncomeWithBLOBs.setStakeAmount(newRacingIncome.getStakeAmount());
		
		totalDayCountIncomeRepo.updateIncome(dayCountIncomeWithBLOBs);
		
		recordResult.setIsComplateStatistics(true);
		recordResultRepo.updateRecordResultByRacingNum(recordResult, racingNum);
		
	}
	
	private StakeVo getStake(String racingNum){
		StakeVo newStakeVo = new StakeVo(); 
		
		//------------计算比赛结果------------
		TotalCommonStake totalCommonStake = commonStakeRepo.getRacingNum(racingNum);
		CommonStake commonStake = TotalStakeConvertUtil.commontStakPoToVo(totalCommonStake);
		newStakeVo.setCommonStake(commonStake);
		
		List<TotalAppointStake> totalAppointStakeList = appointStakeRepo.getByRacingNum(racingNum);
		List<AppointStake> appointStakeList = TotalStakeConvertUtil.appointStakPoToVo(totalAppointStakeList);
		newStakeVo.setAppointStakeList(appointStakeList);
		
		List<TotalRankingStake> totalRankingStakeList = rankingStakeRepo.getRacingNum(racingNum);
		List<RankingStake> rankingStakeList = TotalStakeConvertUtil.rankingPoToVo(totalRankingStakeList);
		newStakeVo.setRankingStakeList(rankingStakeList);
		return newStakeVo;
	}
	
}
