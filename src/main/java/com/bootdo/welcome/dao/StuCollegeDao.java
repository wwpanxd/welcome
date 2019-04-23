package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuCollegeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学生和院系机构的关联表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface StuCollegeDao {

	StuCollegeDO findOneById(Long id);
	
	List<StuCollegeDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuCollegeDO stuCollege);
	
	int updateById(StuCollegeDO stuCollege);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
