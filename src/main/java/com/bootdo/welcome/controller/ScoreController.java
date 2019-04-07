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
import com.bootdo.welcome.domain.ScoreDO;
import com.bootdo.welcome.service.ScoreService;

/**
 * 答题结果记录表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 19:13:17
 */
 
@Controller
@RequestMapping("/learns/score")
public class ScoreController extends BaseController{
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping()
	@RequiresPermissions("learns:score:score")
	String Score(){
	    return "learns/score/score";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("learns:score:score")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ScoreDO> scoreList = scoreService.list(query);
		int total = scoreService.count(query);
		PageUtils pageUtils = new PageUtils(scoreList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("learns:score:add")
	String add(){
	    return "learns/score/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("learns:score:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ScoreDO score = scoreService.get(id);
		model.addAttribute("score", score);
	    return "learns/score/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("learns:score:add")
	public R save( ScoreDO score){
		if(score.getUid()==null) score.setUid(getUserId().intValue());
		if(score.getPtime()==null) score.setPtime(System.currentTimeMillis());
		if(scoreService.save(score)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("learns:score:edit")
	public R update( ScoreDO score){
		scoreService.update(score);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("learns:score:remove")
	public R remove( Integer id){
		if(scoreService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("learns:score:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		scoreService.batchRemove(ids);
		return R.ok();
	}
	
}
