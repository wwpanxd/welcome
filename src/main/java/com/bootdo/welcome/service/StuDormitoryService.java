package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuDormitoryDao;
import com.bootdo.welcome.domain.StuDormitoryDO;
import com.bootdo.welcome.service.StuDormitoryService;


@Service
public class StuDormitoryService  {
	@Autowired
	private StuDormitoryDao stuDormitoryDao;
	
	
	public StuDormitoryDO get(Long id){
		return stuDormitoryDao.findOneById(id);
	}
	
	
	public List<StuDormitoryDO> list(Map<String, Object> map){
		return stuDormitoryDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuDormitoryDao.countByMap(map);
	}
	
	
	public int save(StuDormitoryDO stuDormitory){
		return stuDormitoryDao.save(stuDormitory);
	}
	
	
	public int update(StuDormitoryDO stuDormitory){
		return stuDormitoryDao.updateById(stuDormitory);
	}
	
	
	public int remove(Long id){
		return stuDormitoryDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuDormitoryDao.batchRemoveByIds(ids);
	}
	
}
