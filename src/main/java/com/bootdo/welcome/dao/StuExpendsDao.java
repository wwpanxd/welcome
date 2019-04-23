package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuExpendsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生缴费信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface StuExpendsDao {

	StuExpendsDO findOneById(Long id);
	
	List<StuExpendsDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuExpendsDO stuExpends);
	
	int updateById(StuExpendsDO stuExpends);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
