package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.AchievementDO;
import com.bootdo.welcome.domain.RuleDO;
import com.bootdo.welcome.service.RuleService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.BatchRemoveInput;
import com.bootdo.welcome.vo.DeletedIdVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/welcome/publish/stuachievement")
@Api(value = "学生成绩", description = "学生成绩")
public class PStuAchievementController {
	static Logger log = LoggerFactory.getLogger(PStuAchievementController.class);

	@Log("获取学生成绩列表")
	@GetMapping("/list")
	@ApiOperation(value = "获取学生成绩列表", notes = "获取学生成绩列表")
	@ApiResponses({ @ApiResponse(response = AchievementDO.class, code = 200, message = "返回结构:AchievementDO的list") })
	public List<AchievementDO> getList(@RequestParam AchievementDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		List<AchievementDO> list = new ArrayList<>();
		return list;
	}

	@Log("获取学生成绩分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value = "获取学生成绩分页列表", notes = "获取学生成绩分页列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = AchievementDO.class, code = 200, message = "返回结构:AchievementDO.class") })
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam RuleDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);// 数据偏移量
		params.put("size", size);// 每页条数
		params.put("sort", "id");// 每页条数
		params.put("order", "asc");// 每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件

//		PQuery query = new PQuery(params);
//		int total = ruleService.count(query);
		List<AchievementDO> list = new ArrayList<>();
		PPageUtils pageUtil = new PPageUtils(list, 10, page, size);
		return pageUtil;
	}

	@Log("添加学生成绩")
	@PostMapping("/save")
	@ApiOperation(value = "添加学生成绩", notes = "添加学生成绩" + "入参Rule，是AchievementDO类")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR save(@RequestBody AchievementDO rule) {
		// 异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		return PR.ok("添加学生成绩成功");
	}

	@Log("修改学生成绩信息")
	@PostMapping("/update")
	@ApiOperation(value = "修改学生成绩", notes = "修改学生成绩" + "入参Rule，是AchievementDO类")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR update(@RequestBody AchievementDO rule) {

		// 异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		

		return PR.ok("修改学生成绩成功");
	}

	@Log("删除学生成绩信息")
	@PostMapping("/remove")
	@ApiOperation(value = "删除学生成绩信息", notes = "删除学生成绩信息,入参是成绩id")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody DeletedIdVO vid) {
		return PR.ok("删除学生成绩成功");
	}

	@Log("批量删除学生成绩")
	@PostMapping("/batchRemove")
	@ApiOperation(value = "批量删除学生成绩", notes = "批量删除学生成绩")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody BatchRemoveInput bids) {
		return PR.ok("删除学生成绩成功");
	}
}
