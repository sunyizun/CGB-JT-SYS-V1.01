package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysConfig;

public interface SysConfigDao {

	 List<SysConfig> findPageObjects(@Param("name")String name,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	
	 int getRowCount(@Param("name")String name);
	 /**
		 * 删除配置信息
		 * @param entity 封装配置信息
		 * @return 表示删除的行数
		 */

	 int deleteObjects (@Param("ids")Integer... ids);
	 /**
		 * 增加配置信息
		 * @param entity 封装配置信息
		 * @return 表示增加的行数
		 */

	 int insertObject(SysConfig entity);
	 /**
		 * 更新配置信息
		 * @param entity 封装配置信息
		 * @return 表示更新的行数
		 */

	 int updateObject(SysConfig entity); 
} 
