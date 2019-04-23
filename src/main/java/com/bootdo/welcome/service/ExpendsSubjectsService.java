package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ExpendsSubjectsDao;
import com.bootdo.welcome.domain.ExpendsSubjectsDO;
import com.bootdo.welcome.service.ExpendsSubjectsService;


@Service
public class ExpendsSubjectsService  {
	@Autowired
	private ExpendsSubjectsDao expendsSubjectsDao;
	
	
	public ExpendsSubjectsDO get(Long id){
		return expendsSubjectsDao.findOneById(id);
	}
	
	
	public List<ExpendsSubjectsDO> list(Map<String, Object> map){
		return expendsSubjectsDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return expendsSubjectsDao.countByMap(map);
	}
	
	
	public int save(ExpendsSubjectsDO expendsSubjects){
		return expendsSubjectsDao.save(expendsSubjects);
	}
	
	
	public int update(ExpendsSubjectsDO expendsSubjects){
		return expendsSubjectsDao.updateById(expendsSubjects);
	}
	
	
	public int remove(Long id){
		return expendsSubjectsDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return expendsSubjectsDao.batchRemoveByIds(ids);
	}
	
}
