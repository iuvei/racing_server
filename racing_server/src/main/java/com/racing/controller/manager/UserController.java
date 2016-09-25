package com.racing.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.service.user.UserService;

@RestController
@RequestMapping("/manager")
public class UserController {
  @Autowired
  UserService userService;

  /**
   * 获取全部用户的ID、用户名、昵称信息列表，用于页面的select空间
   * 
   * @return
   */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public Object selectUser() {
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
  public Object getUserPointsInfoList(@RequestParam(required = false) String nickName, @RequestParam(required = false, defaultValue = "15") Integer userId,
      @RequestParam(required = false, defaultValue = "1") Integer page) {
    return userService.getUserPointsInfoList(nickName, userId, page);
  }

}
