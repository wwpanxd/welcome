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
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.system.vo.DeletedIdVO;
import com.bootdo.welcome.domain.SchoolDepartmentDO;
import com.bootdo.welcome.domain.SchoolGradesDO;
import com.bootdo.welcome.domain.SchoolProfessionDO;
import com.bootdo.welcome.vo.FindIdVO;
import com.bootdo.welcome.vo.SchoolGradesVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
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
	public R find(FindIdVO findIdVO) {
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
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R add(SchoolGradesVO schoolGradesVO) {
		return R.ok();
	}

	@PostMapping("update")
	@ResponseBody
	@ApiOperation(value = "更新某个班级", notes = "更新某个班级")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R update(SchoolGradesDO schoolGradesDO) {
		return R.ok();
	}

	@PostMapping("delete")
	@ResponseBody
	@ApiOperation(value = "删除某个班级", notes = "删除某个班级")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R delete(DeletedIdVO deletedIdVO) {
		return R.ok();
	}
}
