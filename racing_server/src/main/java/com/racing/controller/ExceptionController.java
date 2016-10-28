package com.racing.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.racing.controller.vo.ApiResult;
import com.racing.util.NoLoginException;

@ControllerAdvice
public class ExceptionController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(NoLoginException.class)  
	@ResponseStatus(HttpStatus.OK) 
	@ResponseBody
	public Object noLoginExceptionHandler(NoLoginException ex,HttpServletRequest request){
		return ApiResult.createNoLoginReuslt();
	}

	@ExceptionHandler(Exception.class)  
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) 
	@ResponseBody
	public Object runtimeExceptionHandler(Exception ex,HttpServletRequest request){
		logger.error(ex.getMessage(),ex);
		return ApiResult.createErrorReuslt(ex.getMessage());
	}

}
