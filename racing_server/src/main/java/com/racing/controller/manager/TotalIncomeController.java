package com.racing.controller.manager;

import com.racing.service.manager.TotalDayCountIncomeService;
import com.racing.service.manager.TotalRacingIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/manger")
public class TotalIncomeController {

    @Autowired
    TotalDayCountIncomeService totalDayCountIncomeService;
    @Autowired
    TotalRacingIncomeService totalRacingIncomeService;

    /**
     * 总盘盈亏报表按日期查询
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
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
    @RequestMapping(value = "/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@RequestParam(required = false) Date startDate,
                                 @RequestParam(required = false) Date endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        return totalRacingIncomeService.selectByRacingNum(startDate, endDate, racingNum, page);
    }
}
