package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ErArrangementDao;
import com.bootdo.welcome.domain.ErArrangementDO;
import com.bootdo.welcome.service.ErArrangementService;


@Service
public class ErArrangementService  {
	@Autowired
	private ErArrangementDao erArrangementDao;
	
	
	public ErArrangementDO get(Long id){
		return erArrangementDao.findOneById(id);
	}
	
	
	public List<ErArrangementDO> list(Map<String, Object> map){
		return erArrangementDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return erArrangementDao.countByMap(map);
	}
	
	
	public int save(ErArrangementDO erArrangement){
		return erArrangementDao.save(erArrangement);
	}
	
	
	public int update(ErArrangementDO erArrangement){
		return erArrangementDao.updateById(erArrangement);
	}
	
	
	public int remove(Long id){
		return erArrangementDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return erArrangementDao.batchRemoveByIds(ids);
	}
	
}
