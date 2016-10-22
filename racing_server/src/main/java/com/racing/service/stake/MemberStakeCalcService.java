package com.racing.service.stake;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.constant.DefaultRacteConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MemberStakeCalcResultVo;
import com.racing.controller.vo.MemberStakeVo;
import com.racing.model.po.RecordResult;
import com.racing.model.po.WechatClient;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.WechatClientRepo;
import com.racing.model.stake.StakeCountInfoVo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.model.stake.util.StakeVoUtil;
import com.racing.service.calc.CalculationHandle;
import com.racing.service.calc.bo.CalcRate;

@Service
public class MemberStakeCalcService {

	@Autowired
	private RecordResultRepo recordResultRepo;
	
	@Autowired
	private WechatClientRepo wechatClientRepo;
	
	public ApiResult memberStakeCalc(List<MemberStakeVo> memberStakeVo, Integer userId) throws Exception{
		Date nowDate = new Date();
		List<MemberStakeCalcResultVo> result = new ArrayList<MemberStakeCalcResultVo>();
		if(CollectionUtils.isNotEmpty(memberStakeVo)){
			CalcRate calcRate = new CalcRate();
			WechatClient wechatClient = wechatClientRepo.select(userId);
			if(wechatClient == null){
				calcRate = DefaultRacteConstant.totalDefaultCalcRate;
			}else{
				try {
					PropertyUtils.copyProperties(calcRate, wechatClient);
				} catch (Exception e) {
					throw e;
				}
			}
			RecordResult recordResult = null;
			for(MemberStakeVo stakeVo : memberStakeVo){
				MemberStakeCalcResultVo resultVo = new MemberStakeCalcResultVo();
				
				resultVo.setWechatSn(stakeVo.getWechatSn());
				
				String racingNum = stakeVo.getStakeVo().getRacingNum();
				if(recordResult == null){
					recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
					if(recordResult == null){
						return ApiResult.createErrorReuslt("比赛信息不存在");
					}
					if(recordResult.getStartTime().after(nowDate)){
						return ApiResult.createErrorReuslt("比赛还未开奖");
					}
				}
				
				StakeCountInfoVo stakeCountInfoVo = StakeVoUtil.getStakeCountInfo(stakeVo.getStakeVo());
				resultVo.setTotalStakeAmount(stakeCountInfoVo.getTotalStakeAmount().setScale(0));
				
				BigDecimal totalIncomeAmount = new CalculationHandle(calcRate).dealCalculation(RecordResultPOUtil.convertResult(recordResult), stakeVo.getStakeVo().getAppointStakeList(), stakeVo.getStakeVo().getCommonStake(), stakeVo.getStakeVo().getRankingStakeList());
				resultVo.setTotalIncomeAmount(totalIncomeAmount.setScale(0));
				
				resultVo.setTotalDeficitAmount(resultVo.getTotalIncomeAmount().subtract(resultVo.getTotalStakeAmount()).setScale(0));
				result.add(resultVo);
			}
			
			
		}
		
		return ApiResult.createSuccessReuslt(result);
	}
	
}
