package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXUserDao;
import com.bootdo.welcome.domain.admin.YXUserDO;
import com.bootdo.welcome.service.admin.YXUserService;


@Service
public class YXUserService  {
	@Autowired
	private YXUserDao userDao;
	
	
	public YXUserDO get(Long id){
		return userDao.findOneById(id);
	}
	
	public YXUserDO findOneByLoginName(Integer uvcode,String loginname){
		return userDao.findOneByLoginNameAndUVCode(loginname,uvcode);
	}
	
	public List<YXUserDO> list(Map<String, Object> map){
		return userDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return userDao.countByMap(map);
	}
	
	
	public int save(YXUserDO user){
		return userDao.save(user);
	}
	
	
	public int update(YXUserDO user){
		return userDao.updateById(user);
	}
	
	
	public int remove(Long id){
		return userDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return userDao.batchRemoveByIds(ids);
	}
	
}
