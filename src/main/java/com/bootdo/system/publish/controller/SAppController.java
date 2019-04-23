package com.bootdo.system.publish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.annotation.Log;
import com.bootdo.system.domain.AppDO;
import com.bootdo.system.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("welcome/publish/sys/app")
@Api(value="app更新检查",description="app更新检查")
public class SAppController {
	
	@Autowired
	AppService appservice;
	
	@Log("APP更新检查")
	@ResponseBody
	@GetMapping("/app/update")
	@ApiOperation(value="APP更新检查", notes="APP更新检查")
	@ApiResponses({
		@ApiResponse( response = AppDO.class, code = 200, message = "返回结构:AppInfoDO.class")
	})
	AppDO getAppVersion() {
	AppDO ado=	appservice.getlast();
	if(ado!=null)
		return new AppDO(ado.getVer(),ado.getUpdate(),ado.getUrl(),ado.getInfo(),ado.getUtime());
	else
	   return new AppDO(100,0,"/download/url","更新说明",1546932990000l);
	}
	
	
	@Log("APP更新检查")
	@GetMapping("/download")
	@ApiOperation(value="APP下载界面", notes="APP下载界面")
	String edit(Model model){
		
		AppDO ado=	appservice.getlast();
		model.addAttribute("url", ado.getUrl());
	    return "system/app/appdownload";
	}
}
