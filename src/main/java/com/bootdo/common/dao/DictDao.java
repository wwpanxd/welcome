package com.bootdo.common.dao;

import com.bootdo.common.domain.DictDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:52:54
 */
@Mapper
public interface DictDao {

	DictDO findOneById(Long id);

	List<DictDO> findPageListByMap(Map<String, Object> map);
	
	List<DictDO> list2(Map<String, Object> map);

	int countByMap(Map<String, Object> map);

	int save(DictDO dict);

	int updateById(DictDO dict);

	int removeById(Long id);

	int batchRemoveByIds(Long[] ids);

	List<DictDO> listType();
}
