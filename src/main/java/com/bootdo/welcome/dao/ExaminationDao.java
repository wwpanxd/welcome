package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ExaminationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 普教考试任务表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@Mapper
public interface ExaminationDao {

	ExaminationDO findOneById(Long id);
	
	List<ExaminationDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ExaminationDO examination);
	
	int updateById(ExaminationDO examination);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
