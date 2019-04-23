package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StageDao;
import com.bootdo.welcome.domain.StageDO;
import com.bootdo.welcome.service.StageService;


@Service
public class StageService  {
	@Autowired
	private StageDao stageDao;
	
	
	public StageDO get(Long id){
		return stageDao.findOneById(id);
	}
	
	
	public List<StageDO> list(Map<String, Object> map){
		return stageDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stageDao.countByMap(map);
	}
	
	
	public int save(StageDO stage){
		return stageDao.save(stage);
	}
	
	
	public int update(StageDO stage){
		return stageDao.updateById(stage);
	}
	
	
	public int remove(Long id){
		return stageDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stageDao.batchRemoveByIds(ids);
	}
	
}
