package com.racing.service.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.UserRacingIncome;
import com.racing.model.repo.RecordResultRepo;
import com.racing.model.repo.UserRacingIncomeRepo;
import com.racing.model.repo.UserRepo;
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
        return ApiResult.createSuccessReuslt(list.get(0));
    }
}
