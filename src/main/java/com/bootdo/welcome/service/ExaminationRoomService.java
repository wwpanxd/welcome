package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ExaminationRoomDao;
import com.bootdo.welcome.domain.ExaminationRoomDO;
import com.bootdo.welcome.service.ExaminationRoomService;


@Service
public class ExaminationRoomService  {
	@Autowired
	private ExaminationRoomDao examinationRoomDao;
	
	
	public ExaminationRoomDO get(Long id){
		return examinationRoomDao.findOneById(id);
	}
	
	
	public List<ExaminationRoomDO> list(Map<String, Object> map){
		return examinationRoomDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return examinationRoomDao.countByMap(map);
	}
	
	
	public int save(ExaminationRoomDO examinationRoom){
		return examinationRoomDao.save(examinationRoom);
	}
	
	
	public int update(ExaminationRoomDO examinationRoom){
		return examinationRoomDao.updateById(examinationRoom);
	}
	
	
	public int remove(Long id){
		return examinationRoomDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return examinationRoomDao.batchRemoveByIds(ids);
	}
	
}
