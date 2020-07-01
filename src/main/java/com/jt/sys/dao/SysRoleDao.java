package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.entity.SysRole;

/**
 * 负责角色模块的持久化操作
 * @author sunyizun
 *
 */
public interface SysRoleDao {
	 /**
     * 分页查询角色信息
     * @param startIndex 上一页的结束位置
     * @param pageSize 每页要查询的记录数
     * @return
     */
	List<SysRole> findPageObjects(
             @Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 查询记录总数
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	//	根据id删除角色自身信息
	 int deleteObject(Integer id);
	
	//	将角色自身信息保存到数据库
	 int insertObject(SysRole entity);
	//修改角色自身信息
	 int updateObject(SysRole entity);
	 //基于角色id查询角色信息
	 SysRole findObjectById(Integer id);
	 /**
	  * 添加一个查询角色ID,角色名的方法
	  * @return
	  */
	 List<CheckBox> findObjects();
}
