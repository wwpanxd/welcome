package com.bootdo.common.dao;

import com.bootdo.common.domain.LogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface LogDao {

	LogDO findOneById(Long id);
	
	List<LogDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(LogDO log);
	
	int updateById(LogDO log);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
