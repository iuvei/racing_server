package com.racing.controller.user;

import com.racing.service.manager.UserDayCountIncomeService;
import com.racing.service.manager.UserRacingIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserIncomeController {

    @Autowired
    UserDayCountIncomeService userDayCountIncomeService;
    @Autowired
    UserRacingIncomeService userRacingIncomeService;

    /**
     * 分盘盈亏报表按日期查询
     *
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    @RequestMapping(value = "/{userId}/income/day", method = RequestMethod.GET)
    public Object selectByDate(@PathVariable Integer userId,
                               @RequestParam(required = false) Date startDate,
                               @RequestParam(required = false) Date endDate,
                               @RequestParam(required = false) Integer page) {
        return userDayCountIncomeService.selectByDate(userId, startDate, endDate, page);
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
    @RequestMapping(value = "/{userId}/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@PathVariable Integer userId,
                                 @RequestParam(required = false) Date startDate,
                                 @RequestParam(required = false) Date endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        return userRacingIncomeService.selectByRacingNum(userId, startDate, endDate, racingNum, page);
    }
}
