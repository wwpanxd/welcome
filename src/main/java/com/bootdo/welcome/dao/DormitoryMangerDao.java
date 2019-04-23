package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.DormitoryMangerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 宿舍管理员表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface DormitoryMangerDao {

	DormitoryMangerDO findOneById(Long id);
	
	List<DormitoryMangerDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(DormitoryMangerDO dormitoryManger);
	
	int updateById(DormitoryMangerDO dormitoryManger);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
