package com.bootdo.welcome.publish.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.bootdo.welcome.publish.admin.controller.PUserController;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.BatchRemoveInput;
import com.bootdo.welcome.vo.DeletedIdVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("welcome/publish/sys/user")
@Api(value="用户相关",description="用户相关")
public class SUserController extends BaseController{
	
	static Logger log = LoggerFactory.getLogger(SUserController.class);
	
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

	
	
	@Log("获取xxx列表")
	@GetMapping("/list")
	@ApiOperation(value="获取xxx列表", notes="获取xxx列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = UserDO.class, code = 200, message = "返回结构:UserDO的list")
	})
	public List<UserDO> getList(@RequestParam UserDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return userService.list(params);
	}
	
	@Log("获取xxx分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取xxx分页列表", notes="获取xxx分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam UserDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = userService.count(query);		
		PPageUtils pageUtil = new PPageUtils(userService.list(query), total,page,size);
		return pageUtil;
	}
	

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

	@Log("更新用户信息")
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

	
	@Log("删除XXX信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除XXX", notes="删除XXX,入参是XXXId")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "build", value = "BuildDO房屋建筑类，只需要输入，房屋建筑的Id", required = true, dataType = "DeptDO",paramType="body" ,example= "{'id':165}")
  	})
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(userService.remove(vid.getId())>0){
			return PR.ok("删除XXX成功");
		}
		return PR.error("删除XXX失败");
		
	}
	
	@Log("批量删除XXX信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除XXX", notes="批量删除XXX")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(userService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除XXX成功");
		}
		return PR.error("批量删除XXX失败");
	}
}
