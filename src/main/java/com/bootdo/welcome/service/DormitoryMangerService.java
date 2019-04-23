package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.DormitoryMangerDao;
import com.bootdo.welcome.domain.DormitoryMangerDO;
import com.bootdo.welcome.service.DormitoryMangerService;


@Service
public class DormitoryMangerService  {
	@Autowired
	private DormitoryMangerDao dormitoryMangerDao;
	
	
	public DormitoryMangerDO get(Long id){
		return dormitoryMangerDao.findOneById(id);
	}
	
	
	public List<DormitoryMangerDO> list(Map<String, Object> map){
		return dormitoryMangerDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return dormitoryMangerDao.countByMap(map);
	}
	
	
	public int save(DormitoryMangerDO dormitoryManger){
		return dormitoryMangerDao.save(dormitoryManger);
	}
	
	
	public int update(DormitoryMangerDO dormitoryManger){
		return dormitoryMangerDao.updateById(dormitoryManger);
	}
	
	
	public int remove(Long id){
		return dormitoryMangerDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return dormitoryMangerDao.batchRemoveByIds(ids);
	}
	
}
