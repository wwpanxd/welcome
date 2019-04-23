package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXMenuDO;

/**
 * 菜单管理
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface YXMenuDao {

	YXMenuDO findOneById(Long mid);
	
	List<YXMenuDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXMenuDO menu);
	
	int updateById(YXMenuDO menu);
	
	int removeById(Long mid);
	
	int batchRemoveByIds(Long[] mids);
}
