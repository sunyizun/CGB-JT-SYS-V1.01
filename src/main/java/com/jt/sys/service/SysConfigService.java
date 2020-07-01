package com.jt.sys.service;

import org.springframework.stereotype.Service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;


public interface SysConfigService {
	PageObject<SysConfig> findPageObjects(String name,Integer pageCurrent);
	
	//基于id执行删除操作,  
	int deleteObjects(Integer... ids);
	
	//

	 int saveObject(SysConfig entity);
	 
	 int updateObject(SysConfig entity); 
}
