package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	@Override
	public PageObject<SysConfig> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1) throw new IllegalArgumentException("当前页码不正确");
		int rowCount=sysConfigDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysConfig> records=sysConfigDao.findPageObjects(name, startIndex, pageSize);
		//4.1)构建PageObject对象
		PageObject<SysConfig> pageObject=
				new PageObject<>();
		//4.2)封装数据
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		//5.返回封装结果。
		return pageObject;

	}
	@Override
	public int deleteObjects(Integer... ids) {
		//参数合法性校验
		if(ids==null||ids.length==0)throw new IllegalArgumentException("请选择一个");
		//2.执行删除操作
		int rows;
		try{
			rows=sysConfigDao.deleteObjects(ids);
		}catch(Throwable e){
			e.printStackTrace();
			//发出报警信息(例如给运维人员发短信)
			throw new ServiceException("系统故障，正在恢复中...");
		}
		//4.对结果进行验证
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		//5.返回结果
		return rows;

	}
	@Override
	public int saveObject(SysConfig entity) {
		//1.合法验证
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("参数名不能为空");
		if(StringUtils.isEmpty(entity.getValue()))
			throw new IllegalArgumentException("参数值不能为空");
		//2.将数据写入到数据库
		int rows;
		try{
			rows=sysConfigDao.insertObject(entity);
		}catch(Throwable t){
			t.printStackTrace();
			//报警....
			throw new ServiceException("系统故障，正在恢复");
		}
		//3.返回结果
		return rows;

	}
	@Override
	public int updateObject(SysConfig entity) {
		 //1.合法性验证
		  if(entity==null)
		  throw new IllegalArgumentException("对象不能为空");
		  if(StringUtils.isEmpty(entity.getName()))
		  throw new IllegalArgumentException("参数名不能为空");
		  if(StringUtils.isEmpty(entity.getValue()))
		  throw new IllegalArgumentException("参数值不能为空");
		  //2.将数据更新到数据库
		  int rows=sysConfigDao.updateObject(entity);
		  //3.对结果进行验证
		  if(rows==0)
		  throw new ServiceException("此记录可能已经不存在");
		  //4.返回结果(会返回给谁?调用者)
		  return rows;

	}

}
