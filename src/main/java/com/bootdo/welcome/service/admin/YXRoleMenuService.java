package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXRoleMenuDao;
import com.bootdo.welcome.domain.admin.YXRoleMenuDO;


@Service
public class YXRoleMenuService  {
	@Autowired
	private YXRoleMenuDao roleMenuDao;
	
	
	public YXRoleMenuDO get(Long id){
		return roleMenuDao.findOneById(id);
	}
	
	
	public List<YXRoleMenuDO> list(Map<String, Object> map){
		return roleMenuDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return roleMenuDao.countByMap(map);
	}
	
	
	public int save(YXRoleMenuDO roleMenu){
		return roleMenuDao.save(roleMenu);
	}
	
	
	public int update(YXRoleMenuDO roleMenu){
		return roleMenuDao.updateById(roleMenu);
	}
	
	
	public int remove(Long id){
		return roleMenuDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return roleMenuDao.batchRemoveByIds(ids);
	}
	
}
