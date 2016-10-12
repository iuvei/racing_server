package com.racing.controller.user;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.UserAppPointDealCommentVO;
import com.racing.controller.vo.UserPointsAppRecordVo;
import com.racing.service.manager.UserPointsAppRecordService;
import com.racing.service.user.UserAccountRecordService;
import com.racing.util.LoginStatusSaveUtil;
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
    @RequestMapping(value = "/points", method = RequestMethod.POST)
    public Object addPoints(@RequestBody UserPointsAppRecordVo userPointsAppRecordVo) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userPointsAppRecordService.addUserPointsAppRecord(userId, userPointsAppRecordVo.getAppPoints(),
            userPointsAppRecordVo.getAppComment());
    }

    @ApiOperation("分盘-积分-申请积分-搜索")
    @RequestMapping(value = "/points", method = RequestMethod.GET)
    public Object selectPointsApp(@RequestParam(required = false, defaultValue = "UNTREATED") String status,
                                  @RequestParam(required = false) String startDate,
                                  @RequestParam(required = false) String endDate,
                                  @RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        Date sDate = null;
        Date eDate = null;
        if (startDate != "" && endDate != "") {
            sDate = new Date(Long.valueOf(startDate));
            eDate = new Date(Long.valueOf(endDate));
        }
        return userPointsAppRecordService.userSelectPointsByDate(
            userId, status, sDate, eDate, page);
    }

    @ApiOperation("分盘-积分-申请积分-取消")
    @RequestMapping(value = "/points/{pointsAppRecordId}/status/cancel", method = RequestMethod.PUT)
    public Object toUserPointUntreated(@PathVariable Integer pointsAppRecordId,
                                       @RequestBody UserAppPointDealCommentVO commentVO) {
        return userPointsAppRecordService.updateStatus(pointsAppRecordId, UserConstant.POINTS_APP_STATUS_CANCEL, commentVO.getComments());
    }

    @ApiOperation("分盘积分管理操作记录")
    @RequestMapping(value = "/state", method = RequestMethod.GET)
    public Object selectByState(@ApiParam(required = false, name = "status", value = "操作类型")
                                @RequestParam(required = false) String status,
                                @ApiParam(required = false, name = "page")
                                @RequestParam(required = false, defaultValue = "1") Integer page) {
        Integer userId = LoginStatusSaveUtil.getUserWebId();
        return userAccountRecordService.selectByUserIdOrState(userId, status, page);
    }
}