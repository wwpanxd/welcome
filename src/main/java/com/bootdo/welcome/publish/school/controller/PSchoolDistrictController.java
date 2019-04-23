package com.bootdo.welcome.publish.school.controller;

import com.bootdo.welcome.vo.SchoolDistrictVO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.welcome.domain.SchoolDistrictDO;
import com.bootdo.welcome.vo.DeletedStringIdVO;
import com.bootdo.welcome.vo.FindStringIdVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/welcome/publish/school/district")
public class PSchoolDistrictController extends BaseController {
	@Log("获取所有的校区")
	@GetMapping(value = "/all")
	@ResponseBody
	@ApiOperation(value = "获取所有的校区", notes = "获取所有的校区")
	@ApiResponses({
			@ApiResponse(response = SchoolDistrictDO.class, code = 200, message = "返回结构:SchoolDistrictDO的list") })
	public R getAll() {
		List<SchoolDistrictDO> list = new ArrayList<SchoolDistrictDO>();
		for (int i = 1; i < 10; i++) {
			SchoolDistrictDO schoolDistrictDO = new SchoolDistrictDO();
			schoolDistrictDO.setId(i);
			schoolDistrictDO.setSchoolName("学校" + i);
			schoolDistrictDO.setSchoolCode("学校编码" + i);
			schoolDistrictDO.setSchoolAddress("山西省太原市");
			list.add(schoolDistrictDO);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}

	@Log("获取某个校区")
	@ResponseBody
	@GetMapping(value = "/get")
	@ApiOperation(value = "获取某个校区", notes = "提交校区编号来获取某个校区")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "schoolcode", value = "校区编号", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = SchoolDistrictDO.class, code = 200, message = "返回结构:SchoolDistrictDO") })
	public R get(FindStringIdVO findStringId) {
		SchoolDistrictDO schoolDistrictDO = new SchoolDistrictDO();
		schoolDistrictDO.setId(1);
		schoolDistrictDO.setSchoolName("学校名称");
		schoolDistrictDO.setSchoolCode("学校编码");
		schoolDistrictDO.setSchoolAddress("山西省太原市");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", schoolDistrictDO);
		return R.ok(map);
	}

	@Log("新增校区")
	@ResponseBody
	@PostMapping(value = "/add")
	@ApiOperation(value = "新增某个校区", notes = "提交校区编号、校区名字、校区地址来更新校区")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public R add(SchoolDistrictVO schoolDistrictVO) {
		return R.ok();
	}

	@Log("更新校区")
	@ResponseBody
	@PostMapping(value = "update")
	@ApiOperation(value = "更新某个校区", notes = "提交校区编号、校区名字、校区地址来更新校区")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public R update(SchoolDistrictDO schoolDistrictDO) {
		return R.ok();
	}

	@Log("删除校区")
	@ResponseBody
	@PostMapping(value = "/delete")
	@ApiOperation(value = "删除某个校区", notes = "通过学校编码进行删除某个校区")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "schoolcode", value = "校区编号", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public R delete(DeletedStringIdVO deletedStringIdVO) {
		return R.ok();
	}
}
