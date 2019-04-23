package com.bootdo.system.dao;

import com.bootdo.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface RoleDao {

	RoleDO findOneById(Long roleId);
	
	List<RoleDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(RoleDO role);
	
	int updateById(RoleDO role);
	
	int removeById(Long roleId);
	
	int batchRemoveByIds(Long[] roleIds);
}
