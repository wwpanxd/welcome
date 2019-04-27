package com.bootdo.welcome.publish.system.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.system.domain.RoleDO;
import com.bootdo.system.domain.UserRoleDO;
import com.bootdo.system.service.RoleService;
import com.bootdo.system.service.UserRoleService;
import com.bootdo.system.vo.UserRoleVO;
import com.bootdo.system.vo.UsersRoleVO;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.DeletedIdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;

/**
 * 系统角色 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:46
 */
 
@RestController
@RequestMapping("/welcome/role")
@Api(value="系统角色相关服务",description="系统角色相关服务")
public class SRoleController {

	static Logger log = LoggerFactory.getLogger(SRoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	UserRoleService userroleservice;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取系统角色列表")
	@GetMapping("/list")
	@ApiOperation(value="获取系统角色列表", notes="获取全部系统角色列表")
	@ApiResponses({
		@ApiResponse( response = RoleDO.class, code = 200, message = "返回结构:RoleDO的list")
	})
//	public List<RoleDO> getList(RoleDO condition){
	public List<RoleDO> getList(){
		//查询列表数据
//       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return roleService.list();
	}
	
		
	@Log("添加系统角色")
	@PostMapping("/save")
	@ApiOperation(value="添加系统角色", notes="添加系统角色"
			+ "入参Role，是RoleDO(系统角色类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  RoleDO role) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		role.setGmtCreate( new Timestamp(System.currentTimeMillis()));
		if(roleService.save(role)>0){
			return PR.ok("添加系统角色成功");
		}
		return PR.error("添加系统角色失败");
	}
	
	@Log("修改系统角色信息")
	@PostMapping("/update")
	@ApiOperation(value="修改系统角色", notes="修改系统角色"
		+ "入参Role，是RoleDO(系统角色类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody RoleDO role) {
		
		//异常判断
		if(role.getRoleId()==1) ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.ROLE_UPDATE_ADMIN));
		role.setGmtModified( new Timestamp(System.currentTimeMillis()));
		if (roleService.update(role) > 0) {
			
			return PR.ok("修改系统角色成功");
		}
		return PR.error("修改系统角色失败");
	}
	
	@Log("删除系统角色信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除系统角色", notes="删除系统角色,入参是系统角色Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		
		if(vid.getId()==1) ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.ROLE_DELETE_ADMIN));
		
		if(roleService.remove(vid.getId())>0){
			return PR.ok("删除系统角色成功");
		}
		return PR.error("删除系统角色失败");
		
	}
	
	
	@GetMapping("/members/list")
	@ApiOperation(value="获取系统角色成员列表", notes="获取系统角色成员列表,使用分页方式"+ "返回 PPageUtils,"
			+ "入参 roleId：是角色ID,"
			+ "page：分页,当前页,"
			+ "size：分页,每页条数")
   @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
		@ApiImplicitParam(name = "roleId", value = "系统角色ID", required = true, dataType = "Long" ,paramType="query"),
  	})
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	PPageUtils roleMemberList(@RequestParam int page, @RequestParam int size,@RequestParam Long roleId) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("roleId",roleId);//角色ID业务的筛选条件
		// 查询列表数据
		PQuery query = new PQuery(params);
		List<UserRoleDO> roleusers = userroleservice.list(query);
		int total =userroleservice.count(query);
//		if(roleusers!=null) total=roleusers.size();
		PPageUtils pageUtil = new PPageUtils(roleusers, total,page,size);
		return pageUtil;
	}
	
	
	@Log("删除系统角色成员")
	@PostMapping("/members/remove")
	@ApiOperation(value="删除系统角色成员", notes="删除系统角色成员,使用角色成员的id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR roleMemberSave(@RequestBody DeletedIdVO idv) {
		if (userroleservice.remove(idv.getId()) > 0) {
			return PR.ok("删除系统角色成员成功");
		} else {
			return PR.error("删除系统角色成员失败");
		}
	}
	
	@Log("添加系统角色成员")
	@PostMapping("/members/addToRole")
	@ApiOperation(value="添加系统角色成员", notes="添加系统角色成员")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
//	PR roleMemberAdd(@RequestBody Long userid,@RequestBody Long roleId) {
	PR roleMemberAdd(@RequestBody UserRoleVO userrolesvo) {
		UserRoleDO userRole = new UserRoleDO();
		userRole.setRoleId(userrolesvo.getRoleid());
		userRole.setUserId(userrolesvo.getUserid());
		if (userroleservice.save(userRole) > 0) {
			return PR.ok("添加系统角色成员成功");
		}
		return PR.error("添加系统角色成员失败");
	}
	
	@Log("批量添加系统角色成员")
	@PostMapping("/members/batchAddToRole")
	@ApiOperation(value="批量添加系统角色成员", notes="批量添加系统角色成员")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR roleMemberBatchAdd(@RequestBody UsersRoleVO usersrolevo) {
		List<UserRoleDO> list = new ArrayList<UserRoleDO>();
		for(Long uid:usersrolevo.getUserid()) {
			UserRoleDO userRole = new UserRoleDO();
			userRole.setRoleId(usersrolevo.getRoleid());
			userRole.setUserId(uid);
			list.add(userRole);
		}
		int r = userroleservice.batchSave(list);
		if (r > 0) {
			return PR.ok("批量添加系统角色成员成功");
		}
		return PR.error("批量添加系统角色成员失败");
	}
	
}
