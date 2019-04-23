package com.bootdo.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.AppDao;
import com.bootdo.system.domain.AppDO;



@Service
public class AppService {
	@Autowired
	private AppDao appDao;
	
	
	public AppDO get(Long id){
		return appDao.findOneById(id);
	}
	
	
	public List<AppDO> list(Map<String, Object> map){
		return appDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return appDao.countByMap(map);
	}
	
	
	public int save(AppDO app){
		return appDao.save(app);
	}
	
	
	public int update(AppDO app){
		return appDao.updateById(app);
	}
	
	
	public int remove(Long id){
		return appDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return appDao.batchRemoveByIds(ids);
	}

	
	public AppDO getlast() {
		// TODO Auto-generated method stub
		return appDao.findlastOne();
	}
	
}
