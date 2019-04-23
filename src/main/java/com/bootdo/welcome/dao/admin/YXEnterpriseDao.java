package com.bootdo.welcome.dao.admin;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.bootdo.welcome.domain.admin.YXEnterpriseDO;

/**
 * 注册企业学校表
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 13:25:56
 */
@Mapper
public interface YXEnterpriseDao {

	YXEnterpriseDO findOneById(Long uvId);
	
	List<YXEnterpriseDO> findPageListByMap(Map<String,Object> map);
	
	int countByMap(Map<String,Object> map);
	
	int save(YXEnterpriseDO enterprise);
	
	int updateById(YXEnterpriseDO enterprise);
	
	int removeById(Long uv_id);
	
	int batchRemoveByIds(Long[] uvIds);
}
