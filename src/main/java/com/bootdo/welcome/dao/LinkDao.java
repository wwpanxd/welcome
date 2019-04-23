package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.LinkDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 迎新环节表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface LinkDao {

	LinkDO findOneById(Long id);
	
	List<LinkDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(LinkDO link);
	
	int updateById(LinkDO link);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
