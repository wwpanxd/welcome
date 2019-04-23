package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.welcome.dao.ChannelDao;
import com.bootdo.welcome.domain.ChannelDO;
import com.bootdo.welcome.service.ChannelService;


@Service
public class ChannelService  {
	@Autowired
	private ChannelDao channelDao;
	
	
	public ChannelDO get(Long id){
		return channelDao.findOneById(id);
	}
	
	
	public List<ChannelDO> list(Map<String, Object> map){
		return channelDao.findPageListByMap(map);
	}
	
	
	public int count(Map<String, Object> map){
		return channelDao.countByMap(map);
	}
	
	
	public int save(ChannelDO channel){
		return channelDao.save(channel);
	}
	
	
	public int update(ChannelDO channel){
		return channelDao.updateById(channel);
	}
	
	
	public int remove(Long id){
		return channelDao.removeById(id);
	}
	
	
	public int batchRemove(Long[] ids){
		return channelDao.batchRemoveByIds(ids);
	}
	
}
