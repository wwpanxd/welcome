package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.system.domain.AppDO;
import com.bootdo.system.service.AppService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * app版本更新表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-20 01:50:52
 */
 
@Controller
@RequestMapping("/system/app")
public class AppController extends BaseController{
	@Autowired
	private AppService appService;
	
	
	@GetMapping("/download")
	String edit(Model model){
		
		AppDO ado=	appService.getlast();
		model.addAttribute("url", ado.getUrl());
	    return "system/app/appdownload";
	}
	
	@GetMapping("/upload")
	String upload(Model model){
		
		AppDO ado=	appService.getlast();
		model.addAttribute("url_uploadone","http://"+ StringUtils.substringBetween(ado.getUrl(), "http://", "/")+"/welcome/publish/system/file/upload/one");
		model.addAttribute("url_uploadbatch","http://"+ StringUtils.substringBetween(ado.getUrl(), "http://", "/")+"/welcome/publish/system/file/upload/batch");
		model.addAttribute("url_show","http://"+ StringUtils.substringBetween(ado.getUrl(), "http://", "/")+"/welcome/publish/system/file/show/xxx.png");
		model.addAttribute("url_download","http://"+ StringUtils.substringBetween(ado.getUrl(), "http://", "/")+"/welcome/publish/system/file/download/xxx.apk");
	    return "system/app/upload";
	}
	
	@GetMapping()
	@RequiresPermissions("system:app:app")
	String App(){
	    return "system/app/app";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:app:app")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AppDO> appList = appService.list(query);
		int total = appService.count(query);
		PageUtils pageUtils = new PageUtils(appList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:app:add")
	String add(){
	    return "system/app/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:app:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AppDO app = appService.get(id);
		model.addAttribute("app", app);
	    return "system/app/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:app:add")
	public R save( AppDO app){
		if(appService.save(app)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:app:edit")
	public R update( AppDO app){
		appService.update(app);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:app:remove")
	public R remove( Long id){
		if(appService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:app:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		appService.batchRemove(ids);
		return R.ok();
	}
	
}
