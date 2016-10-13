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
@RequestMapping("/manager")
public class ManagerBetController {

    @Autowired
    TotalDayCountIncomeService totalDayCountIncomeService;
    @Autowired
    TotalRacingIncomeService totalRacingIncomeService;
    @Autowired
    private UserDayCountIncomeService userDayCountIncomeService;
    @Autowired
    private UserRacingIncomeService userRacingIncomeService;

    @ApiOperation("总盘-押注报表-总体押注报表-按日期")
    @RequestMapping(value = "/bat/day", method = RequestMethod.GET)
    public Object selectByDate(@RequestParam(required = false) String startDate,
                               @RequestParam(required = false) String endDate,
                               @RequestParam(required = false,defaultValue = "1") Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return totalDayCountIncomeService.selectByDate(sDate, eDate, page);
    }

    @ApiOperation("总盘-押注报表-总体押注报表-按期号")
    @RequestMapping(value = "/bat/racing", method = RequestMethod.GET)
    public Object selectByRacing(@RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false,defaultValue = "1") Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return totalRacingIncomeService.selectByRacingNum(sDate, eDate, racingNum, page);
    }

    @ApiOperation("总盘-押注报表-分盘押注报表-按日期")
    @RequestMapping(value = "/user/{userId}/bat/day", method = RequestMethod.GET)
    public Object selectByDate(@PathVariable Integer userId,
                               @RequestParam(required = false) String startDate,
                               @RequestParam(required = false) String endDate,
                               @RequestParam(required = false,defaultValue = "1") Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userDayCountIncomeService.selectByDate(userId, sDate, eDate, page);
    }

    @ApiOperation("总盘-押注报表-分盘押注报表-按期号")
    @RequestMapping(value = "/user/{userId}/bat/racing", method = RequestMethod.GET)
    public Object selectByRacing(@PathVariable Integer userId,
                                 @RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false,defaultValue = "1") Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userRacingIncomeService.selectByRacingNum(userId, sDate, eDate, racingNum, page);
    }
}
