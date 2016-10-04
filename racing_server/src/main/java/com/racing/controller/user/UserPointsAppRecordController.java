package com.racing.controller.user;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.UserAppPointDealCommentVO;
import com.racing.controller.vo.UserPointsAppRecordVo;
import com.racing.service.manager.UserPointsAppRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserPointsAppRecordController {

    @Autowired
    UserPointsAppRecordService userPointsAppRecordService;

    /**
     * 分盘管理积分管理申请积分搜索api
     */
    @RequestMapping(value = "/{userId}/pointsapp", method = RequestMethod.GET)
    public Object selectPointsApp(@PathVariable Integer userId,
                                  @RequestParam(required = false) String status,
                                  @RequestParam(required = false) Date startDate,
                                  @RequestParam(required = false) Date endDate,
                                  @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userPointsAppRecordService.userSelectPointsByDate(
            userId, status, startDate, endDate, page);
    }

    /**
     * 分盘取消上分
     */
    @RequestMapping(value = "/{userId}/pointsapp/status/cancel", method = RequestMethod.PUT)
    public Object toUserPointUntreated(@PathVariable Integer userId, @RequestBody UserAppPointDealCommentVO commentVO) {
        return userPointsAppRecordService.updateStatus(userId, UserConstant.POINTS_APP_STATUS_CANCEL, commentVO.getComments());
    }

    /**
     * 新增积分申请
     */
    @RequestMapping(value = "/{userId}/pointsapp", method = RequestMethod.POST)
    public Object addUserPointsAppRecord(@PathVariable Integer userId,
                                         @RequestBody UserPointsAppRecordVo userPointsAppRecordVo) {
        return userPointsAppRecordService.addUserPointsAppRecord(userId, userPointsAppRecordVo.getAppPoints(), userPointsAppRecordVo.getAppComment());
    }
}
