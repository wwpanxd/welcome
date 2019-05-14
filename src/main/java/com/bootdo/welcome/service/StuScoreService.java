package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuScoreDao;
import com.bootdo.welcome.domain.StuScoreDO;
import com.bootdo.welcome.service.StuScoreService;


@Service
public class StuScoreService  {
	@Autowired
	private StuScoreDao stuScoreDao;
	
	
	public StuScoreDO get(Long id){
		return stuScoreDao.findOneById(id);
	}
	
	
	public List<StuScoreDO> list(Map<String, Object> map){
		return stuScoreDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuScoreDao.countByMap(map);
	}
	
	
	public int save(StuScoreDO stuScore){
		return stuScoreDao.save(stuScore);
	}
	
	
	public int update(StuScoreDO stuScore){
		return stuScoreDao.updateById(stuScore);
	}
	
	
	public int remove(Long id){
		return stuScoreDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuScoreDao.batchRemoveByIds(ids);
	}
	
}
