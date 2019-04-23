package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ChannelDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 迎新通道表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@Mapper
public interface ChannelDao {

	ChannelDO findOneById(Long id);
	
	List<ChannelDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ChannelDO channel);
	
	int updateById(ChannelDO channel);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
