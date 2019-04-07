package com.bootdo.welcome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.ScoreDO;

/**
 * 答题结果记录表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 19:13:17
 */
@Mapper
public interface ScoreDao {

	ScoreDO get(Integer id);
	
	ScoreDO gettotalscore(Integer uid);
	
	List<ScoreDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ScoreDO score);
	
	int update(ScoreDO score);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
