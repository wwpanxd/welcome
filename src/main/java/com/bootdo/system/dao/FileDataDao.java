package com.bootdo.system.dao;

import com.bootdo.system.domain.FileDataDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件数据表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-20 01:50:52
 */
@Mapper
public interface FileDataDao {

	FileDataDO get(Integer id);
	
	FileDataDO getbyfname(String fname);
	
	List<FileDataDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FileDataDO fileData);
	
	int update(FileDataDO fileData);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
