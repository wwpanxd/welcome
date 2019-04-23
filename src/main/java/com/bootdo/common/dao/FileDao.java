package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface FileDao {

	FileDO findOneById(Long id);
	
	List<FileDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(FileDO file);
	
	int updateById(FileDO file);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
