package com.bootdo.welcome.publish.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.admin.YXMenuDO;
import com.bootdo.welcome.service.admin.YXMenuService;
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

/**
 * 系统管理员,管理企业学校菜单权限 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:46
 */
@RestController
@RequestMapping("welcome/publish/system/enterprise/menu")
@Api(value="管理企业学校菜单权限 相关服务",description="管理企业学校菜单权限 相关服务")
public class SEnterpriseMenuController {
static Logger log = LoggerFactory.getLogger(SEnterpriseMenuController.class);
	
	@Autowired
	private YXMenuService menuService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取学校菜单权限列表")
	@GetMapping("/list")
	@ApiOperation(value="获取学校菜单权限列表", notes="获取学校菜单权限列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "uvcode", value = "学校唯一编号", required = true, dataType = "int",paramType="query"),
	})
	@ApiResponses({
		@ApiResponse( response = YXMenuDO.class, code = 200, message = "返回结构:YXMenuDO的list")
	})
	public List<YXMenuDO> getList(@RequestParam Integer uvcode){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
       params.put("uvCode",uvcode);//业务的筛选条件
       
		return menuService.list(params);
	}
	
	@Log("获取学校菜单权限分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取学校菜单权限分页列表", notes="获取学校菜单权限分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam Integer page, @RequestParam Integer size,  @RequestParam Integer uvcode){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
		params.put("uvCode",uvcode);//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = menuService.count(query);		
		PPageUtils pageUtil = new PPageUtils(menuService.list(query), total,page,size);
		return pageUtil;
	}	
	
	@Log("添加学校菜单权限")
	@PostMapping("/save")
	@ApiOperation(value="添加学校菜单权限", notes="添加学校菜单权限"
			+ "入参Menu，是YXMenuDO(学校菜单权限类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  YXMenuDO menu) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(menuService.save(menu)>0){
			return PR.ok("添加学校菜单权限成功");
		}
		return PR.error("添加学校菜单权限失败");
	}
	
	@Log("修改学校菜单权限信息")
	@PostMapping("/update")
	@ApiOperation(value="修改学校菜单权限", notes="修改学校菜单权限"
		+ "入参Menu，是YXMenuDO(学校菜单权限类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody YXMenuDO menu) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (menuService.update(menu) > 0) {
			
			return PR.ok("修改学校菜单权限成功");
		}
		return PR.error("修改学校菜单权限失败");
	}
	
	@Log("删除学校菜单权限信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除学校菜单权限", notes="删除学校菜单权限,入参是学校菜单权限Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(menuService.remove(vid.getId())>0){
			return PR.ok("删除学校菜单权限成功");
		}
		return PR.error("删除学校菜单权限失败");
		
	}
	
	@Log("批量删除学校菜单权限信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除学校菜单权限", notes="批量删除学校菜单权限")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(menuService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除学校菜单权限成功");
		}
		return PR.error("批量删除学校菜单权限失败");
	}
}
