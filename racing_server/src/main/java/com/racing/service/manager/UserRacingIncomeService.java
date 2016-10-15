package com.racing.service.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.RecordResultVo;
import com.racing.model.po.RecordResult;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.UserRacingIncomeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.model.stake.util.RecordResultPOUtil;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserRacingIncomeService {
    @Autowired
    UserRacingIncomeRepo userRacingIncomeRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RecordResultRepo recordResultRepo;

    public Object selectByRacingNum(Integer userId, Date startDate, Date endDate,
                                    String racingNum, Integer page) {
        if (null == userRepo.selectById(userId)) {
            return ApiResult.createErrorReuslt("分盘不存在");
        }
        if (null == page) {
            page = 1;
        }
        List<UserRacingIncome> list = userRacingIncomeRepo.selectByRacingNum(
            userId, startDate, endDate, racingNum, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(
            list, page, 15, userRacingIncomeRepo.selectCountByRacing(userId, startDate, endDate, racingNum));
    }

    public Object selectByRacingNum(Integer userId, String racingNum) {
        if (null == userRepo.selectById(userId)) {
            return ApiResult.createErrorReuslt("分盘不存在");
        }
        List<UserRacingIncome> list = userRacingIncomeRepo.selectByRacingNum(userId, racingNum);

        if (list != null && list.get(0).getIsComplateStatistics()) {
            RecordResult recordResult = recordResultRepo.getRecordResultByRacingNum(racingNum);
            RecordResultVo resultVo = new RecordResultVo();
            resultVo.setRacingNum(recordResult.getRacingNum());
            resultVo.setResult(RecordResultPOUtil.convertResult(recordResult));
            resultVo.setFirstAddSecond(recordResult.getFirstAddSecond());
            resultVo.setIsFifthUp(recordResult.getIsFifthUp());
            resultVo.setIsFirstSecondBig(recordResult.getIsFirstSecondBig());
            resultVo.setIsFirstSecondOdd(recordResult.getIsFirstSecondOdd());
            resultVo.setIsFirstUp(recordResult.getIsFirstUp());
            resultVo.setIsFourthUp(recordResult.getIsFourthUp());
            resultVo.setIsSecondUp(recordResult.getIsSecondUp());
            resultVo.setIsThirdUp(recordResult.getIsThirdUp());
            return ApiResult.createSuccessReuslt(resultVo);
        }

        return ApiResult.createErrorReuslt("没开奖");
    }
}
