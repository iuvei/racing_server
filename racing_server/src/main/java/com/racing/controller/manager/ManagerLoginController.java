package com.racing.controller.manager;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.LoginVO;
import com.racing.service.manager.ManagerLoginService;
import com.racing.util.LoginStatusSaveUtil;
import com.racing.util.RequestIPUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ManagerLoginController {

  @Autowired
  private ManagerLoginService managerLogin;

  @ApiOperation("总盘-登录")
  @RequestMapping(value = "/manager/login", method = RequestMethod.POST)
  public Object login(@RequestBody LoginVO loginVO, HttpServletRequest request) {
    return managerLogin.login(loginVO.getUserName(), loginVO.getPassword(), RequestIPUtil.getIpAddr(request));
  }

  @ApiOperation("总盘-登出")
  @RequestMapping(value = "/manager/loginout", method = RequestMethod.GET)
  public ApiResult loginout() {
    Integer managerId = LoginStatusSaveUtil.getManagerId();
    if (managerId != null) {
      managerLogin.loginout(managerId);
    }
    return ApiResult.createSuccessReuslt();
  }

}
