package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXPlusDO;

/**
 * 插件信息表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface YXPlusDao {

	YXPlusDO findOneById(Long pId);
	
	List<YXPlusDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXPlusDO plus);
	
	int updateById(YXPlusDO plus);
	
	int removeById(Long p_id);
	
	int batchRemoveByIds(Long[] pIds);
}
