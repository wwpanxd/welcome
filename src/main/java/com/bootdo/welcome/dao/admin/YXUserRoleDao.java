package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXUserRoleDO;

/**
 * 用户与角色对应关系
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:57:11
 */
@Mapper
public interface YXUserRoleDao {

	YXUserRoleDO findOneById(Long id);
	
	List<YXUserRoleDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXUserRoleDO userRole);
	
	int updateById(YXUserRoleDO userRole);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
