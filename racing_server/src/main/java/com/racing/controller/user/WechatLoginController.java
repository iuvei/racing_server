package com.racing.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResutl;
import com.racing.controller.vo.LoginVO;
import com.racing.service.user.UserLoginService;
import com.racing.util.LoginStatusSaveUtil;

@RestController
public class WechatLoginController {

  @Autowired
  private UserLoginService userLoginService;

  @RequestMapping(value = "/user/client/login", method = RequestMethod.POST)
  public Object clientLogin(@RequestBody LoginVO loginVO, HttpServletRequest request) {
    return userLoginService.clientLogin(loginVO.getUserName(), loginVO.getPassword());
  }

  @RequestMapping(value = "/user/client/loginout", method = RequestMethod.POST)
  public ApiResutl clientLoginout() {
    Integer managerId = LoginStatusSaveUtil.getManagerId();
    if (managerId != null) {
      userLoginService.clientLoginout(managerId);
    }
    return ApiResutl.createSuccessReuslt();
  }

}
