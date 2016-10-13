package com.racing.controller.racing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResult;
import com.racing.service.racing.RacingService;

@RestController
public class RacingController {
	@Autowired
	private RacingService service;

	@RequestMapping(value = "/racing/web/new")
	public Object racingResult() {
		return ApiResult.createSuccessReuslt(service.getNewRacingResult());
	}

	@RequestMapping(value = "/racing/web/history")
	public Object racingResultHistory() {
		return ApiResult.createSuccessReuslt(service.getRacingResultHistory());
	}
}
