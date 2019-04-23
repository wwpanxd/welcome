package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuExpendsDao;
import com.bootdo.welcome.domain.StuExpendsDO;
import com.bootdo.welcome.service.StuExpendsService;


@Service
public class StuExpendsService  {
	@Autowired
	private StuExpendsDao stuExpendsDao;
	
	
	public StuExpendsDO get(Long id){
		return stuExpendsDao.findOneById(id);
	}
	
	
	public List<StuExpendsDO> list(Map<String, Object> map){
		return stuExpendsDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuExpendsDao.countByMap(map);
	}
	
	
	public int save(StuExpendsDO stuExpends){
		return stuExpendsDao.save(stuExpends);
	}
	
	
	public int update(StuExpendsDO stuExpends){
		return stuExpendsDao.updateById(stuExpends);
	}
	
	
	public int remove(Long id){
		return stuExpendsDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuExpendsDao.batchRemoveByIds(ids);
	}
	
}
