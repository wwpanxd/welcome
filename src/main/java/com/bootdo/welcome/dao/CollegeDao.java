package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.CollegeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学校院系机构
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@Mapper
public interface CollegeDao {

	CollegeDO findOneById(Long id);
	
	List<CollegeDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(CollegeDO college);
	
	int updateById(CollegeDO college);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
