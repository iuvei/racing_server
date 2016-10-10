package com.racing.controller.user;

import com.racing.service.manager.UserDayCountIncomeService;
import com.racing.service.manager.UserRacingIncomeService;
import com.racing.service.member.MembersAccountRecordService;
import com.racing.service.member.MembersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserMembersController {
    @Autowired
    MembersService membersService;
    @Autowired
    MembersAccountRecordService membersAccountRecordService;
    @Autowired
    UserDayCountIncomeService userDayCountIncomeService;
    @Autowired
    UserRacingIncomeService userRacingIncomeService;

    @ApiOperation("分盘-玩家管理-玩家列表-搜索")
    @RequestMapping(value = "/{userId}/members", method = RequestMethod.GET)
    public Object select(@PathVariable Integer userId,
                         @RequestParam(required = false) String nickname,
                         @RequestParam(required = false, defaultValue = "1") Integer page) {
        return membersService.select(userId, nickname, page);
    }

    @ApiOperation("分盘-玩家管理-玩家列表-查看详情")
    @RequestMapping(value = "/members/{memberId}", method = RequestMethod.GET)
    public Object selectById(@PathVariable Integer memberId,
                             @RequestParam(required = false) String startDate,
                             @RequestParam(required = false) String endDate,
                             @RequestParam(required = false) String type,
                             @RequestParam(required = false, defaultValue = "1") Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return membersAccountRecordService.select(memberId, sDate, eDate, type, page);
    }

    @ApiOperation("分盘-玩家管理-玩家报表-按日期")
    @RequestMapping(value = "/{userId}/members/income/day", method = RequestMethod.GET)
    public Object selectByDate(@PathVariable Integer userId,
                               @RequestParam(required = false) String startDate,
                               @RequestParam(required = false) String endDate,
                               @RequestParam(required = false) Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userDayCountIncomeService.selectByDate(userId, sDate, eDate, page);
    }

    @ApiOperation("分盘-玩家管理-玩家报表-按日期")
    @RequestMapping(value = "/{userId}/members/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@PathVariable Integer userId,
                                 @RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) Integer page) {
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userRacingIncomeService.selectByRacingNum(userId, sDate, eDate, racingNum, page);
    }
}
