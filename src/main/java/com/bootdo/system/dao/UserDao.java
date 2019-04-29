package com.bootdo.system.dao;

import com.bootdo.system.domain.UserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface UserDao {

	UserDO findOneById(Long userId);
	
	UserDO findOneByLoginName(String username);
	
	List<UserDO> findPageListByMap(Map<String,Object> map);
	
	List<UserDO> list2(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int count2(Map<String,Object> map);
	
	int save(UserDO user);
	
	int updateById(UserDO user);
	
	int removeById(Long userId);
	
	int batchRemoveByIds(Long[] userIds);
	
	Long[] listAllDept();

}
