package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.DormitoryDao;
import com.bootdo.welcome.domain.DormitoryDO;
import com.bootdo.welcome.service.DormitoryService;


@Service
public class DormitoryService  {
	@Autowired
	private DormitoryDao dormitoryDao;
	
	
	public DormitoryDO get(Long id){
		return dormitoryDao.findOneById(id);
	}
	
	
	public List<DormitoryDO> list(Map<String, Object> map){
		return dormitoryDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return dormitoryDao.countByMap(map);
	}
	
	
	public int save(DormitoryDO dormitory){
		return dormitoryDao.save(dormitory);
	}
	
	
	public int update(DormitoryDO dormitory){
		return dormitoryDao.updateById(dormitory);
	}
	
	
	public int remove(Long id){
		return dormitoryDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return dormitoryDao.batchRemoveByIds(ids);
	}
	
}
