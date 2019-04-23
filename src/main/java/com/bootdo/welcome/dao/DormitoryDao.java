package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.DormitoryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 宿舍表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface DormitoryDao {

	DormitoryDO findOneById(Long id);
	
	List<DormitoryDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(DormitoryDO dormitory);
	
	int updateById(DormitoryDO dormitory);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
