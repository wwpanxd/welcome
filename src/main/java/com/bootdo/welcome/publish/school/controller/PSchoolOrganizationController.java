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
import com.bootdo.welcome.domain.SchoolOrganizationDO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/welcome/publish/school/organization")
public class PSchoolOrganizationController extends BaseController {
	@GetMapping("all")
	@ResponseBody
	@ApiOperation(value = "获取所有的机构", notes = "获取所有的机构")
	@ApiResponses({
			@ApiResponse(response = SchoolOrganizationDO.class, code = 200, message = "返回结构:SchoolOrganizationDO的list") })
	public R getAll() {
		List<SchoolOrganizationDO> list = new ArrayList<SchoolOrganizationDO>();
		for (int i = 1; i < 10; i++) {
			SchoolOrganizationDO schoolOrganizationDO = new SchoolOrganizationDO();
			schoolOrganizationDO.setName("机构名字" + i);
			schoolOrganizationDO.setType(i);
			schoolOrganizationDO.setId(i);
			schoolOrganizationDO.setParentId(10*i);
			list.add(schoolOrganizationDO);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}

	@GetMapping("get")
	@ResponseBody
	@ApiOperation(value = "获取某个机构", notes = "获取某个机构")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "oid", value = "机构id", required = true, dataType = "Long", paramType = "query"), })
	@ApiResponses({
			@ApiResponse(response = SchoolOrganizationDO.class, code = 200, message = "返回结构:SchoolOrganizationDO的对象") })
	public R find(@RequestParam("oid") Long oid) {
		SchoolOrganizationDO schoolOrganizationDO = new SchoolOrganizationDO();
		schoolOrganizationDO.setName("机构名字");
		schoolOrganizationDO.setType(1);
		schoolOrganizationDO.setId(1);
		schoolOrganizationDO.setParentId(10);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", schoolOrganizationDO);
		return R.ok(map);
	}

	@PostMapping("add")
	@ResponseBody
	@ApiOperation(value = "增加一个机构", notes = "增加一个机构")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "机构名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "type", value = "机构类型", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "parentId", value = "机构父id", required = true, dataType = "Long", paramType = "query")})
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R add(@RequestParam("name") String name, @RequestParam("type") Long type, @RequestParam("parentId") Long parentId) {
		return R.ok();
	}

	@PostMapping("update")
	@ResponseBody
	@ApiOperation(value = "更新某个机构", notes = "更新某个机构")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "oid", value = "机构id", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "机构名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "type", value = "机构类型", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "parentId", value = "机构父id", required = true, dataType = "Long", paramType = "query")})
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R update(@RequestParam("oid") Long oid, @RequestParam("name") String name, @RequestParam("type") Long type, @RequestParam("parentId") Long parentId) {
		return R.ok();
	}

	@PostMapping("delete")
	@ResponseBody
	@ApiOperation(value = "删除某个机构", notes = "删除某个机构")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "oid", value = "机构id", required = true, dataType = "Long", paramType = "query") })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public R delete(@RequestParam("oid") Long oid) {
		return R.ok();
	}
}
