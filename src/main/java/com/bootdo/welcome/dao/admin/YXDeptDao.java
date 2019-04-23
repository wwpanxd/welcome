package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXDeptDO;

/**
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@Mapper
public interface YXDeptDao {

	YXDeptDO findOneById(Long id);
	
	List<YXDeptDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXDeptDO dept);
	
	int updateById(YXDeptDO dept);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
