package com.bootdo.system.dao;

import com.bootdo.system.domain.FileDataDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件数据表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface FileDataDao {

	FileDataDO findOneById(Long id);
	
	FileDataDO getbyfname(String fname);
	
	List<FileDataDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(FileDataDO fileData);
	
	int updateById(FileDataDO fileData);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
