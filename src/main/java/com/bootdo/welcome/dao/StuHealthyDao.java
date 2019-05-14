package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuHealthyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生健康信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:19:06
 */
@Mapper
public interface StuHealthyDao {

	StuHealthyDO findOneById(Long id);
	
	List<StuHealthyDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuHealthyDO stuHealthy);
	
	int updateById(StuHealthyDO stuHealthy);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
