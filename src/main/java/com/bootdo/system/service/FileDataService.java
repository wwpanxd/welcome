package com.bootdo.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.FileDataDao;
import com.bootdo.system.domain.FileDataDO;



@Service
public class FileDataService {
	@Autowired
	private FileDataDao fileDataDao;
	
	
	public FileDataDO get(Long id){
		return fileDataDao.findOneById(id);
	}
	
	
	public List<FileDataDO> list(Map<String, Object> map){
		return fileDataDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return fileDataDao.countByMap(map);
	}
	
	
	public int save(FileDataDO fileData){
		return fileDataDao.save(fileData);
	}
	
	
	public int update(FileDataDO fileData){
		return fileDataDao.updateById(fileData);
	}
	
	
	public int remove(Long id){
		return fileDataDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return fileDataDao.batchRemoveByIds(ids);
	}

	
	public FileDataDO getbyfname(String fname) {
		// TODO Auto-generated method stub
		return fileDataDao.getbyfname(fname);
	}
	
}
