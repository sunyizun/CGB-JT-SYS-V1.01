package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {

	int deleteObjectsByMenuId(Integer menuId);
	//	根据id删除角色与菜单的关系数据
	int deleteObjectsByRoleId(Integer roleId);
	//插入角色菜单关系数据的方法
	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	
	//基于角色id查询菜单id的方法
	List<Integer> findMenuIdsByRoleId(Integer roleId);
}
