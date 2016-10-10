package com.racing.controller.user;

import com.racing.service.manager.UserDayCountIncomeService;
import com.racing.service.manager.UserRacingIncomeService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserBetController {
    @Autowired
    private UserDayCountIncomeService userDayCountIncomeService;
    @Autowired
    private UserRacingIncomeService userRacingIncomeService;

    @ApiOperation("分盘-押注报表-分盘押注报表-按日期")
    @RequestMapping(value = "/bat/day", method = RequestMethod.GET)
    public Object selectByDate(@RequestParam(required = false) Date startDate,
                               @RequestParam(required = false) Date endDate,
                               @RequestParam(required = false) Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userDayCountIncomeService.selectByDate(userId, startDate, endDate, page);
    }

    @ApiOperation("分盘-押注报表-分盘押注报表-按期号")
    @RequestMapping(value = "/bat/racing", method = RequestMethod.GET)
    public Object selectByRacing(@RequestParam(required = false) Date startDate,
                                 @RequestParam(required = false) Date endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userRacingIncomeService.selectByRacingNum(userId, startDate, endDate, racingNum, page);
    }
}
