package com.racing.constant;

import java.math.BigDecimal;

import com.racing.service.calc.bo.CalcRate;

public class DefaultRacteConstant {

	public static CalcRate totalDefaultCalcRate;
	
	static{
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
	
}
