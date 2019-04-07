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
	
	
	public AppDO get(Integer id){
		return appDao.get(id);
	}
	
	
	public List<AppDO> list(Map<String, Object> map){
		return appDao.list(map);
	}
	
	
	public int count(Map<String, Object> map){
		return appDao.count(map);
	}
	
	
	public int save(AppDO app){
		return appDao.save(app);
	}
	
	
	public int update(AppDO app){
		return appDao.update(app);
	}
	
	
	public int remove(Integer id){
		return appDao.remove(id);
	}
	
	
	public int batchRemove(Integer[] ids){
		return appDao.batchRemove(ids);
	}

	
	public AppDO getlast() {
		// TODO Auto-generated method stub
		return appDao.getlast();
	}
	
}
