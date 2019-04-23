package com.bootdo.system.dao;

import com.bootdo.system.domain.MenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface MenuDao {

	MenuDO findOneById(Long menuId);
	
	List<MenuDO> findPageListByMap(Map<String,Object> map);
	
	List<MenuDO> list2(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(MenuDO menu);
	
	int updateById(MenuDO menu);
	
	int removeById(Long menuId);
	
	int batchRemoveByIds(Long[] menuIds);
	
	List<MenuDO> listMenuByUserId(Long id);
	
	List<String> listUserPerms(Long id);
}
