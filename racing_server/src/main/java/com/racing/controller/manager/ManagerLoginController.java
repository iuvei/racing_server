package com.racing.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerLoginController {

  @RequestMapping(value = "/manager/login", method = RequestMethod.POST)
  public void login() {

  }

  @RequestMapping(value = "/manager/loginout", method = RequestMethod.POST)
  public void loginout() {

  }

}
