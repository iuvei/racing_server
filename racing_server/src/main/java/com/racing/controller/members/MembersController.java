package com.racing.controller.members;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MembersVo;
import com.racing.service.member.MembersAccountRecordService;
import com.racing.service.member.MembersService;
import com.racing.service.member.MembersStakeService;
import com.racing.service.user.UserService;
import com.racing.util.LoginStatusSaveUtil;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController {
    @Autowired
    MembersService membersService;
    @Autowired
    MembersAccountRecordService membersAccountRecordService;
    @Autowired
    UserService userService;
    @Autowired
    MembersStakeService membersStakeService;

    @ApiOperation("客户端-查询积分")
    @RequestMapping(value = "/point", method = RequestMethod.GET)
    public Object selectPoint(@RequestParam(required = false) String wechatSn,
                              @RequestParam(required = false) String nickName) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        if (userId == null) {
            return ApiResult.createErrorReuslt("先登录");
        }
        return membersService.selectPoint(userId, wechatSn, nickName);
    }

    @ApiOperation("客户端-查询积分-批量")
    @RequestMapping(value = "/point/batch", method = RequestMethod.GET)
    public Object selectPointByBatch(@RequestParam(required = false) String wechatSns) {
    	Integer userId = LoginStatusSaveUtil.getUserClientId();
    	List<String> wechatSn = new ArrayList<String>();
        if(StringUtil.isNotEmpty(wechatSns)){
        	wechatSn = Arrays.asList(wechatSns.split(","));
        }
    	return membersService.selctPointByBatch(userId, wechatSn);
    }

    @ApiOperation("客户端-查询积分-全部member")
    @RequestMapping(value = "/point/all", method = RequestMethod.GET)
    public Object selectPointByAll() {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        return membersService.selctPointByAll(userId);
    }

    @ApiOperation("客户端-查询积分-上分")
    @RequestMapping(value = "/point/add", method = RequestMethod.PUT)
    public Object addPoint(@RequestBody MembersVo membersVo) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        if (membersVo.getWechatSn() == null && userId == null) {
            return ApiResult.createErrorReuslt("先登录");
        }
        return membersService.updatePoint(userId, membersVo.getWechatSn(),
            membersVo.getNickName(), membersVo.getUpdatePoints(), "ADD");
    }

    @ApiOperation("客户端-查询积分-下分")
    @RequestMapping(value = "/point/subtract", method = RequestMethod.PUT)
    public Object subtractPoint(@RequestBody MembersVo membersVo) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        if (membersVo.getWechatSn() == null && userId == null) {
            return ApiResult.createErrorReuslt("先登录");
        }
        return membersService.updatePoint(userId, membersVo.getWechatSn(),
            membersVo.getNickName(), membersVo.getUpdatePoints().negate(), "SUBTRACT");
    }

    @ApiOperation("客户端-查询积分记录")
    @RequestMapping(value = "/point/record", method = RequestMethod.GET)
    public Object selectMembersAccountRecord(@RequestParam String wechatSn,
                                             @RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        if (wechatSn == null && userId == null) {
            return ApiResult.createErrorReuslt("先登录");
        }
        return membersService.selectMembersAccountRecord(userId, wechatSn, page);
    }

    @ApiOperation("客户端-members-开奖结果")
    @RequestMapping(value = "/stake", method = RequestMethod.GET)
    public Object selectRecordResult(@RequestParam String wechatSns,
                                     @RequestParam String racingNum) {
        Integer userId = LoginStatusSaveUtil.getUserClientId();
        if (userId == null) {
            return ApiResult.createErrorReuslt("先登录");
        }
        List<String> wechatSn = new ArrayList<String>();
        if(StringUtil.isNotEmpty(wechatSns)){
        	wechatSn = Arrays.asList(wechatSns.split(","));
        }
        
        return membersStakeService.selectByWechatSn(userId, wechatSn, racingNum);
    }
}
