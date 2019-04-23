package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXPlusDao;
import com.bootdo.welcome.domain.admin.YXPlusDO;
import com.bootdo.welcome.service.admin.YXPlusService;


@Service
public class YXPlusService  {
	@Autowired
	private YXPlusDao plusDao;
	
	
	public YXPlusDO get(Long pId){
		return plusDao.findOneById(pId);
	}
	
	
	public List<YXPlusDO> list(Map<String, Object> map){
		return plusDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return plusDao.countByMap(map);
	}
	
	
	public int save(YXPlusDO plus){
		return plusDao.save(plus);
	}
	
	
	public int update(YXPlusDO plus){
		return plusDao.updateById(plus);
	}
	
	
	public int remove(Long pId){
		return plusDao.removeById(pId);
	}
	
	
	public int batchRemove(Long[] pIds){
		return plusDao.batchRemoveByIds(pIds);
	}
	
}
