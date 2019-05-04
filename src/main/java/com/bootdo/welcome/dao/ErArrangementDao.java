package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ErArrangementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 考场分配表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@Mapper
public interface ErArrangementDao {

	ErArrangementDO findOneById(Long id);
	
	List<ErArrangementDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ErArrangementDO erArrangement);
	
	int updateById(ErArrangementDO erArrangement);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
