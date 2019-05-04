package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ErScoreDao;
import com.bootdo.welcome.domain.ErScoreDO;
import com.bootdo.welcome.service.ErScoreService;


@Service
public class ErScoreService  {
	@Autowired
	private ErScoreDao erScoreDao;
	
	
	public ErScoreDO get(Long id){
		return erScoreDao.findOneById(id);
	}
	
	
	public List<ErScoreDO> list(Map<String, Object> map){
		return erScoreDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return erScoreDao.countByMap(map);
	}
	
	
	public int save(ErScoreDO erScore){
		return erScoreDao.save(erScore);
	}
	
	
	public int update(ErScoreDO erScore){
		return erScoreDao.updateById(erScore);
	}
	
	
	public int remove(Long id){
		return erScoreDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return erScoreDao.batchRemoveByIds(ids);
	}
	
}
