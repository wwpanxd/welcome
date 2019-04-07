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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.welcome.domain.WdverDO;
import com.bootdo.welcome.service.WdverService;

/**
 * 单词版本更新表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 19:13:17
 */
 
@Controller
@RequestMapping("/learns/wdver")
public class WdverController extends BaseController{
	@Autowired
	private WdverService wdverService;
	
	@GetMapping()
	@RequiresPermissions("learns:wdver:wdver")
	String Wdver(){
	    return "learns/wdver/wdver";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("learns:wdver:wdver")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WdverDO> wdverList = wdverService.list(query);
		int total = wdverService.count(query);
		PageUtils pageUtils = new PageUtils(wdverList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("learns:wdver:add")
	String add(){
	    return "learns/wdver/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("learns:wdver:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WdverDO wdver = wdverService.get(id);
		model.addAttribute("wdver", wdver);
	    return "learns/wdver/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("learns:wdver:add")
	public R save( WdverDO wdver){
		if(wdver.getUtime()==null) wdver.setUtime(System.currentTimeMillis());
		if(wdverService.save(wdver)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("learns:wdver:edit")
	public R update( WdverDO wdver){
		wdverService.update(wdver);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("learns:wdver:remove")
	public R remove( Integer id){
		if(wdverService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("learns:wdver:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wdverService.batchRemove(ids);
		return R.ok();
	}
	
}
