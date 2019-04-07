package com.bootdo.welcome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.WdverDO;

/**
 * 单词版本更新表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 19:13:17
 */
@Mapper
public interface WdverDao {

	WdverDO get(Integer id);
	
	List<WdverDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WdverDO wdver);
	
	int update(WdverDO wdver);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
