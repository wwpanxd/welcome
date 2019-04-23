package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuExpendsDetailsDao;
import com.bootdo.welcome.domain.StuExpendsDetailsDO;
import com.bootdo.welcome.service.StuExpendsDetailsService;


@Service
public class StuExpendsDetailsService  {
	@Autowired
	private StuExpendsDetailsDao stuExpendsDetailsDao;
	
	
	public StuExpendsDetailsDO get(Long id){
		return stuExpendsDetailsDao.findOneById(id);
	}
	
	
	public List<StuExpendsDetailsDO> list(Map<String, Object> map){
		return stuExpendsDetailsDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuExpendsDetailsDao.countByMap(map);
	}
	
	
	public int save(StuExpendsDetailsDO stuExpendsDetails){
		return stuExpendsDetailsDao.save(stuExpendsDetails);
	}
	
	
	public int update(StuExpendsDetailsDO stuExpendsDetails){
		return stuExpendsDetailsDao.updateById(stuExpendsDetails);
	}
	
	
	public int remove(Long id){
		return stuExpendsDetailsDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuExpendsDetailsDao.batchRemoveByIds(ids);
	}
	
}
