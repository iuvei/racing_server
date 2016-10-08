package com.racing.controller.manager;

import com.racing.service.manager.TotalDayCountIncomeService;
import com.racing.service.manager.TotalRacingIncomeService;
import com.racing.service.manager.UserDayCountIncomeService;
import com.racing.service.manager.UserRacingIncomeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/manger")
public class ManagerIncomeController {

    @Autowired
    TotalDayCountIncomeService totalDayCountIncomeService;
    @Autowired
    TotalRacingIncomeService totalRacingIncomeService;
    @Autowired
    private UserDayCountIncomeService userDayCountIncomeService;
    @Autowired
    private UserRacingIncomeService userRacingIncomeService;

    /**
     * 总盘盈亏报表按日期查询
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    @ApiOperation("总盘-盈亏报表-总体盈亏报表-按日期")
    @RequestMapping(value = "/income/day", method = RequestMethod.GET)
    public Object selectByDate(@RequestParam(required = false) Date startDate,
                               @RequestParam(required = false) Date endDate,
                               @RequestParam(required = false) Integer page) {
        return totalDayCountIncomeService.selectByDate(startDate, endDate, page);
    }

    /**
     * 总盘盈亏报表按期号查询
     * @param startDate
     * @param endDate
     * @param racingNum
     * @param page
     * @return
     */
    @ApiOperation("总盘-盈亏报表-总体盈亏报表-按期号")
    @RequestMapping(value = "/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@RequestParam(required = false) Date startDate,
                                 @RequestParam(required = false) Date endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        return totalRacingIncomeService.selectByRacingNum(startDate, endDate, racingNum, page);
    }

    /**
     * 分盘盈亏报表按日期查询
     *
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    @ApiOperation("总盘-盈亏报表-分盘盈亏报表-按日期")
    @RequestMapping(value = "/user/{userId}/income/day", method = RequestMethod.GET)
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
    @ApiOperation("总盘-盈亏报表-分盘盈亏报表-按期号")
    @RequestMapping(value = "/user/{userId}/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@PathVariable Integer userId,
                                 @RequestParam(required = false) Date startDate,
                                 @RequestParam(required = false) Date endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        return userRacingIncomeService.selectByRacingNum(userId, startDate, endDate, racingNum, page);
    }
}
