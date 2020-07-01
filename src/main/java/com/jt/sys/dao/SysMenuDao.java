package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuDao {
	/**
	 * 查询所有菜单以及上一级菜单
	 * FAQ?
	 * 1)假如本菜单没有上一级菜单是否要呈现?要
	 * 2)当菜单为一级菜单时它的上级菜单默认为null?
	 * 这样的菜单,采用怎样的sql实现查询操作?
	 * 方案:表关联或嵌套查询
	 */
	List<Map<String,Object>> findObjects();
	
	 /**
	  * 根据菜单id统计子菜单的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 根据id 删除菜单
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 List<Node> findZtreeMenuNodes();
	
	 int insertObject(SysMenu entity);
	 int updateObject(SysMenu entity);
}
