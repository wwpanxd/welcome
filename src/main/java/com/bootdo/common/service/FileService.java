package com.bootdo.common.service;

import com.bootdo.common.config.BootdoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.bootdo.common.dao.FileDao;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


@Service
public class FileService {
	@Autowired
	private FileDao sysFileMapper;

	@Autowired
	private BootdoConfig bootdoConfig;
	
	public FileDO findOneById(Long id){
		return sysFileMapper.findOneById(id);
	}
	
	
	public List<FileDO> findPageListByMap(Map<String, Object> map){
		return sysFileMapper.findPageListByMap(map);
	}
	
	
	public int countByMap(Map<String, Object> map){
		return sysFileMapper.countByMap(map);
	}
	
	
	public int save(FileDO sysFile){
		return sysFileMapper.save(sysFile);
	}
	
	
	public int updateById(FileDO sysFile){
		return sysFileMapper.updateById(sysFile);
	}
	
	
	public int removeById(Long id){
		return sysFileMapper.removeById(id);
	}
	
	
	public int batchRemoveByIds(Long[] ids){
		return sysFileMapper.batchRemoveByIds(ids);
	}

    
    public Boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = bootdoConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}
	}
