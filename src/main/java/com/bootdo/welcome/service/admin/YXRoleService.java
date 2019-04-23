package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXRoleDao;
import com.bootdo.welcome.domain.admin.YXRoleDO;
import com.bootdo.welcome.service.admin.YXRoleService;


@Service
public class YXRoleService  {
	@Autowired
	private YXRoleDao roleDao;
	
	
	public YXRoleDO get(Long id){
		return roleDao.findOneById(id);
	}
	
	
	public List<YXRoleDO> list(Map<String, Object> map){
		return roleDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return roleDao.countByMap(map);
	}
	
	
	public int save(YXRoleDO role){
		return roleDao.save(role);
	}
	
	
	public int update(YXRoleDO role){
		return roleDao.updateById(role);
	}
	
	
	public int remove(Long id){
		return roleDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return roleDao.batchRemoveByIds(ids);
	}
	
}
