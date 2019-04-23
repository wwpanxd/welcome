package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXRoleMenuDO;

/**
 * 角色与菜单对应关系
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface YXRoleMenuDao {

	YXRoleMenuDO findOneById(Long id);
	
	List<YXRoleMenuDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXRoleMenuDO roleMenu);
	
	int updateById(YXRoleMenuDO roleMenu);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
