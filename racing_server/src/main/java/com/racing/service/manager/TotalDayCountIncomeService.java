package com.racing.service.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.TotalDayCountIncome;
import com.racing.model.repo.TotalDayCountIncomeRepo;
import com.racing.util.DateUtil;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TotalDayCountIncomeService {
    @Autowired
    TotalDayCountIncomeRepo totalDayCountIncomeRepo;

    public Object selectByDate(Date startDate, Date endDate, Integer page) {
        if (null == page) {
            page = 1;
        }
        String startDateNew = "";
        String endDateNew = "";
        if (startDate != null) {
            startDateNew = DateUtil.parseToString(startDate, DateUtil.DateFormat_yyyy_MM_dd);
        }
        if (endDate != null) {
            endDateNew = DateUtil.parseToString(endDate, DateUtil.DateFormat_yyyy_MM_dd);
        }
        List<TotalDayCountIncome> list = totalDayCountIncomeRepo.selectByDate(
            startDateNew, endDateNew, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(
            list, page, 15, totalDayCountIncomeRepo.selectCountByDate(startDateNew, endDateNew));
    }
}
