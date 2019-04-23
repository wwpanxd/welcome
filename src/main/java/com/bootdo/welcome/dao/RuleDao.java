package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.RuleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 规则表(批量建班规则、分班规则、分宿规则、学号规则、考试分班规则)
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface RuleDao {

	RuleDO findOneById(Long id);
	
	List<RuleDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(RuleDO rule);
	
	int updateById(RuleDO rule);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
