package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.CollegeDao;
import com.bootdo.welcome.domain.CollegeDO;
import com.bootdo.welcome.service.CollegeService;


@Service
public class CollegeService  {
	@Autowired
	private CollegeDao collegeDao;
	
	
	public CollegeDO get(Long id){
		return collegeDao.findOneById(id);
	}
	
	
	public List<CollegeDO> list(Map<String, Object> map){
		return collegeDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return collegeDao.countByMap(map);
	}
	
	
	public int save(CollegeDO college){
		return collegeDao.save(college);
	}
	
	
	public int update(CollegeDO college){
		return collegeDao.updateById(college);
	}
	
	
	public int remove(Long id){
		return collegeDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return collegeDao.batchRemoveByIds(ids);
	}
	
}
