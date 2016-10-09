package com.racing.controller.manager;

import com.racing.constant.UserConstant;
import com.racing.controller.vo.UserAppPointDealCommentVO;
import com.racing.controller.vo.UserVo;
import com.racing.service.manager.UserPointsAppRecordService;
import com.racing.service.user.UserAccountRecordService;
import com.racing.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/manager")
public class ManagerUserPointsController {
    @Autowired
    private UserAccountRecordService userAccountRecordService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserPointsAppRecordService userPointsAppRecordService;

    @ApiOperation("总盘-积分-分盘申请上下分列表")
    @RequestMapping(value = "/pointsapp/status", method = RequestMethod.GET)
    public Object selectPointsApp(@RequestParam(required = false, defaultValue = "UNTREATED") String status,
                                  @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userPointsAppRecordService.selectPoints(null, null, status, page);
    }

    /**
     * UNTREATED/AUDIT/REJECT/CANCEL 待处理/批准/拒绝/取消
     *
     * @param id
     */
    @ApiOperation("总盘-积分-分盘申请上下分列表-批准")
    @RequestMapping(value = "/pointsapp/{id}/status/audit", method = RequestMethod.PUT)
    public Object toUserPointAudit(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
        return userPointsAppRecordService.updateStatus(id, UserConstant.POINTS_APP_STATUS_AUDIT, commentVO.getComments());
    }

    @ApiOperation("总盘-积分-分盘申请上下分列表-拒绝")
    @RequestMapping(value = "/pointsapp/{id}/status/reject", method = RequestMethod.PUT)
    public Object toUserPointReject(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
        return userPointsAppRecordService.updateStatus(id, UserConstant.POINTS_APP_STATUS_REJECT, commentVO.getComments());
    }

    @ApiOperation("总盘-积分-分盘申请上下分列表-取消")
    @RequestMapping(value = "/pointsapp/{id}/status/cancel", method = RequestMethod.PUT)
    public Object toUserPointUntreated(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
        return userPointsAppRecordService.updateStatus(id, UserConstant.POINTS_APP_STATUS_CANCEL, commentVO.getComments());
    }

    @ApiOperation("总盘-积分-分盘积分列表")
    @RequestMapping(value = "/user/points", method = RequestMethod.GET)
    public Object getUserPointsInfoList(@RequestParam(required = false) String nickName,
                                        @RequestParam(required = false) Integer userId,
                                        @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userService.getUserPointsInfoList(nickName, userId, page);
    }

    @ApiOperation("总盘-积分-分盘积分列表-加积分")
    @RequestMapping(value = "/add/points/user/{userId}", method = RequestMethod.PUT)
    public Object managerAddPointsToUser(@PathVariable Integer userId,
                                         @RequestBody UserVo user) {
        return userService.updatePoint(userId, user.getPoints());
    }

    @ApiOperation("总盘-积分-分盘积分列表-减少积分")
    @RequestMapping(value = "/subtract/points/user/{userId}", method = RequestMethod.PUT)
    public Object managerSubtractPointsToUser(@PathVariable Integer userId,
                                              @RequestBody UserVo user) {
        return userService.updatePoint(userId, user.getPoints().subtract(user.getPoints().multiply(new BigDecimal(2))));
    }

    @ApiOperation(value = "总盘-积分-分盘积分列表-查看积分详情")
    @RequestMapping(value = "/user/{userId}/account/record", method = RequestMethod.GET)
    public Object selectByUserId(@PathVariable Integer userId,
                                 @RequestParam(required = false, defaultValue = "1") Integer page) {
        return userAccountRecordService.selectByUserIdOrState(userId, null, page);
    }
}
