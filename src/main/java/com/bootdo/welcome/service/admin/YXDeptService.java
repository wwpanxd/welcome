package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXDeptDao;
import com.bootdo.welcome.domain.admin.YXDeptDO;
import com.bootdo.welcome.service.admin.YXDeptService;


@Service
public class YXDeptService  {
	@Autowired
	private YXDeptDao deptDao;
	
	
	public YXDeptDO get(Long id){
		return deptDao.findOneById(id);
	}
	
	
	public List<YXDeptDO> list(Map<String, Object> map){
		return deptDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return deptDao.countByMap(map);
	}
	
	
	public int save(YXDeptDO dept){
		return deptDao.save(dept);
	}
	
	
	public int update(YXDeptDO dept){
		return deptDao.updateById(dept);
	}
	
	
	public int remove(Long id){
		return deptDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return deptDao.batchRemoveByIds(ids);
	}
	
}
