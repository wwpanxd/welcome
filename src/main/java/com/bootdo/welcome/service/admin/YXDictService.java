package com.bootdo.welcome.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
	
    public Map<Integer,List<YXDictDO>> getTypeInLists( Integer uvcode, List<String> types){
		List<YXDictDO> yxddolist=dictDao.findListByUVCodeAndTypeIn(uvcode,types);
		Map<Integer,List<YXDictDO>> map_dict= new HashMap<Integer,List<YXDictDO>>();
		for(YXDictDO yxdictdo:yxddolist) {
			if(!map_dict.containsKey(yxdictdo.getCode())) map_dict.put(yxdictdo.getCode(), new ArrayList<YXDictDO>());
		   
			map_dict.get(yxdictdo.getCode()).add(yxdictdo);
		}
    	return map_dict;
    }
}
