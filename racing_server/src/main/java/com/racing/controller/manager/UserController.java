package com.racing.controller.manager;

import com.racing.model.po.User;
import com.racing.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/manager")
public class UserController {
  @Autowired
  UserService userService;

  /**
   * 获取全部用户的基本信息和机器人状态信息
   *
   * @return
   */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public Object selectUser(@RequestParam(required = false) String nickName, @RequestParam(required = false) Integer userId) {
    return userService.getUserList(nickName, userId);
  }

  /**
   * 新增用户
   * @param user
   */
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public void addUser(@RequestBody User user){
  }

  /**
   * 修改用户信息
   */
  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  public void updateUser(){

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
     * @param userId
     * @param points
     * @return
     */
    @RequestMapping(value = "/add/points/user/{userId}", method = RequestMethod.PUT)
    public Object managerAddPointsToUser(@PathVariable Integer userId,
                                         @RequestBody BigDecimal points) {
        return userService.updatePoint(userId, points);
    }

    /**
     * 总盘给用户减少积分
     * @param userId
     * @param points
     * @return
     */
    @RequestMapping(value = "/subtract/points/user/{userId}", method = RequestMethod.PUT)
    public Object managerSubtractPointsToUser(@PathVariable Integer userId,
                                         @RequestBody BigDecimal points) {
        return userService.updatePoint(userId,points);
    }
}
