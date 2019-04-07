package com.bootdo.welcome.publish.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.welcome.domain.WdverDO;
import com.bootdo.welcome.service.WdverService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("welcome/publish/wdver")
@Api(value="词库版本更新相关",description="词库版本更新相关")
public class PWdverController extends BaseController{

	@Autowired
	WdverService wdverservice;
	
	@Log("获取词库最新版本号")
	@GetMapping("/version")
	@ApiOperation(value="获取词库最新版本号", notes="获取词库最新版本号,判断是否需要更新词库")
	@ApiResponses({
		@ApiResponse( response = WdverDO.class, code = 200, message = "返回结构:WdverDO.class")
	})
	WdverDO getVersion() {
		Map<String,Object> pmap = new HashMap<String,Object>();
		pmap.put("islast",1);//
//		pmap.put("tcode","1");//分库后可以添加筛选
		List<WdverDO> wdlist=	wdverservice.list(pmap);
		
		if(wdlist!=null&&wdlist.size()>0)
			return wdlist.get(0);
		
		return new WdverDO(1,1,"CET-4","更新说明",1546932990000l);
	}	
}
