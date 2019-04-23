package com.bootdo.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bootdo.system.dao.UserRoleDao;
import com.bootdo.system.domain.UserRoleDO;

@Transactional
@Service
public class UserRoleService{

    @Autowired
    UserRoleDao userRoleMapper;

	
	public List<UserRoleDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userRoleMapper.findPageListByMap(map);
	}

	
	public int removeByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userRoleMapper.removeByUserId(userId);
	}

	
	public int remove(Long id) {
		// TODO Auto-generated method stub
		return userRoleMapper.removeById(id);
	}

	
	public int removeByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return userRoleMapper.removeByRoleId(roleId);
	}

	
	public int save(UserRoleDO userRole) {
		// TODO Auto-generated method stub
		return userRoleMapper.save(userRole);
	}

	
	public int batchSave(List<UserRoleDO> list) {
		// TODO Auto-generated method stub
		return userRoleMapper.batchSave(list);
	}
    
    
}
