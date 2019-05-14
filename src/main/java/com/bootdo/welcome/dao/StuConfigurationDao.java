package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuConfigurationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生信息采集配置表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:18:36
 */
@Mapper
public interface StuConfigurationDao {

	StuConfigurationDO findOneById(Long id);
	
	List<StuConfigurationDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuConfigurationDO stuConfiguration);
	
	int updateById(StuConfigurationDO stuConfiguration);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
