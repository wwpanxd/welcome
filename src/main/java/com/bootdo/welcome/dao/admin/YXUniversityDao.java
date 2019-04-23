package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXUniversityDO;

/**
 * 迎新学校基础信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface YXUniversityDao {

	YXUniversityDO findOneById(Long id);
	
	List<YXUniversityDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXUniversityDO university);
	
	int updateById(YXUniversityDO university);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
