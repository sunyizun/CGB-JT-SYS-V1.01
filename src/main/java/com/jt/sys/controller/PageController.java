package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	  public String doIndexUI(){
		  return "starter";//.html
	  }

	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
		
	}
	
	
}
