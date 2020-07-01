package com.jt.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Controller
@RequestMapping("/config/")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;
	
	@RequestMapping("doConfigListUI")
	  public String doConfigListUI(){
		  return "sys/config_list";
	  }
	@RequestMapping("doConfigEditUI")
	  public String doConfigEditUI(){
		  return "sys/config_edit";
	  }
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String name,Integer pageCurrent) {
		//Long startTime = System.nanoTime();
		PageObject<SysConfig> pageObject =sysConfigService.findPageObjects(name,pageCurrent);
		//Long endTime = System.nanoTime()-startTime;
		//System.out.println("endTime="+endTime);
		return new JsonResult(pageObject);
	}
	
	@RequestMapping(value="doDeleteObjects",produces="application/json;charset=utf-8")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids){
		sysConfigService.deleteObjects(ids);
		return new JsonResult("delete ok");
		
	}
	
	@RequestMapping(value="doSaveObject",produces="application/json;charset=utf-8")
	@ResponseBody
	public JsonResult doSaveObject(SysConfig entity){
		sysConfigService.saveObject(entity);
		  return new JsonResult("save ok");

		
	}
	
	@RequestMapping(value="doUpdateObject",produces="application/json;charset=utf-8")
	@ResponseBody
	public JsonResult doUpdateObject(SysConfig entity){
		sysConfigService.updateObject(entity);
		  return new JsonResult("update ok");

		
	}
}
