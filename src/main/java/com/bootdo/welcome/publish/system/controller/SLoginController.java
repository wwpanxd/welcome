package com.bootdo.welcome.publish.system.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.MenuDO;
import com.bootdo.system.service.MenuService;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.LoginVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("welcome/publish/system/login")
@Api(value="系统用户登录相关",description="系统用户登录相关")
public class SLoginController extends BaseController{
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("系统用户登录")
	@PostMapping("/login")
	@ApiOperation(value="系统用户登录", notes="统一系统用户登录接口")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR Login(@RequestBody LoginVO login) {

		login.setPassword(MD5Utils.encrypt(login.getUsername(), login.getPassword()));
		UsernamePasswordToken token = new UsernamePasswordToken("100000"+login.getUsername(), login.getPassword());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return PR.ok("系统用户登录成功");
		} catch (AuthenticationException e) {
			ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.LOGIN_ERROR));
			return PR.error("系统用户或密码错误");
		}
	}
	
	@GetMapping("/logout")
	@ApiOperation(value="系统用户退出", notes="统一退出接口")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR logout() {
		ShiroUtils.logout();
		return PR.ok("系统用户退出成功");
	}
	
	
	@Log("获取系统用户菜单")
	@PostMapping("/menu")
	@ApiOperation(value="获取系统用户菜单", notes="获取系统用户菜单")
	List<Tree<MenuDO>> getUserMenu() {
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		return menus;
	}
}
