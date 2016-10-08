package com.racing.controller.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.service.manager.UserPointsAppRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/user")
public class ManagerUserPointsAppRecordController {

  @Autowired
  private UserPointsAppRecordService userPointsAppRecordService;

  @ApiOperation("根据分盘用户昵称和编号以及申请状态查询申请列表")
  @RequestMapping(value = "/pointsapp", method = RequestMethod.GET)
  public Object selectPointsApp(@RequestParam(required = false) String nickName,
                                @RequestParam(required = false) Integer userId,
                                @RequestParam(required = false) String status,
      @RequestParam(required = false, defaultValue = "1") Integer page) {
    return userPointsAppRecordService.selectPoints(nickName, userId, status, page);
  }

  /**
   * 通过用户ID获取用户的积分申请列表
   * 
   * @param userId
   * @param page
   * @return
   */
  @RequestMapping(value = "/{userId}/pointsapp", method = RequestMethod.GET)
  public Object selectPointsByUserId(@PathVariable Integer userId,
                                     @RequestParam(required = false, defaultValue = "1") Integer page) {
    return ApiResult.createSuccessReuslt(userPointsAppRecordService.selectPointsByUserId(userId, page));
  }
}
