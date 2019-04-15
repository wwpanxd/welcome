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
import com.bootdo.welcome.domain.SchoolGradesDO;
import com.bootdo.welcome.domain.SchoolProfessionDO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/welcome/publish/school/grades")
public class PSchoolGradesController extends BaseController {
	@GetMapping("all")
	@ResponseBody
	@ApiOperation(value = "获取所有的班级", notes = "获取所有的班级")
	@ApiResponses({ @ApiResponse(response = SchoolGradesDO.class, code = 200, message = "返回结构:SchoolGradesDO的list") })
	public R getAll() {
		List<SchoolGradesDO> list = new ArrayList<SchoolGradesDO>();
		for (int i = 1; i < 10; i++) {
			SchoolGradesDO schoolGradesDO = new SchoolGradesDO();
			schoolGradesDO.setName("班级名字" + i);
			schoolGradesDO.setHeadMaster("班主任名字" + i);
			schoolGradesDO.setHeadMasterPhone("13027017068");
			schoolGradesDO.setUserCount(50);
			list.add(schoolGradesDO);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}

	@GetMapping("get")
	@ResponseBody
	@ApiOperation(value = "获取某个班级", notes = "获取某个班级")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gradesid", value = "班级id", required = true, dataType = "Long", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = SchoolGradesDO.class, code = 200, message = "返回结构:SchoolGradesDO的对象") })
	public R find(@RequestParam("gradesid") Long gradesid) {
		SchoolGradesDO schoolGradesDO = new SchoolGradesDO();
		schoolGradesDO.setName("班级名字");
		schoolGradesDO.setHeadMaster("班主任名字");
		schoolGradesDO.setHeadMasterPhone("13027017068");
		schoolGradesDO.setUserCount(50);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", schoolGradesDO);
		return R.ok(map);
	}

	@PostMapping("add")
	@ResponseBody
	@ApiOperation(value = "增加一个班级", notes = "增加一个班级")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "班级名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userCount", value = "学生人数", required = false, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "headMaster", value = "班主任名字", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "headMasterPhone", value = "班主任电话", required = false, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R add(@RequestParam("name") String name, @RequestParam("userCount") Long userCount,
			@RequestParam("headMaster") String headMaster, @RequestParam("headMasterPhone") String headMasterPhone) {
		return R.ok();
	}

	@PostMapping("update")
	@ResponseBody
	@ApiOperation(value = "更新某个班级", notes = "更新某个班级")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gradesid", value = "班级id", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "班级名称", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userCount", value = "学生人数", required = false, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "headMaster", value = "班主任名字", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "headMasterPhone", value = "班主任电话", required = false, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R update(@RequestParam("gradesid") String gradesid, @RequestParam("name") String name,
			@RequestParam("userCount") Long userCount, @RequestParam("headMaster") String headMaster,
			@RequestParam("headMasterPhone") String headMasterPhone) {
		return R.ok();
	}

	@PostMapping("delete")
	@ResponseBody
	@ApiOperation(value = "删除某个班级", notes = "删除某个班级")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gradesid", value = "班级id", required = true, dataType = "Long", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R delete(@RequestParam("gradesid") Long gradesid) {
		return R.ok();
	}
}
