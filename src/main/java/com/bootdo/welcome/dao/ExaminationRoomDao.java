package com.bootdo.welcome.dao;

import com.bootdo.welcome.domain.ExaminationRoomDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 考场表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@Mapper
public interface ExaminationRoomDao {

	ExaminationRoomDO findOneById(Long id);
	
	List<ExaminationRoomDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(ExaminationRoomDO examinationRoom);
	
	int updateById(ExaminationRoomDO examinationRoom);
	
	int removeById(Long id);
	
	int batchRemoveByIds(Long[] ids);
}
