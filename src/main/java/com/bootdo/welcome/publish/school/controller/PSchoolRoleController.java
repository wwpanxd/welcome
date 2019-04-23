package com.bootdo.welcome.publish.school.controller;

import com.bootdo.welcome.vo.SchoolUserRoleVO;

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
import com.bootdo.system.vo.DeletedIdVO;
import com.bootdo.welcome.domain.SchoolUserRoleDo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/welcome/publish/school/userrole")
public class PSchoolRoleController extends BaseController {
	@Log("获取所有的角色")
	@GetMapping(value = "/allrole")
	@ResponseBody
	@ApiOperation(value = "获取所有的角色", notes = "获取所有的角色")
	@ApiResponses({
			@ApiResponse(response = SchoolUserRoleDo.class, code = 200, message = "返回：List<SchoolUserRoleDo>") })
	public R getAll() {
		List<SchoolUserRoleDo> list = new ArrayList<SchoolUserRoleDo>();

		for (int i = 1; i < 10; i++) {
			SchoolUserRoleDo schoolUserRoleDo = new SchoolUserRoleDo();
			schoolUserRoleDo.setId(i);
			schoolUserRoleDo.setRoleName("角色" + i);
			list.add(schoolUserRoleDo);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}

	@Log("更新角色")
	@ResponseBody
	@PostMapping(value = "updaterole")
	@ApiOperation(value = "更新角色", notes = "提交角色id和角色名称")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "角色名称", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public R update(SchoolUserRoleVO schoolUserRoleVO) {
		return R.ok();
	}

	@Log("删除角色")
	@ResponseBody
	@PostMapping(value = "deleterole")
	@ApiOperation(value = "删除角色", notes = "提交角色id")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public R delete(DeletedIdVO deletedIdVO) {
		return R.ok();
	}
}
