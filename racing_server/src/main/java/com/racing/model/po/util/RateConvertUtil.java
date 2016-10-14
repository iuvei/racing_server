package com.racing.model.po.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.racing.model.po.WechatClient;
import com.racing.service.calc.bo.CalcRate;

public class RateConvertUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(RateConvertUtil.class);
	
	public static CalcRate poToVo(WechatClient wechatClient){
		CalcRate calcRate = new CalcRate();
		try {
			PropertyUtils.copyProperties(calcRate, calcRate);
		} catch (Exception e) {
			LOGGER.error("拷贝属性出现异常", e);
		}
		return calcRate;
	}
	
}
