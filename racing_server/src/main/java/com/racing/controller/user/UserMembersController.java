package com.racing.controller.user;

import com.racing.controller.vo.ApiResult;
import com.racing.service.manager.UserDayCountIncomeService;
import com.racing.service.manager.UserRacingIncomeService;
import com.racing.service.member.MembersAccountRecordService;
import com.racing.service.member.MembersRacingIncomeService;
import com.racing.service.member.MembersService;
import com.racing.util.LoginStatusSaveUtil;
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
    @Autowired
    MembersRacingIncomeService membersRacingIncomeService;

    @ApiOperation("分盘-玩家管理-玩家列表-搜索")
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public Object select(@RequestParam(required = false) String nickname,
                         @RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
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
    @RequestMapping(value = "/members/income/day", method = RequestMethod.GET)
    public Object selectByDate(@RequestParam(required = false) String startDate,
                               @RequestParam(required = false) String endDate,
                               @RequestParam(required = false) String nickName,
                               @RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return membersRacingIncomeService.selectByDate(userId, nickName, sDate, eDate, page);
    }

    @ApiOperation("分盘-玩家管理-玩家报表-按日期")
    @RequestMapping(value = "/members/income/racing", method = RequestMethod.GET)
    public Object selectByRacing(@RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate,
                                 @RequestParam(required = false) String racingNum,
                                 @RequestParam(required = false) String nickName,
                                 @RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return membersRacingIncomeService.selectByRacingNum(userId, nickName, sDate, eDate, racingNum, page);
    }

    @ApiOperation("模糊查询昵称列表")
    @RequestMapping(value = "/members/nicname", method = RequestMethod.GET)
    public Object selectNicName(@RequestParam String nicName) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return membersService.selectNicName(userId, nicName);
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/members/{weChatSN}", method = RequestMethod.PUT)
    public Object delete(@PathVariable String weChatSN) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        if(userId == null){
        	userId = LoginStatusSaveUtil.getUserClientId();
        	if(userId == null){
        		return ApiResult.createNoLoginReuslt();
        	}
        }
        return membersService.delete(userId, weChatSN);
    }
}
