package com.bootdo.common.service;

import com.bootdo.system.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bootdo.common.dao.DictDao;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;


@Service
public class DictService {
    @Autowired
    private DictDao dictDao;

    
    public DictDO findOneById(Long id) {
        return dictDao.findOneById(id);
    }

    
    public List<DictDO> findPageListByMap(Map<String, Object> map) {
        return dictDao.findPageListByMap(map);
    }

    
    public int countByMap(Map<String, Object> map) {
        return dictDao.countByMap(map);
    }

    
    public int save(DictDO dict) {
        return dictDao.save(dict);
    }

    
    public int updateById(DictDO dict) {
        return dictDao.updateById(dict);
    }

    
    public int removeById(Long id) {
        return dictDao.removeById(id);
    }

    
    public int batchRemoveByIds(Long[] ids) {
        return dictDao.batchRemoveByIds(ids);
    }

    

    public List<DictDO> listType() {
        return dictDao.listType();
    }

    
    public String getName(String type, String value) {
        Map<String, Object> param = new HashMap<String, Object>(16);
        param.put("type", type);
        param.put("value", value);
        String rString = dictDao.findPageListByMap(param).get(0).getName();
        return rString;
    }

    
    public List<DictDO> getHobbyList(UserDO userDO) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "hobby");
        List<DictDO> hobbyList = dictDao.findPageListByMap(param);

        return hobbyList;
    }
    
    public List<DictDO> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return dictDao.findPageListByMap(param);
    }

    public List<DictDO> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return dictDao.findPageListByMap(param);
    }
	
	public List<DictDO> list2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		  return dictDao.list2(map);
	}

}
