package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;

@Controller
@RequestMapping("/welcome/publish/school/userrole")
public class PSchoolRoleController extends BaseController {
	@Log("获取所有的角色")
	@GetMapping(value = "/allrole")
	@ResponseBody
	public R getAll() {
		List<String> list = new ArrayList<String>();
		list.add("角色1");
		list.add("角色2");
		list.add("角色3");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		return R.ok(map);
	}
	
	@Log("更新角色")
	@ResponseBody
	@PostMapping(value = "updaterole")
	public R update(@RequestBody List<String> roles) {
		System.out.println(roles);
		return R.ok();
	}

	@Log("删除角色")
	@ResponseBody
	@PostMapping(value = "deleterole")
	public R delete() {
		return R.ok();
	}
}
