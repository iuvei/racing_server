package com.racing.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResutl;
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
    return ApiResutl.createSuccessReuslt(userService.selectUser(nickName, id, page));
  }

  @RequestMapping(value = "/user/points", method = RequestMethod.GET)
  public Object selectPoints(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer userId, @RequestParam(required = false) String status,
      @RequestParam(required = false) Integer page) {
    return ApiResutl.createSuccessReuslt(userPointsAppRecordService.selectPoints(nickName, userId, status, page));
  }

  /**
   * untreated/audit/reject/cancel 待处理/批注/拒绝/取消
   *
   * @param id
   */
  @RequestMapping(value = "/user/point/{id}/status/audit", method = RequestMethod.PUT)
  public Object toUserPointAudit(@PathVariable Integer id) {
    userPointsAppRecordService.updateStatus(id, "audit");
    return ApiResutl.createSuccessReuslt();
  }

  @RequestMapping(value = "/user/point/{id}/status/reject", method = RequestMethod.PUT)
  public Object toUserPointReject(@PathVariable Integer id) {
    userPointsAppRecordService.updateStatus(id, "reject");
    return ApiResutl.createSuccessReuslt();
  }

  @RequestMapping(value = "/user/point/{id}/status/cancel", method = RequestMethod.PUT)
  public Object toUserPointUntreated(@PathVariable Integer id) {
    userPointsAppRecordService.updateStatus(id, "cancel");
    return ApiResutl.createSuccessReuslt();
  }

  @RequestMapping(value = "/user/{userId}/points", method = RequestMethod.GET)
  public Object selectPointsByUserId(@PathVariable Integer userId, @RequestParam(required = false) Integer page) {
    return ApiResutl.createSuccessReuslt(userPointsAppRecordService.selectPointsByUserId(userId, page));
  }
}
