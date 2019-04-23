package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.LinkDao;
import com.bootdo.welcome.domain.LinkDO;
import com.bootdo.welcome.service.LinkService;


@Service
public class LinkService  {
	@Autowired
	private LinkDao linkDao;
	
	
	public LinkDO get(Long id){
		return linkDao.findOneById(id);
	}
	
	
	public List<LinkDO> list(Map<String, Object> map){
		return linkDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return linkDao.countByMap(map);
	}
	
	
	public int save(LinkDO link){
		return linkDao.save(link);
	}
	
	
	public int update(LinkDO link){
		return linkDao.updateById(link);
	}
	
	
	public int remove(Long id){
		return linkDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return linkDao.batchRemoveByIds(ids);
	}
	
}
