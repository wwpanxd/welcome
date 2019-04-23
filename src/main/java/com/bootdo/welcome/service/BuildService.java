package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.BuildDao;
import com.bootdo.welcome.domain.BuildDO;
import com.bootdo.welcome.service.BuildService;


@Service
public class BuildService  {
	@Autowired
	private BuildDao buildDao;
	
	
	public BuildDO get(Long id){
		return buildDao.findOneById(id);
	}
	
	
	public List<BuildDO> list(Map<String, Object> map){
		return buildDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return buildDao.countByMap(map);
	}
	
	
	public int save(BuildDO build){
		return buildDao.save(build);
	}
	
	
	public int update(BuildDO build){
		return buildDao.updateById(build);
	}
	
	
	public int remove(Long id){
		return buildDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return buildDao.batchRemoveByIds(ids);
	}
	
}
