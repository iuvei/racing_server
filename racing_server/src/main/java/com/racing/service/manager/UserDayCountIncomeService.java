package com.racing.service.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.model.po.UserDayCountIncome;
import com.racing.model.repo.UserDayCountIncomeRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.DateUtil;
import com.racing.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserDayCountIncomeService {
    @Autowired
    UserDayCountIncomeRepo userDayCountIncomeRepo;
    @Autowired
    UserRepo userRepo;

    public Object selectByDate(Integer userId, Date startDate, Date endDate, Integer page) {
        if (null == userRepo.selectById(userId)) {
            return ApiResult.createErrorReuslt("分盘不存在");
        }
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
        List<UserDayCountIncome> list = userDayCountIncomeRepo.selectByDate(
            userId, startDateNew, endDateNew, PageUtil.createPage(page, 15));
        return ApiResult.createSuccessReuslt(
            list, page, 15, userDayCountIncomeRepo.selectCountByDate(userId, startDateNew, endDateNew));
    }
}
