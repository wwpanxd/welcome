package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.LoanDao;
import com.bootdo.welcome.domain.LoanDO;
import com.bootdo.welcome.service.LoanService;


@Service
public class LoanService  {
	@Autowired
	private LoanDao loanDao;
	
	
	public LoanDO get(Long id){
		return loanDao.findOneById(id);
	}
	
	
	public List<LoanDO> list(Map<String, Object> map){
		return loanDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return loanDao.countByMap(map);
	}
	
	
	public int save(LoanDO loan){
		return loanDao.save(loan);
	}
	
	
	public int update(LoanDO loan){
		return loanDao.updateById(loan);
	}
	
	
	public int remove(Long id){
		return loanDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return loanDao.batchRemoveByIds(ids);
	}
	
}
