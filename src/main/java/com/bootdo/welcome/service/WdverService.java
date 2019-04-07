package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.welcome.dao.WdverDao;
import com.bootdo.welcome.domain.WdverDO;



@Service
public class WdverService {
	@Autowired
	private WdverDao wdverDao;
	
	
	public WdverDO get(Integer id){
		return wdverDao.get(id);
	}
	
	
	public List<WdverDO> list(Map<String, Object> map){
		return wdverDao.list(map);
	}
	
	
	public int count(Map<String, Object> map){
		return wdverDao.count(map);
	}
	
	
	public int save(WdverDO wdver){
		return wdverDao.save(wdver);
	}
	
	
	public int update(WdverDO wdver){
		return wdverDao.update(wdver);
	}
	
	
	public int remove(Integer id){
		return wdverDao.remove(id);
	}
	
	
	public int batchRemove(Integer[] ids){
		return wdverDao.batchRemove(ids);
	}
	
}
