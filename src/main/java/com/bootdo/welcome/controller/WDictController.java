package com.bootdo.welcome.controller;

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

import com.bootdo.welcome.domain.admin.YXDictDO;
import com.bootdo.welcome.service.admin.YXDictService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 字典表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-02 09:39:40
 */
 
@Controller
@RequestMapping("/welcome/dict")
public class WDictController {
	@Autowired
	private YXDictService dictService;
	
	@GetMapping()
	@RequiresPermissions("welcome:dict:dict")
	String Dict(){
	    return "welcome/dict/dict";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("welcome:dict:dict")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YXDictDO> dictList = dictService.list(query);
		int total = dictService.count(query);
		PageUtils pageUtils = new PageUtils(dictList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("welcome:dict:add")
	String add(){
	    return "welcome/dict/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("welcome:dict:edit")
	String edit(@PathVariable("id") Long id,Model model){
		YXDictDO dict = dictService.get(id);
		model.addAttribute("dict", dict);
	    return "welcome/dict/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("welcome:dict:add")
	public R save( YXDictDO dict){
		if(dictService.save(dict)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("welcome:dict:edit")
	public R update( YXDictDO dict){
		dictService.update(dict);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("welcome:dict:remove")
	public R remove( Long id){
		if(dictService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("welcome:dict:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		dictService.batchRemove(ids);
		return R.ok();
	}
	
}
