package com.bootdo.system.dao;

import com.bootdo.system.domain.DeptDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface DeptDao {

	DeptDO findOneById(Long deptId);
	
	List<DeptDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(DeptDO dept);
	
	int updateById(DeptDO dept);
	
	int removeById(Long dept_id);
	
	int batchRemoveByIds(Long[] deptIds);
		
	Long[] listParentDept();
	
	int getDeptUserNumber(Long deptId);
	
	int getDeptStaffNumber(Long deptId);
}
