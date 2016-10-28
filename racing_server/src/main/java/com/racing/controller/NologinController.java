package com.racing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racing.controller.vo.ApiResult;

@RestController
public class NologinController {

	@RequestMapping(value="/nologin")
	public Object nologin(){
		return ApiResult.createNoLoginReuslt();
	}
	
}
