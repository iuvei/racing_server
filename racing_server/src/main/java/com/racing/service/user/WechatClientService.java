package com.racing.service.user;

import com.racing.constant.DefaultRacteConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.model.po.WechatClient;
import com.racing.model.repo.WechatClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WechatClientService {
    @Autowired
    WechatClientRepo wechatClientRepo;

    public Object select(Integer userId) {
        WechatClient wechatClient = wechatClientRepo.select(userId);
        return ApiResult.createSuccessReuslt(wechatClient);
    }

    private boolean compareRate(BigDecimal update,BigDecimal standard){
        if(update.compareTo(standard)<=0){
            return true;
        }
        return false;
    }

    public Object update(Integer userId, WechatClient wechatClient) {
        if(compareRate(wechatClient.getAppointStakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getAppointStakeRate())&&
            compareRate(wechatClient.getRankingStakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getRankingStakeRate())&&
            compareRate(wechatClient.getUpOrDownRate(),DefaultRacteConstant.totalDefaultCalcRate.getUpOrDownRate())&&
            compareRate(wechatClient.getFirstAddSecondOddRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondOddRate())&&
            compareRate(wechatClient.getFirstAddSecondEvenRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondEvenRate())&&
            compareRate(wechatClient.getFirstAddSecondBigRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondBigRate())&&
            compareRate(wechatClient.getFirstAddSecondSmallRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondSmallRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint3StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint3StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint4StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint4StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint5StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint5StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint6StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint6StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint7StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint7StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint8StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint8StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint9StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint9StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint10StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint10StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint11StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint11StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint12StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint12StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint13StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint13StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint14StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint14StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint15StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint15StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint16StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint16StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint17StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint17StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint18StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint18StakeRate())&&
            compareRate(wechatClient.getFirstAddSecondAppoint19StakeRate(),DefaultRacteConstant.totalDefaultCalcRate.getFirstAddSecondAppoint19StakeRate())) {
            int result = wechatClientRepo.update(wechatClient);
            if (result == 1) {
                return ApiResult.createSuccessReuslt();
            }
        }
        return ApiResult.createErrorReuslt("更新失败,请检查你的赔率是否超过了标准赔率");
    }
}
