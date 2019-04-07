package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.welcome.dao.ScoreDao;
import com.bootdo.welcome.domain.ScoreDO;
import com.bootdo.welcome.service.ScoreService;


@Service
public class ScoreService {
	@Autowired
	private ScoreDao scoreDao;
	
	
	public ScoreDO get(Integer id){
		return scoreDao.get(id);
	}
	
	public ScoreDO gettotalscore(Integer uid){
		return scoreDao.gettotalscore(uid);
	}
	
	
	public List<ScoreDO> list(Map<String, Object> map){
		return scoreDao.list(map);
	}
	
	
	public int count(Map<String, Object> map){
		return scoreDao.count(map);
	}
	
	
	public int save(ScoreDO score){
		return scoreDao.save(score);
	}
	
	
	public int update(ScoreDO score){
		return scoreDao.update(score);
	}
	
	
	public int remove(Integer id){
		return scoreDao.remove(id);
	}
	
	
	public int batchRemove(Integer[] ids){
		return scoreDao.batchRemove(ids);
	}
	
}
