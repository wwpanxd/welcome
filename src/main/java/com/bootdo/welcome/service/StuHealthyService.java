package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuHealthyDao;
import com.bootdo.welcome.domain.StuHealthyDO;
import com.bootdo.welcome.service.StuHealthyService;


@Service
public class StuHealthyService  {
	@Autowired
	private StuHealthyDao stuHealthyDao;
	
	
	public StuHealthyDO get(Long id){
		return stuHealthyDao.findOneById(id);
	}
	
	
	public List<StuHealthyDO> list(Map<String, Object> map){
		return stuHealthyDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuHealthyDao.countByMap(map);
	}
	
	
	public int save(StuHealthyDO stuHealthy){
		return stuHealthyDao.save(stuHealthy);
	}
	
	
	public int update(StuHealthyDO stuHealthy){
		return stuHealthyDao.updateById(stuHealthy);
	}
	
	
	public int remove(Long id){
		return stuHealthyDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuHealthyDao.batchRemoveByIds(ids);
	}
	
}
