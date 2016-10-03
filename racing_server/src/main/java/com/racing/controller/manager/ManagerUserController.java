package com.racing.controller.manager;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.service.user.UserService;

@RestController
@RequestMapping("/manager")
public class ManagerUserController {
  @Autowired
  UserService userService;

  /**
   * 获取全部用户的基本信息和机器人状态信息
   *
   * @return
   */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public Object selectUser() {
    return userService.getUserList();
  }

  /**
   * 新增用户
   */
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public Object addUser(@RequestBody String clientSn, @RequestBody Date clientExpireDate) {
    return userService.addUser(clientSn, clientExpireDate);
  }

  /**
   * 新增机器人,设置机器人时间
   */
  @RequestMapping(value = "/user/{userId}/robot", method = RequestMethod.POST)
  public Object addRobot(@PathVariable Integer userId, @RequestBody Date clientExpireDate) {
    return userService.addRobot(userId, clientExpireDate);
  }

  /**
   * 修改信息
   */
  @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
  public Object updateUserNickName(@PathVariable Integer userId, @RequestBody String nickName) {
    return userService.updateUserNickName(userId, nickName);
  }

  /**
   * 启用或者禁用用户
   */
  @RequestMapping(value = "/user/{userId}/isenable", method = RequestMethod.PUT)
  public Object updateUserIsEnable(@PathVariable Integer userId, @RequestBody boolean isEnable) {
    return userService.updateUserIsEnable(userId, isEnable);
  }

  /**
   * 启用或者禁用robot
   */
  @RequestMapping(value = "/user/{userId}/robot/isenable", method = RequestMethod.PUT)
  public Object updateRobotIsEnable(@PathVariable Integer userId, @RequestBody boolean isEnable) {
    return userService.updateRobotIsEnable(userId, isEnable);
  }

  /**
   * 删除用户
   */
  @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
  public Object delete(@PathVariable Integer userId) {
    return userService.delete(userId);
  }

  /**
   * 获取全部用户的ID、用户名、昵称信息列表，用于页面的select空间
   *
   * @return
   */
  @RequestMapping(value = "/user/idinfo", method = RequestMethod.GET)
  public Object selectUserIdInfo() {
    return userService.selectUserIdInfo();
  }

  /**
   * 根据分盘用户昵称和编号查询分盘积分情况列表
   *
   * @param nickName
   * @param userId
   * @param page
   * @return
   */
  @RequestMapping(value = "/user/points", method = RequestMethod.GET)
  public Object getUserPointsInfoList(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer userId,
      @RequestParam(required = false, defaultValue = "1") Integer page) {
    return userService.getUserPointsInfoList(nickName, userId, page);
  }

  /**
   * 总盘给用户添加积分
   *
   * @param userId
   * @param points
   * @return
   */
  @RequestMapping(value = "/add/points/user/{userId}", method = RequestMethod.PUT)
  public Object managerAddPointsToUser(@PathVariable Integer userId, @RequestBody BigDecimal points) {
    return userService.updatePoint(userId, points);
  }

  /**
   * 总盘给用户减少积分
   *
   * @param userId
   * @param points
   * @return
   */
  @RequestMapping(value = "/subtract/points/user/{userId}", method = RequestMethod.PUT)
  public Object managerSubtractPointsToUser(@PathVariable Integer userId, @RequestBody BigDecimal points) {
    return userService.updatePoint(userId, points);
  }
}
