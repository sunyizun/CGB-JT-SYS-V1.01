package com.jt.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;

/**
 * 全局异常处理类
 * 在此类中添加所有Controller中需要
 * 共享的异常处理方法
 * @author sunyizun
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult doHandlerException(Exception e){
		e.printStackTrace();
		return new JsonResult(e.getMessage());

	}
}
