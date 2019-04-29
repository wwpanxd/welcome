package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bootdo.welcome.domain.admin.YXUserDO;

/**
 * 迎新用户表,所有用户
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface YXUserDao {

	YXUserDO findOneById(Long id);
	
	YXUserDO findOneByLoginNameAndUVCode(@Param("loginname") String loginname,@Param("uvcode") Integer uvcode);
	
	List<YXUserDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXUserDO user);
	
	int updateById(YXUserDO user);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
