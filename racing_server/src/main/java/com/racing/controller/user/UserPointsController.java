package com.racing.controller.user;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.UserAppPointDealCommentVO;
import com.racing.controller.vo.UserPointsAppRecordVo;
import com.racing.service.manager.UserPointsAppRecordService;
import com.racing.service.user.UserAccountRecordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserPointsController {
    @Autowired
    UserAccountRecordService userAccountRecordService;
    @Autowired
    UserPointsAppRecordService userPointsAppRecordService;

    @ApiOperation("分盘-积分-申请积分-新增")
    @RequestMapping(value = "/{userId}/points", method = RequestMethod.POST)
    public Object addPoints(@PathVariable Integer userId,
                            @RequestBody UserPointsAppRecordVo userPointsAppRecordVo) {
        return userPointsAppRecordService.addUserPointsAppRecord(userId, userPointsAppRecordVo.getAppPoints(),
            userPointsAppRecordVo.getAppComment());
    }

    @ApiOperation("分盘-积分-申请积分-搜索")
    @RequestMapping(value = "/{userId}/points", method = RequestMethod.GET)
    public Object selectPointsApp(@PathVariable Integer userId,
                                  @RequestParam(required = false, defaultValue = "UNTREATED") String status,
                                  @RequestParam(required = false) Date startDate,
                                  @RequestParam(required = false) Date endDate,
                                  @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userPointsAppRecordService.userSelectPointsByDate(
            userId, status, startDate, endDate, page);
    }

    @ApiOperation("分盘-积分-申请积分-取消")
    @RequestMapping(value = "/{userId}/points/status/cancel", method = RequestMethod.PUT)
    public Object toUserPointUntreated(@PathVariable Integer userId, @RequestBody UserAppPointDealCommentVO commentVO) {
        return userPointsAppRecordService.updateStatus(userId, UserConstant.POINTS_APP_STATUS_CANCEL, commentVO.getComments());
    }

    @ApiOperation("分盘积分管理操作记录")
    @RequestMapping(value = "/{userId}/state", method = RequestMethod.GET)
    public Object selectByState(@ApiParam(required = true, name = "userId", value = "用户id")
                                @PathVariable Integer userId,
                                @ApiParam(required = false, name = "status", value = "操作类型")
                                @RequestParam(required = false) String status,
                                @ApiParam(required = false, name = "page")
                                @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userAccountRecordService.selectByUserIdOrState(userId, status, page);
    }
}