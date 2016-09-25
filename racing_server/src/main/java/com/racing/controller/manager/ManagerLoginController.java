package com.racing.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.LoginVO;
import com.racing.service.manager.ManagerLoginService;
import com.racing.util.LoginStatusSaveUtil;
import com.racing.util.RequestIPUtil;

@RestController
public class ManagerLoginController {

  @Autowired
  private ManagerLoginService managerLogin;

  @RequestMapping(value = "/manager/login", method = RequestMethod.POST)
  public Object login(@RequestBody LoginVO loginVO, HttpServletRequest request) {
    return managerLogin.login(loginVO.getUserName(), loginVO.getPassword(), RequestIPUtil.getIpAddr(request));
  }

  @RequestMapping(value = "/manager/loginout", method = RequestMethod.GET)
  public ApiResult loginout() {
    Integer managerId = LoginStatusSaveUtil.getManagerId();
    if (managerId != null) {
      managerLogin.loginout(managerId);
    }
    return ApiResult.createSuccessReuslt();
  }

}
