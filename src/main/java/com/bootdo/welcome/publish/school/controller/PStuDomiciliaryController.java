package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.annotation.Log;
import com.bootdo.welcome.domain.AchievementDO;
import com.bootdo.welcome.domain.RuleDO;
import com.bootdo.welcome.domain.StuDomiciliaryDO;
import com.bootdo.welcome.utils.PPageUtils;
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
@RequestMapping("/welcome/studomiciliary")
@Api(value = "学生户籍服务相关", description = "学生户籍服务相关")
public class PStuDomiciliaryController {
	static Logger log = LoggerFactory.getLogger(PStuDomiciliaryController.class);

	@Log("获取学生户籍列表")
	@GetMapping("/list")
	@ApiOperation(value = "获取学生户籍列表", notes = "获取学生户籍列表")
	@ApiResponses({
			@ApiResponse(response = StuDomiciliaryDO.class, code = 200, message = "返回结构:StuDomiciliaryDO的list") })
	public List<StuDomiciliaryDO> getList(@RequestParam StuDomiciliaryDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		List<StuDomiciliaryDO> list = new ArrayList<>();
		return list;
	}

	@Log("获取学生户籍分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value = "获取学生户籍分页列表", notes = "获取学生户籍分页列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = StuDomiciliaryDO.class, code = 200, message = "返回结构:StuDomiciliaryDO.class") })
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam StuDomiciliaryDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);// 数据偏移量
		params.put("size", size);// 每页条数
		params.put("sort", "id");// 每页条数
		params.put("order", "asc");// 每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件

//		PQuery query = new PQuery(params);
//		int total = ruleService.count(query);
		List<StuDomiciliaryDO> list = new ArrayList<>();
		PPageUtils pageUtil = new PPageUtils(list, 10, page, size);
		return pageUtil;
	}

	@Log("添加获取学生户籍")
	@PostMapping("/save")
	@ApiOperation(value = "添加获取学生户籍", notes = "添加获取学生户籍" + "入参Rule，是StuDomiciliaryDO类")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR save(@RequestBody StuDomiciliaryDO rule) {
		// 异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		return PR.ok("添加学生成绩成功");
	}

	@Log("修改学生户籍信息")
	@PostMapping("/update")
	@ApiOperation(value = "修改学生户籍", notes = "修改学生户籍" + "入参Rule，是StuDomiciliaryDO类")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR update(@RequestBody StuDomiciliaryDO rule) {

		// 异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		

		return PR.ok("修改学生成绩成功");
	}

	@Log("删除学生户籍信息")
	@PostMapping("/remove")
	@ApiOperation(value = "删除学生户籍信息", notes = "删除学生户籍信息,入参是学生户籍id")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody DeletedIdVO vid) {
		return PR.ok("删除学生户籍信息成功");
	}

	@Log("批量删除学生户籍信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value = "批量删除学生户籍信息", notes = "批量删除学生户籍信息")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody BatchRemoveInput bids) {
		return PR.ok("批量删除学生户籍信息成功");
	}
}
