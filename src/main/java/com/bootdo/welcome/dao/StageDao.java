package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StageDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 迎新阶段表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface StageDao {

	StageDO findOneById(Long id);
	
	List<StageDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StageDO stage);
	
	int updateById(StageDO stage);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
