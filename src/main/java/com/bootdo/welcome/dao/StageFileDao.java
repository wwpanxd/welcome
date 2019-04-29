package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StageFileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 迎新阶段文件表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-29 11:42:24
 */
@Mapper
public interface StageFileDao {

	StageFileDO findOneById(Long id);
	
	List<StageFileDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StageFileDO stageFile);
	
	int updateById(StageFileDO stageFile);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
