package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.welcome.dao.admin.YXMenuDao;
import com.bootdo.welcome.domain.admin.YXMenuDO;
import com.bootdo.welcome.service.admin.YXMenuService;


@Service
public class YXMenuService  {
	@Autowired
	private YXMenuDao menuDao;
	
	
	public YXMenuDO get(Long mid){
		return menuDao.findOneById(mid);
	}
	
	
	public List<YXMenuDO> list(Map<String, Object> map){
		return menuDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return menuDao.countByMap(map);
	}
	
	
	public int save(YXMenuDO menu){
		return menuDao.save(menu);
	}
	
	
	public int update(YXMenuDO menu){
		return menuDao.updateById(menu);
	}
	
	
	public int remove(Long mid){
		return menuDao.removeById(mid);
	}
	
	
	public int batchRemove(Long[] mids){
		return menuDao.batchRemoveByIds(mids);
	}
	
}
