package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ExpendsSubjectsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 缴费科目表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface ExpendsSubjectsDao {

	ExpendsSubjectsDO findOneById(Long id);
	
	List<ExpendsSubjectsDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ExpendsSubjectsDO expendsSubjects);
	
	int updateById(ExpendsSubjectsDO expendsSubjects);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
