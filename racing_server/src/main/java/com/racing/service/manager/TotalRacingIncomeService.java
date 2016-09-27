package com.racing.service.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.TotalRacingIncome;
import com.racing.model.repo.TotalRacingIncomeRepo;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TotalRacingIncomeService {
    @Autowired
    TotalRacingIncomeRepo totalRacingIncomeRepo;

    public Object selectByRacingNum(Date startDate, Date endDate,
                                    String racingNum, Integer page) {
        if (null == page) {
            page = 1;
        }
        List<TotalRacingIncome> list = totalRacingIncomeRepo.selectByRacingNum(
            startDate, endDate, racingNum,PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(
            list, page, 15, totalRacingIncomeRepo.selectCountByRacing(startDate, endDate, racingNum));
    }
}
