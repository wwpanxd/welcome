package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuFamilyDao;
import com.bootdo.welcome.domain.StuFamilyDO;
import com.bootdo.welcome.service.StuFamilyService;


@Service
public class StuFamilyService  {
	@Autowired
	private StuFamilyDao stuFamilyDao;
	
	
	public StuFamilyDO get(Long id){
		return stuFamilyDao.findOneById(id);
	}
	
	
	public List<StuFamilyDO> list(Map<String, Object> map){
		return stuFamilyDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuFamilyDao.countByMap(map);
	}
	
	
	public int save(StuFamilyDO stuFamily){
		return stuFamilyDao.save(stuFamily);
	}
	
	
	public int update(StuFamilyDO stuFamily){
		return stuFamilyDao.updateById(stuFamily);
	}
	
	
	public int remove(Long id){
		return stuFamilyDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuFamilyDao.batchRemoveByIds(ids);
	}
	
}
