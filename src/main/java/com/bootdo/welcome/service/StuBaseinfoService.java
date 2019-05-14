package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.StuBaseinfoDao;
import com.bootdo.welcome.domain.StuBaseinfoDO;
import com.bootdo.welcome.service.StuBaseinfoService;


@Service
public class StuBaseinfoService  {
	@Autowired
	private StuBaseinfoDao stuBaseinfoDao;
	
	
	public StuBaseinfoDO get(Long id){
		return stuBaseinfoDao.findOneById(id);
	}
	
	
	public List<StuBaseinfoDO> list(Map<String, Object> map){
		return stuBaseinfoDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return stuBaseinfoDao.countByMap(map);
	}
	
	
	public int save(StuBaseinfoDO stuBaseinfo){
		return stuBaseinfoDao.save(stuBaseinfo);
	}
	
	
	public int update(StuBaseinfoDO stuBaseinfo){
		return stuBaseinfoDao.updateById(stuBaseinfo);
	}
	
	
	public int remove(Long id){
		return stuBaseinfoDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return stuBaseinfoDao.batchRemoveByIds(ids);
	}
	
}
