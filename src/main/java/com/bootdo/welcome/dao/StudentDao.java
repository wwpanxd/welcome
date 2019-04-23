package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StudentDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学生基础信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface StudentDao {

	StudentDO findOneById(Long id);
	
	List<StudentDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StudentDO student);
	
	int updateById(StudentDO student);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
