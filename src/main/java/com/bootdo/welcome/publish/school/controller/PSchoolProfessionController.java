package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.welcome.domain.SchoolDepartmentDO;
import com.bootdo.welcome.domain.SchoolProfessionDO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/welcome/publish/school/profession")
public class PSchoolProfessionController extends BaseController {
	@GetMapping("all")
	@ResponseBody
	@ApiOperation(value = "获取所有的专业", notes = "获取所有的专业")
	@ApiResponses({
			@ApiResponse(response = SchoolProfessionDO.class, code = 200, message = "返回结构:SchoolProfessionDO的list") })
	public R getAll() {
		List<SchoolProfessionDO> list = new ArrayList<SchoolProfessionDO>();
		for (int i = 1; i < 10; i++) {
			SchoolProfessionDO schoolProfessionDO = new SchoolProfessionDO();
			schoolProfessionDO.setProfessionName("专业名称" + i);
			list.add(schoolProfessionDO);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}

	@GetMapping("get")
	@ResponseBody
	@ApiOperation(value = "获取某个专业", notes = "获取某个专业")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "professionid", value = "专业id", required = true, dataType = "Long", paramType = "query"), })
	@ApiResponses({
			@ApiResponse(response = SchoolDepartmentDO.class, code = 200, message = "返回结构:SchoolDepartmentDO的对象") })
	public R find(@RequestParam("professionid") Long professionid) {
		SchoolProfessionDO schoolProfessionDO = new SchoolProfessionDO();
		schoolProfessionDO.setProfessionName("主页名称");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", schoolProfessionDO);
		return R.ok(map);
	}

	@PostMapping("add")
	@ResponseBody
	@ApiOperation(value = "增加一个专业", notes = "增加一个专业")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "professionname", value = "专业名称", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R add(@RequestParam("professionname") String professionname) {
		return R.ok();
	}

	@PostMapping("update")
	@ResponseBody
	@ApiOperation(value = "更新某个专业", notes = "更新某个专业")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "professionname", value = "专业名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "professionid", value = "专业id", required = true, dataType = "Long", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R update(@RequestParam("professionname") String professionname,
			@RequestParam("professionid") Long professionid) {
		return R.ok();
	}

	@PostMapping("delete")
	@ResponseBody
	@ApiOperation(value = "删除某个专业", notes = "删除某个专业")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "professionid", value = "专业id", required = true, dataType = "Long", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R delete(@RequestParam("professionid") Long professionid) {
		return R.ok();
	}
}
