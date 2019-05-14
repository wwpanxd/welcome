package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuFamilyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生家长信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:18:57
 */
@Mapper
public interface StuFamilyDao {

	StuFamilyDO findOneById(Long id);
	
	List<StuFamilyDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuFamilyDO stuFamily);
	
	int updateById(StuFamilyDO stuFamily);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
