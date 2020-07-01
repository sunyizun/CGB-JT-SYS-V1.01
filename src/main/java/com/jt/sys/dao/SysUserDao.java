package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserDao {
/**
 * 依据查询当前页数据
 * @param username
 * @param startIndex
 * @param pageSize
 * @return
 */
	List<SysUserDeptResult> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 据条件查询总记录数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	/**
	 * 对用户id执行禁用或启用操作
	 * @param id 1是启用0是禁用
	 * @param valid
	 * @param modifiedUser谁执行的禁用或启用
	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);

	/**
	 * 负责将用户信息写入到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);
	
	/**
	 * 根据用户id查询用户以及部门信息
	 * @param id
	 * @return
	 */
	SysUserDeptResult findObjectById(Integer id);
	/**
	 * 更新用户自身数据的方法
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	
}
