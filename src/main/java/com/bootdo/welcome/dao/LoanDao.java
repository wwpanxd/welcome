package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.LoanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 新生贷款表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface LoanDao {

	LoanDO findOneById(Long id);
	
	List<LoanDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(LoanDO loan);
	
	int updateById(LoanDO loan);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
