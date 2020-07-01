package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
	/**
	 * 	根据id删除角色与用户的关系数据
	 * @param roleId
	 * @return
	 */
	 int deleteObjectsByRoleId(Integer roleId);
	 
	 /**
		 * 负责将用户与角色的关系数据写入到数据库
		 * @param userId 用户id
		 * @param roleIds 多个角色id
		 * @return
		 */
		int insertObject(
				@Param("userId")Integer userId,
				@Param("roleIds")Integer[]roleIds);

	 /**
	  * 2)	根据用户id查询角色id(可能是多个)
	  * @param id
	  * @return
	  */
		List<Integer> findRoleIdsByUserId(Integer id);
		/**
		 *基于用户的id删除用户和角色表中的关系数据
		 * @param userId
		 * @return
		 */
		int deleteObjectsByUserId(Integer userId);
}
