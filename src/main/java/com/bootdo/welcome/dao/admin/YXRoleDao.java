package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXRoleDO;

/**
 * 角色
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface YXRoleDao {

	YXRoleDO findOneById(Long id);
	
	List<YXRoleDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXRoleDO role);
	
	int updateById(YXRoleDO role);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
