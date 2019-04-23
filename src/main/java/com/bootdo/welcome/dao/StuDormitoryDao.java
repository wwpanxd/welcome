package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.StuDormitoryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学生宿舍对应表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:56:29
 */
@Mapper
public interface StuDormitoryDao {

	StuDormitoryDO findOneById(Long id);
	
	List<StuDormitoryDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(StuDormitoryDO stuDormitory);
	
	int updateById(StuDormitoryDO stuDormitory);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
