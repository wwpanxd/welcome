package com.bootdo.system.dao;

import com.bootdo.system.domain.AppDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * app版本更新表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-20 01:50:52
 */
@Mapper
public interface AppDao {

	AppDO get(Integer id);
	
	AppDO getlast();
	
	List<AppDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AppDO app);
	
	int update(AppDO app);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
