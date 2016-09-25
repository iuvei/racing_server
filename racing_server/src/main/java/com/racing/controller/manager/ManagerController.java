package com.racing.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.constant.UserPointsAppStatusConstant;
import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.UserAppPointDealCommentVO;
import com.racing.service.manager.UserPointsAppRecordService;
import com.racing.service.user.UserService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
  @Autowired
  UserService userService;
  @Autowired
  UserPointsAppRecordService userPointsAppRecordService;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public Object selectUser(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer id, @RequestParam(required = false) Integer page) {
    return ApiResult.createSuccessReuslt(userService.selectUser(nickName, id, page));
  }

  @RequestMapping(value = "/user/points", method = RequestMethod.GET)
  public Object selectPoints(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer userId, @RequestParam(required = false) String status,
      @RequestParam(required = false) Integer page) {
    return ApiResult.createSuccessReuslt(userPointsAppRecordService.selectPoints(nickName, userId, status, page));
  }

  /**
   * untreated/audit/reject/cancel 待处理/批准/拒绝/取消
   *
   * @param id
   */
  @RequestMapping(value = "/user/apppoints/{id}/status/audit", method = RequestMethod.PUT)
  public Object toUserPointAudit(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
    return userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.AUDIT, commentVO.getComments());
  }

  @RequestMapping(value = "/user/apppoints/{id}/status/reject", method = RequestMethod.PUT)
  public Object toUserPointReject(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
    userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.REJECT, commentVO.getComments());
    return userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.AUDIT, commentVO.getComments());
  }

  @RequestMapping(value = "/user/apppoints/{id}/status/cancel", method = RequestMethod.PUT)
  public Object toUserPointUntreated(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
    userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.CANCEL, commentVO.getComments());
    return userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.AUDIT, commentVO.getComments());
  }

  @RequestMapping(value = "/user/{userId}/apppoints", method = RequestMethod.GET)
  public Object selectPointsByUserId(@PathVariable Integer userId, @RequestParam(required = false) Integer page) {
    return ApiResult.createSuccessReuslt(userPointsAppRecordService.selectPointsByUserId(userId, page));
  }
}
