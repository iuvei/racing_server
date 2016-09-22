package com.racing.controller.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResutl;
import com.racing.service.RacingService;

@RestController
public class RacingController {

  @Autowired
  private RacingService service;

  @RequestMapping(value = "/racing/new")
  public Object racingResult() {
    return ApiResutl.createSuccessReuslt(service.getNewRacingResult());
  }

  @RequestMapping(value = "/racing/history")
  public Object racingResultHistory() {
    return ApiResutl.createSuccessReuslt(service.getRacingResultHistory());
  }

}
