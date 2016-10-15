package com.racing.controller.user;

import com.racing.controller.vo.ApiResult;
import com.racing.service.manager.UserDayCountIncomeService;
import com.racing.service.manager.UserRacingIncomeService;
import com.racing.service.stake.RecordResultService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserIncomeController {

    @Autowired
    UserDayCountIncomeService userDayCountIncomeService;
    @Autowired
    UserRacingIncomeService userRacingIncomeService;
    @Autowired
    RecordResultService recordResultService;

    /**
     * 分盘盈亏报表按日期查询
     *
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    @ApiOperation("分盘-盈亏报表-分盘盈亏报表-按日期")
    @RequestMapping(value = "/income/day", method = RequestMethod.GET)
    public Object selectByDate(@RequestParam(required = false) String startDate,
                               @RequestParam(required = false) String endDate,
                               @RequestParam(required = false) Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userDayCountIncomeService.selectByDate(userId, sDate, eDate, page);
    }

    /**
     * 分盘盈亏报表按期号查询
     *
     * @param startDate
     * @param endDate
     * @param racingNum
     * @param page
     * @return
     */
    @ApiOperation("分盘-盈亏报表-分盘盈亏报表-按期号")
    @RequestMapping(value = "/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userRacingIncomeService.selectByRacingNum(userId, sDate, eDate, racingNum, page);
    }

    @ApiOperation("轮询是否开奖")
    @RequestMapping(value = "/record/result", method = RequestMethod.GET)
    public Object selectByRacingNum(@RequestParam String racingNum) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        if (userId == null) {
            return ApiResult.createErrorReuslt("先登录");
        }
        return recordResultService.selectByRacingNum(userId, racingNum);
    }
}
