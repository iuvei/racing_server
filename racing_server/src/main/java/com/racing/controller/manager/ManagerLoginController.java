package com.racing.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ManagerLoginVO;
import com.racing.service.manager.ManagerLoginService;

@RestController
public class ManagerLoginController {

  @Autowired
  private ManagerLoginService managerLogin;

  @RequestMapping(value = "/manager/login", method = RequestMethod.POST)
  public void login(@RequestBody ManagerLoginVO loginVO) {

  }

  @RequestMapping(value = "/manager/loginout", method = RequestMethod.POST)
  public void loginout() {

  }

}
