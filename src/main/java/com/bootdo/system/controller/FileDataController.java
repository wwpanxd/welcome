package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.system.domain.FileDataDO;
import com.bootdo.system.service.FileDataService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 文件数据表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-01-20 01:50:52
 */
 
@Controller
@RequestMapping("/system/fileData")
public class FileDataController extends BaseController{
	@Autowired
	private FileDataService fileDataService;
	
	@GetMapping()
	@RequiresPermissions("system:fileData:fileData")
	String FileData(){
	    return "system/fileData/fileData";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:fileData:fileData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FileDataDO> fileDataList = fileDataService.list(query);
		int total = fileDataService.count(query);
		PageUtils pageUtils = new PageUtils(fileDataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:fileData:add")
	String add(){
	    return "system/fileData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:fileData:edit")
	String edit(@PathVariable("id") Long id,Model model){
		FileDataDO fileData = fileDataService.get(id);
		model.addAttribute("fileData", fileData);
	    return "system/fileData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:fileData:add")
	public R save( FileDataDO fileData){
		if(fileDataService.save(fileData)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:fileData:edit")
	public R update( FileDataDO fileData){
		fileDataService.update(fileData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:fileData:remove")
	public R remove( Long id){
		if(fileDataService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:fileData:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fileDataService.batchRemove(ids);
		return R.ok();
	}
	
}
