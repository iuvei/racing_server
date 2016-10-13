package com.racing.controller.user;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.LoginVO;
import com.racing.service.user.UserLoginService;
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
public class UserLoginController {

  @Autowired
  private UserLoginService userLoginService;

  @ApiOperation("分盘-登录")
  @RequestMapping(value = "/user/web/login", method = RequestMethod.POST)
  public Object webLogin(@RequestBody LoginVO loginVO, HttpServletRequest request) {
    return userLoginService.webLogin(loginVO.getUserName(), loginVO.getPassword(), RequestIPUtil.getIpAddr(request));
  }

  @ApiOperation("分盘-登出")
  @RequestMapping(value = "/user/web/loginout", method = RequestMethod.GET)
  public ApiResult webLoginout() {
    Integer managerId = LoginStatusSaveUtil.getManagerId();
    if (managerId != null) {
      userLoginService.webLoginout(managerId);
    }
    return ApiResult.createSuccessReuslt();
  }

}
