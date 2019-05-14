package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuScoreDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生成绩表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:19:14
 */
@Mapper
public interface StuScoreDao {

	StuScoreDO findOneById(Long id);
	
	List<StuScoreDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuScoreDO stuScore);
	
	int updateById(StuScoreDO stuScore);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
