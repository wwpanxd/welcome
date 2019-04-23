package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.PlanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 迎新计划表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface PlanDao {

	PlanDO findOneById(Long id);
	
	List<PlanDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(PlanDO plan);
	
	int updateById(PlanDO plan);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
