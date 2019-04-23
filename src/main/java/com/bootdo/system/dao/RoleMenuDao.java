package com.bootdo.system.dao;

import com.bootdo.system.domain.RoleMenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单对应关系
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface RoleMenuDao {

	RoleMenuDO findOneById(Long id);
	
	List<RoleMenuDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int updateById(RoleMenuDO roleMenu);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
	
	List<Long> listMenuIdByRoleId(Long roleId);
	
	int removeByRoleId(Long roleId);

	int removeByMenuId(Long menuId);
	
	int batchSave(List<RoleMenuDO> list);
}
