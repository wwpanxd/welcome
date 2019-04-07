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
	
	
	public FileDataDO get(Integer id){
		return fileDataDao.get(id);
	}
	
	
	public List<FileDataDO> list(Map<String, Object> map){
		return fileDataDao.list(map);
	}
	
	
	public int count(Map<String, Object> map){
		return fileDataDao.count(map);
	}
	
	
	public int save(FileDataDO fileData){
		return fileDataDao.save(fileData);
	}
	
	
	public int update(FileDataDO fileData){
		return fileDataDao.update(fileData);
	}
	
	
	public int remove(Integer id){
		return fileDataDao.remove(id);
	}
	
	
	public int batchRemove(Integer[] ids){
		return fileDataDao.batchRemove(ids);
	}

	
	public FileDataDO getbyfname(String fname) {
		// TODO Auto-generated method stub
		return fileDataDao.getbyfname(fname);
	}
	
}
