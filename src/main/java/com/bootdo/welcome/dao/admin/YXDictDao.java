package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.bootdo.welcome.domain.admin.YXDictDO;

/**
 * 字典表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@Mapper
public interface YXDictDao {

	YXDictDO findOneById(Long id);
	
	List<YXDictDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXDictDO dict);
	
	int updateById(YXDictDO dict);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
	
	List<YXDictDO> listType(Integer uvCode);
}
