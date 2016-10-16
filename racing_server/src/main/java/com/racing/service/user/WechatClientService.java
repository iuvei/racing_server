package com.racing.service.user;

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
        if(compareRate(wechatClient.getAppointStakeRate(),new BigDecimal("9.7"))&&
            compareRate(wechatClient.getRankingStakeRate(),new BigDecimal("1.94"))&&
            compareRate(wechatClient.getUpOrDownRate(),new BigDecimal("1.94"))&&
            compareRate(wechatClient.getFirstAddSecondOddRate(),new BigDecimal("1.63"))&&
            compareRate(wechatClient.getFirstAddSecondEvenRate(),new BigDecimal("2"))&&
            compareRate(wechatClient.getFirstAddSecondBigRate(),new BigDecimal("2"))&&
            compareRate(wechatClient.getFirstAddSecondSmallRate(),new BigDecimal("1.63"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint3StakeRate(),new BigDecimal("41"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint4StakeRate(),new BigDecimal("41"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint5StakeRate(),new BigDecimal("21"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint6StakeRate(),new BigDecimal("21"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint7StakeRate(),new BigDecimal("12"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint8StakeRate(),new BigDecimal("12"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint9StakeRate(),new BigDecimal("10.3"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint10StakeRate(),new BigDecimal("10.3"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint11StakeRate(),new BigDecimal("8.3"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint12StakeRate(),new BigDecimal("10.3"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint13StakeRate(),new BigDecimal("10.3"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint14StakeRate(),new BigDecimal("12"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint15StakeRate(),new BigDecimal("12"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint16StakeRate(),new BigDecimal("21"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint17StakeRate(),new BigDecimal("21"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint18StakeRate(),new BigDecimal("41"))&&
            compareRate(wechatClient.getFirstAddSecondAppoint19StakeRate(),new BigDecimal("41"))) {
            int result = wechatClientRepo.update(wechatClient);
            if (result == 1) {
                return ApiResult.createSuccessReuslt();
            }
        }
        return ApiResult.createErrorReuslt("更新失败,请检查你的赔率是否超过了标准赔率");
    }
}
