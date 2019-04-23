package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXUserRoleDao;
import com.bootdo.welcome.domain.admin.YXUserRoleDO;
import com.bootdo.welcome.service.admin.YXUserRoleService;


@Service
public class YXUserRoleService  {
	@Autowired
	private YXUserRoleDao userRoleDao;
	
	
	public YXUserRoleDO get(Long id){
		return userRoleDao.findOneById(id);
	}
	
	
	public List<YXUserRoleDO> list(Map<String, Object> map){
		return userRoleDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return userRoleDao.countByMap(map);
	}
	
	
	public int save(YXUserRoleDO userRole){
		return userRoleDao.save(userRole);
	}
	
	
	public int update(YXUserRoleDO userRole){
		return userRoleDao.updateById(userRole);
	}
	
	
	public int remove(Long id){
		return userRoleDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return userRoleDao.batchRemoveByIds(ids);
	}
	
}
