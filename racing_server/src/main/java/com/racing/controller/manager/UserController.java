package com.racing.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
