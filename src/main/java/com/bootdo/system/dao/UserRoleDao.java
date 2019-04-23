package com.bootdo.system.dao;

import com.bootdo.system.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色对应关系
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface UserRoleDao {

	UserRoleDO findOneById(Long id);

	List<UserRoleDO> findPageListByMap(Map<String, Object> map);

	int countByMap(Map<String, Object> map);

	int save(UserRoleDO userRole);

	int updateById(UserRoleDO userRole);

	int removeById(Long id);

	int batchRemoveByIds(Long[] ids);

	List<Long> listRoleId(Long userId);

	int removeByUserId(Long userId);

	int removeByRoleId(Long roleId);

	int batchSave(List<UserRoleDO> list);

	int batchRemoveByUserId(Long[] ids);
}
