package com.bootdo.welcome.publish.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.system.domain.MenuDO;
import com.bootdo.system.service.MenuService;
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
import com.bootdo.common.annotation.Log;

/**
 * 系统菜单管理 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:46
 */
 
@RestController
@RequestMapping("welcome/publish/system/menu")
@Api(value="系统菜单管理相关服务",description="系统菜单管理相关服务")
public class SMenuController {

	static Logger log = LoggerFactory.getLogger(SMenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取系统菜单列表")
	@GetMapping("/list")
	@ApiOperation(value="获取系统菜单列表", notes="获取系统菜单列表")
	@ApiResponses({
		@ApiResponse( response = MenuDO.class, code = 200, message = "返回结构:MenuDO的list")
	})
	public List<MenuDO> getList(@RequestParam MenuDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
		params.put("isshow",1);//获取给前端展示的全部菜单
		if(condition!=null&&condition.getName()!=null) params.put("name",condition.getName());//业务的筛选条件
		return menuService.listByIsshowAndType(params);
       
	}
	
	@GetMapping("/list/role")
	@ApiOperation(value="根据角色id,获取对应菜单列表", notes="根据角色id,获取对应菜单列表,选择权限时，展示菜单列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "roleId", value = "角色ID", required = true, dataType = "long",paramType="query" )
  	})
	@ApiResponses({
		@ApiResponse( response = MenuDO.class, code = 200, message = "返回结构:MenuDO的list")
	})
	List<MenuDO> listByRoleId(@RequestParam Long roleId) {
		return menuService.getList(roleId);
	}
	
	
	@Log("添加系统菜单")
	@PostMapping("/save")
	@ApiOperation(value="添加系统菜单", notes="添加系统菜单"
			+ "入参Menu，是MenuDO(系统菜单类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  MenuDO menu) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		menu.setIsshow(1);
		if(menuService.save(menu)>0){
			return PR.ok("添加系统菜单成功");
		}
		return PR.error("添加系统菜单失败");
	}
	
	@Log("修改系统菜单信息")
	@PostMapping("/update")
	@ApiOperation(value="修改系统菜单", notes="修改系统菜单"
		+ "入参Menu，是MenuDO(系统菜单类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody MenuDO menu) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (menuService.update(menu) > 0) {
			
			return PR.ok("修改系统菜单成功");
		}
		return PR.error("修改系统菜单失败");
	}
	
	@Log("删除系统菜单信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除系统菜单", notes="删除系统菜单,入参是系统菜单Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(menuService.remove(vid.getId())>0){
			return PR.ok("删除系统菜单成功");
		}
		return PR.error("删除系统菜单失败");
		
	}

	
//	@Log("批量删除系统菜单信息")
//	@PostMapping("/batchRemove")
//	@ApiOperation(value="批量删除系统菜单", notes="批量删除系统菜单")
//	@ApiResponses({
//		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
//	})
//	public PR remove(@RequestBody BatchRemoveInput bids) {
//		
//		if(menuService.batchRemove(bids.getIds())>0){
//			return PR.ok("批量删除系统菜单成功");
//		}
//		return PR.error("批量删除系统菜单失败");
//	}
	
}
