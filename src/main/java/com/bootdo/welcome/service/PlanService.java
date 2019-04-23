package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.PlanDao;
import com.bootdo.welcome.domain.PlanDO;
import com.bootdo.welcome.service.PlanService;


@Service
public class PlanService  {
	@Autowired
	private PlanDao planDao;
	
	
	public PlanDO get(Long id){
		return planDao.findOneById(id);
	}
	
	
	public List<PlanDO> list(Map<String, Object> map){
		return planDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return planDao.countByMap(map);
	}
	
	
	public int save(PlanDO plan){
		return planDao.save(plan);
	}
	
	
	public int update(PlanDO plan){
		return planDao.updateById(plan);
	}
	
	
	public int remove(Long id){
		return planDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return planDao.batchRemoveByIds(ids);
	}
	
}
