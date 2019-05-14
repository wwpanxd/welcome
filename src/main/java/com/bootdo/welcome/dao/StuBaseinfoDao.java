package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuBaseinfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学生基础信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:17:59
 */
@Mapper
public interface StuBaseinfoDao {

	StuBaseinfoDO findOneById(Long id);
	
	List<StuBaseinfoDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuBaseinfoDO stuBaseinfo);
	
	int updateById(StuBaseinfoDO stuBaseinfo);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
