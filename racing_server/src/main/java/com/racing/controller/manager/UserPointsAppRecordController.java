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

@RestController
@RequestMapping("/manager/user")
public class UserPointsAppRecordController {

  @Autowired
  UserPointsAppRecordService userPointsAppRecordService;

  /**
   * 根据分盘用户昵称和编号以及申请状态查询申请列表
   * 
   * @param nickName
   * @param userId
   * @param status
   * @param page
   * @return
   */
  @RequestMapping(value = "/pointsapp", method = RequestMethod.GET)
  public Object selectPointsApp(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer userId, @RequestParam(required = false) String status,
      @RequestParam(required = false) Integer page) {
    return ApiResult.createSuccessReuslt(userPointsAppRecordService.selectPoints(nickName, userId, status, page));
  }

  /**
   * UNTREATED/AUDIT/REJECT/CANCEL 待处理/批准/拒绝/取消
   *
   * @param id
   */
  @RequestMapping(value = "/pointsapp/{id}/status/audit", method = RequestMethod.PUT)
  public Object toUserPointAudit(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
    return userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.AUDIT, commentVO.getComments());
  }

  @RequestMapping(value = "/pointsapp/{id}/status/reject", method = RequestMethod.PUT)
  public Object toUserPointReject(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
    return userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.AUDIT, commentVO.getComments());
  }

  @RequestMapping(value = "/pointsapp/{id}/status/cancel", method = RequestMethod.PUT)
  public Object toUserPointUntreated(@PathVariable Integer id, @RequestBody UserAppPointDealCommentVO commentVO) {
    return userPointsAppRecordService.updateStatus(id, UserPointsAppStatusConstant.AUDIT, commentVO.getComments());
  }

  /**
   * 通过用户ID获取用户的积分申请列表
   * 
   * @param userId
   * @param page
   * @return
   */
  @RequestMapping(value = "/{userId}/apppoints", method = RequestMethod.GET)
  public Object selectPointsByUserId(@PathVariable Integer userId, @RequestParam(required = false) Integer page) {
    return ApiResult.createSuccessReuslt(userPointsAppRecordService.selectPointsByUserId(userId, page));
  }

}
