package com.bootdo.welcome.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.WordsDO;

/**
 * 英语单词记录表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 19:13:17
 */
@Mapper
public interface WordsDao {

	WordsDO get(Integer id);
	
	List<WordsDO> list(Map<String,Object> map);
	
	List<WordsDO> listin( List<String> tcodes);
	
	int count(Map<String,Object> map);
	
	int save(WordsDO words);
	
	int update(WordsDO words);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
