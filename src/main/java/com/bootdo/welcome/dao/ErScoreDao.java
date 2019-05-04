package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ErScoreDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@Mapper
public interface ErScoreDao {

	ErScoreDO findOneById(Long id);
	
	List<ErScoreDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ErScoreDO erScore);
	
	int updateById(ErScoreDO erScore);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
