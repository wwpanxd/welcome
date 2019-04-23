package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXUniversityDao;
import com.bootdo.welcome.domain.admin.YXUniversityDO;
import com.bootdo.welcome.service.admin.YXUniversityService;


@Service
public class YXUniversityService  {
	@Autowired
	private YXUniversityDao universityDao;
	
	
	public YXUniversityDO get(Long id){
		return universityDao.findOneById(id);
	}
	
	
	public List<YXUniversityDO> list(Map<String, Object> map){
		return universityDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return universityDao.countByMap(map);
	}
	
	
	public int save(YXUniversityDO university){
		return universityDao.save(university);
	}
	
	
	public int update(YXUniversityDO university){
		return universityDao.updateById(university);
	}
	
	
	public int remove(Long id){
		return universityDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return universityDao.batchRemoveByIds(ids);
	}
	
}
