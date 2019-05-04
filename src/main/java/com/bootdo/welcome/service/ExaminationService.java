package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ExaminationDao;
import com.bootdo.welcome.domain.ExaminationDO;
import com.bootdo.welcome.service.ExaminationService;


@Service
public class ExaminationService  {
	@Autowired
	private ExaminationDao examinationDao;
	
	
	public ExaminationDO get(Long id){
		return examinationDao.findOneById(id);
	}
	
	
	public List<ExaminationDO> list(Map<String, Object> map){
		return examinationDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return examinationDao.countByMap(map);
	}
	
	
	public int save(ExaminationDO examination){
		return examinationDao.save(examination);
	}
	
	
	public int update(ExaminationDO examination){
		return examinationDao.updateById(examination);
	}
	
	
	public int remove(Long id){
		return examinationDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return examinationDao.batchRemoveByIds(ids);
	}
	
}
