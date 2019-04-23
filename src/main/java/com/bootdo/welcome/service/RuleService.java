package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.RuleDao;
import com.bootdo.welcome.domain.RuleDO;
import com.bootdo.welcome.service.RuleService;


@Service
public class RuleService  {
	@Autowired
	private RuleDao ruleDao;
	
	
	public RuleDO get(Long id){
		return ruleDao.findOneById(id);
	}
	
	
	public List<RuleDO> list(Map<String, Object> map){
		return ruleDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return ruleDao.countByMap(map);
	}
	
	
	public int save(RuleDO rule){
		return ruleDao.save(rule);
	}
	
	
	public int update(RuleDO rule){
		return ruleDao.updateById(rule);
	}
	
	
	public int remove(Long id){
		return ruleDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return ruleDao.batchRemoveByIds(ids);
	}
	
}
