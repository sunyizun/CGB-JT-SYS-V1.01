package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.dao.support.DaoSupport;

import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;

public class TestSysConfigDao extends TestBase {

	@Test
	public void TestFindPageObjects(){
		SysConfigDao dao=ctx.getBean(SysConfigDao.class);
		List<SysConfig> list= dao.findPageObjects("o", 1, 2);
	for(SysConfig scf:list){
		System.out.println(scf);
		
	}
	}
	
}
