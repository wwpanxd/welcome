package com.bootdo.welcome.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.welcome.domain.UserDO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wel/user")
public class SchoolUserController extends BaseController {
	UserDO createUserDoModel() {
		UserDO userDO = new UserDO();
		userDO.setUserId(1L);
		userDO.setUsername("登录用户名");
		userDO.setName("真实姓名");
		userDO.setDeptId(1L);
		userDO.setDeptName("部门");
		userDO.setEmail("邮箱");
		userDO.setPost("用户职务");
		userDO.setPhone("电话");
		userDO.setStatus(1);
		userDO.setUserIdCreate(new Date());
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		userDO.setRoleIds(list);
		userDO.setSex(1L);
		userDO.setPicUrl("www.baidu.com");
		userDO.setPicId(100L);
		return userDO;
	}

	@Log("获取用户信息")
	@ResponseBody
	@PostMapping("/getUser")
	public R getUserInfo(@RequestParam("userId") Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", createUserDoModel());
		return R.ok(map);
	}

	@Log("新增用户")
	@ResponseBody
	@PostMapping("/addUser")
	public R addUser(@RequestBody UserDO userDO) {
		return R.ok();
	}

	@Log("更新用户")
	@ResponseBody
	@PostMapping("/updateUser")
	public R updateUser(@RequestBody UserDO userDO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", createUserDoModel());
		return R.ok(map);
	}
	
	@Log("删除用户")
	@ResponseBody
	@PostMapping("/deleteUser")
	public R deleteUser(@RequestParam("userId") Long userId) {
		return R.ok();
	}
}
