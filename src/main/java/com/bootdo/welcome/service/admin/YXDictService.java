package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.admin.YXDictDao;
import com.bootdo.welcome.domain.admin.YXDictDO;
import com.bootdo.welcome.service.admin.YXDictService;


@Service
public class YXDictService  {
	@Autowired
	private YXDictDao dictDao;
	
	
	public YXDictDO get(Long id){
		return dictDao.findOneById(id);
	}
	
	
	public List<YXDictDO> list(Map<String, Object> map){
		return dictDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return dictDao.countByMap(map);
	}
	
	
	public int save(YXDictDO dict){
		return dictDao.save(dict);
	}
	
	
	public int update(YXDictDO dict){
		return dictDao.updateById(dict);
	}
	
	
	public int remove(Long id){
		return dictDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return dictDao.batchRemoveByIds(ids);
	}
	
    public List<YXDictDO> listType(Integer uvCode) {
        return dictDao.listType(uvCode);
    }
	
}
