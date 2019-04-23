package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuCollegeDao;
import com.bootdo.welcome.domain.StuCollegeDO;
import com.bootdo.welcome.service.StuCollegeService;


@Service
public class StuCollegeService  {
	@Autowired
	private StuCollegeDao stuCollegeDao;
	
	
	public StuCollegeDO get(Long id){
		return stuCollegeDao.findOneById(id);
	}
	
	
	public List<StuCollegeDO> list(Map<String, Object> map){
		return stuCollegeDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuCollegeDao.countByMap(map);
	}
	
	
	public int save(StuCollegeDO stuCollege){
		return stuCollegeDao.save(stuCollege);
	}
	
	
	public int update(StuCollegeDO stuCollege){
		return stuCollegeDao.updateById(stuCollege);
	}
	
	
	public int remove(Long id){
		return stuCollegeDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuCollegeDao.batchRemoveByIds(ids);
	}
	
}
