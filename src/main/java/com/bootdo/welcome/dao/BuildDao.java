package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.BuildDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 宿舍楼宇信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@Mapper
public interface BuildDao {

	BuildDO findOneById(Long id);
	
	List<BuildDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(BuildDO build);
	
	int updateById(BuildDO build);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
