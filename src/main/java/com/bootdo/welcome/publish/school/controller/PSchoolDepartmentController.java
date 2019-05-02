package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.utils.R;
import com.bootdo.system.vo.DeletedIdVO;
import com.bootdo.welcome.domain.SchoolDepartmentDO;
import com.bootdo.welcome.vo.FindIdVO;
import com.bootdo.welcome.vo.SchoolDepartmentVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/welcome/publish/school/department")
public class PSchoolDepartmentController {
	@GetMapping("all")
	@ResponseBody
	@ApiOperation(value = "获取所有的院系", notes = "获取所有的院系")
	@ApiResponses({
			@ApiResponse(response = SchoolDepartmentDO.class, code = 200, message = "返回结构:SchoolDepartmentDO的list") })
	public R getAll() {
		List<SchoolDepartmentDO> list = new ArrayList<SchoolDepartmentDO>();
		for (int i = 1; i < 10; i++) {
			SchoolDepartmentDO schoolDepartmentDO = new SchoolDepartmentDO();
			schoolDepartmentDO.setDepartmentCode("院系编码" + i);
			schoolDepartmentDO.setSchoolCode("学校编码" + i);
			schoolDepartmentDO.setDepartmentName("院系名称" + i);
			schoolDepartmentDO.setDepartmentPhone("13027017069");
			list.add(schoolDepartmentDO);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}

	@GetMapping("get")
	@ResponseBody
	@ApiOperation(value = "获取某个院系", notes = "获取某个院系")
	@ApiResponses({
			@ApiResponse(response = SchoolDepartmentDO.class, code = 200, message = "返回结构:SchoolDepartmentDO的对象") })
	public R find(FindIdVO findId) {
		SchoolDepartmentDO schoolDepartmentDO = new SchoolDepartmentDO();
		schoolDepartmentDO.setDepartmentCode("院系编码");
		schoolDepartmentDO.setSchoolCode("学校编码");
		schoolDepartmentDO.setDepartmentName("院系名称");
		schoolDepartmentDO.setDepartmentPhone("13027017069");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", schoolDepartmentDO);
		return R.ok(map);
	}

	@PostMapping("add")
	@ResponseBody
	@ApiOperation(value = "新增一个院系", notes = "新增一个院系")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R add(SchoolDepartmentVO schoolDepartmentVO) {
		return R.ok();
	}

	@PostMapping("update")
	@ResponseBody
	@ApiOperation(value = "更新某个院系", notes = "更新某个院系")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R update(SchoolDepartmentDO schoolDepartmentDO) {
		return R.ok();
	}

	@PostMapping("delete")
	@ResponseBody
	@ApiOperation(value = "删除某个院系", notes = "删除某个院系")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "departmentcode", value = "院系编号", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R delete(DeletedIdVO deletedIdVO) {
		return R.ok();
	}
}
