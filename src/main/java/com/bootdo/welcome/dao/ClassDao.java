package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ClassDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 班级表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@Mapper
public interface ClassDao {

	ClassDO findOneById(Long id);
	
	List<ClassDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ClassDO cldo);
	
	int updateById(ClassDO cldo);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
