package com.bootdo.system.dao;

import com.bootdo.system.domain.AppDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * app版本更新表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface AppDao {

	AppDO findOneById(Long id);
	
	AppDO findlastOne();
	
	List<AppDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(AppDO app);
	
	int updateById(AppDO app);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
