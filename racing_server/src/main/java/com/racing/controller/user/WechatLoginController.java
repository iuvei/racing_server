package com.racing.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
  public Object clientLogin(@RequestBody LoginVO loginVO, @RequestHeader("Client") String clientSN) {
    return userLoginService.clientLogin(loginVO.getUserName(), loginVO.getPassword(), clientSN);
  }

  @RequestMapping(value = "/user/client/loginout", method = RequestMethod.GET)
  public Object clientLoginout() {
    Integer userId = LoginStatusSaveUtil.getUserClientId();
    if (userId != null) {
      userLoginService.clientLoginout(userId);
    }
    return ApiResutl.createSuccessReuslt();
  }

  @RequestMapping(value = "/user/client/check", method = RequestMethod.GET)
  public Object clientCheckIsEnable(@RequestHeader("Client") String clientSN) {
    return userLoginService.checkClientIsEnable(clientSN);
  }

}
