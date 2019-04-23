package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.welcome.dao.admin.YXEnterpriseDao;
import com.bootdo.welcome.domain.admin.YXEnterpriseDO;

import java.util.List;
import java.util.Map;


@Service
public class YXEnterpriseService  {
	@Autowired
	private YXEnterpriseDao enterpriseDao;
	
	
	public YXEnterpriseDO get(Long uvId){
		return enterpriseDao.findOneById(uvId);
	}
	
	
	public List<YXEnterpriseDO> list(Map<String, Object> map){
		return enterpriseDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return enterpriseDao.countByMap(map);
	}
	
	
	public int save(YXEnterpriseDO enterprise){
		return enterpriseDao.save(enterprise);
	}
	
	
	public int update(YXEnterpriseDO enterprise){
		return enterpriseDao.updateById(enterprise);
	}
	
	
	public int remove(Long uvId){
		return enterpriseDao.removeById(uvId);
	}
	
	
	public int batchRemove(Long[] uvIds){
		return enterpriseDao.batchRemoveByIds(uvIds);
	}
	
}
