package com.bootdo.welcome.service.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bootdo.welcome.dao.admin.YXMenuDao;
import com.bootdo.welcome.domain.admin.YXMenuDO;
import com.bootdo.welcome.service.admin.YXMenuService;


@Service
public class YXMenuService  {
	@Autowired
	private YXMenuDao menuDao;
	
	
	public YXMenuDO get(Long mid){
		return menuDao.findOneById(mid);
	}
	
	
	public List<YXMenuDO> list(Map<String, Object> map){
		return menuDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return menuDao.countByMap(map);
	}
	
	
	public int save(YXMenuDO menu){
		return menuDao.save(menu);
	}
	
	
	public int update(YXMenuDO menu){
		return menuDao.updateById(menu);
	}
	
	
	public int remove(Long mid){
		return menuDao.removeById(mid);
	}
	
	
	public int batchRemove(Long[] mids){
		return menuDao.batchRemoveByIds(mids);
	}
	
	public Set<String> listPerms(Long userId) {
		List<String> perms = menuDao.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}
	
}
