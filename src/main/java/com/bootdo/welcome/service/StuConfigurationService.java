package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuConfigurationDao;
import com.bootdo.welcome.domain.StuConfigurationDO;
import com.bootdo.welcome.service.StuConfigurationService;


@Service
public class StuConfigurationService  {
	@Autowired
	private StuConfigurationDao stuConfigurationDao;
	
	
	public StuConfigurationDO get(Long id){
		return stuConfigurationDao.findOneById(id);
	}
	
	
	public List<StuConfigurationDO> list(Map<String, Object> map){
		return stuConfigurationDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuConfigurationDao.countByMap(map);
	}
	
	
	public int save(StuConfigurationDO stuConfiguration){
		return stuConfigurationDao.save(stuConfiguration);
	}
	
	
	public int update(StuConfigurationDO stuConfiguration){
		return stuConfigurationDao.updateById(stuConfiguration);
	}
	
	
	public int remove(Long id){
		return stuConfigurationDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuConfigurationDao.batchRemoveByIds(ids);
	}
	
}
