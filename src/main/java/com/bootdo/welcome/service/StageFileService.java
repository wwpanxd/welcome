package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StageFileDao;
import com.bootdo.welcome.domain.StageFileDO;
import com.bootdo.welcome.service.StageFileService;


@Service
public class StageFileService  {
	@Autowired
	private StageFileDao stageFileDao;
	
	
	public StageFileDO get(Long id){
		return stageFileDao.findOneById(id);
	}
	
	
	public List<StageFileDO> list(Map<String, Object> map){
		return stageFileDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stageFileDao.countByMap(map);
	}
	
	
	public int save(StageFileDO stageFile){
		return stageFileDao.save(stageFile);
	}
	
	
	public int update(StageFileDO stageFile){
		return stageFileDao.updateById(stageFile);
	}
	
	
	public int remove(Long id){
		return stageFileDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stageFileDao.batchRemoveByIds(ids);
	}
	
}
