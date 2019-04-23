package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ClassDao;
import com.bootdo.welcome.domain.ClassDO;
import com.bootdo.welcome.service.ClassService;


@Service
public class ClassService  {
	@Autowired
	private ClassDao classDao;
	
	
	public ClassDO get(Long id){
		return classDao.findOneById(id);
	}
	
	
	public List<ClassDO> list(Map<String, Object> map){
		return classDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return classDao.countByMap(map);
	}
	
	
	public int save(ClassDO cl){
		return classDao.save(cl);
	}
	
	
	public int update(ClassDO cl){
		return classDao.updateById(cl);
	}
	
	
	public int remove(Long id){
		return classDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return classDao.batchRemoveByIds(ids);
	}
	
}
