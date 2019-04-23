package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuExpendsDetailsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生缴费明细表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface StuExpendsDetailsDao {

	StuExpendsDetailsDO findOneById(Long id);
	
	List<StuExpendsDetailsDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuExpendsDetailsDO stuExpendsDetails);
	
	int updateById(StuExpendsDetailsDO stuExpendsDetails);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
