package com.bootdo.system.publish.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.MenuService;
import com.bootdo.system.service.RoleService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.UserVO;
import com.bootdo.welcome.utils.PR;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("welcome/publish/sys/user")
@Api(value="用户相关",description="用户相关")
public class SUserController extends BaseController{
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	DictService dictService;
	@Autowired
	MenuService menuService;	
	@Autowired
	ValidateMessage validateMessage;
	

//	@RequiresPermissions("sys:user:add")
	@Log("用户注册添加")
	@PostMapping("/save")
	@ApiOperation(value="用户注册添加", notes="用户注册添加,"
			+ "入参user，是UserDO(用户类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR save(@RequestBody UserDO user) {
		if(user.getPassword()==null) ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.USER_ADD_NO_PASSWORD));
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		if (userService.save(user) > 0) {
			return PR.ok("添加用户成功");
		}
		return PR.error("添加用户失败");
	}

//	@RequiresPermissions("sys:user:edit")
	@Log("更新用户")
	@PostMapping("/update")
	@ApiOperation(value="更新用户", notes="更新用户,"
			+ "入参user，是UserDO(用户类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR update(@RequestBody UserDO user) {
		if (userService.update(user) > 0) {
			return PR.ok("更新用户成功");
		}
		return PR.error("更新用户失败");
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ApiOperation(value="更改用户密码", notes="更改用户密码,"
			+ "入参userVO，是UserVO")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR resetPwd(@RequestBody UserVO userVO) {
		try{
			userService.resetPwd(userVO,getUser());
			return PR.ok("用户修改密码成功");
		}catch (Exception e){
			return PR.error("用户修改密码失败");
		}
	}
	
	@Log("admin提交更改用户密码")
	@GetMapping("/adminResetPwd")
	@ResponseBody
	PR adminResetPwd() {
		try{
			List<UserDO> alluser=userService.list(new HashMap<String,Object>());
			for(UserDO user:alluser) {
				
				if(StringUtils.equals(user.getUsername(),"admin")) continue;
				
				UserVO uv= new UserVO();
				uv.setUserid(user.getUserId());
				uv.setPwdNew(user.getUsername());
				userService.adminResetPwd(uv);
			}
			return PR.ok("admin修改密码成功");
		}catch (Exception e){
			return PR.error("admin修改密码失败");
		}

	}
}
