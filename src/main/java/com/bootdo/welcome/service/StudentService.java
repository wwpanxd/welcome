package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StudentDao;
import com.bootdo.welcome.domain.StudentDO;
import com.bootdo.welcome.service.StudentService;


@Service
public class StudentService  {
	@Autowired
	private StudentDao studentDao;
	
	
	public StudentDO get(Long id){
		return studentDao.findOneById(id);
	}
	
	
	public List<StudentDO> list(Map<String, Object> map){
		return studentDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return studentDao.countByMap(map);
	}
	
	
	public int save(StudentDO student){
		return studentDao.save(student);
	}
	
	
	public int update(StudentDO student){
		return studentDao.updateById(student);
	}
	
	
	public int remove(Long id){
		return studentDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return studentDao.batchRemoveByIds(ids);
	}
	
}
