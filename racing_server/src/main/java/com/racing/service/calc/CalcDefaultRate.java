package com.racing.service.calc;

import java.math.BigDecimal;

public class CalcDefaultRate {

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

}
