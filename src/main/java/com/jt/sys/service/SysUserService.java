package com.jt.sys.service;

import java.util.Map;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserService {

	PageObject<SysUserDeptResult> findPageObjects(
			String username,
			Integer pageCurrent);
	/**
	 * 定义禁用启用方法
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(Integer id,
			Integer valid,String modifiedUser);
	/**
	 * 保存用户信息以及用户和角色的关系信息
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int saveObject(SysUser entity, Integer[] roleIds);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, Object> findObjectById(Integer userId);
	/**
	 * 
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,
			Integer[] roleIds);

	
}
