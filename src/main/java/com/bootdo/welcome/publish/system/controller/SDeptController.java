package com.bootdo.welcome.publish.system.controller;

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
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.service.DeptService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.DeletedIdVO;
import com.bootdo.welcome.vo.system.DeptScanVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;

/**
 * 部门管理 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:45
 */
 
@RestController
@RequestMapping("welcome/publish/system/dept")
@Api(value="系统部门管理相关服务",description="系统部门管理相关服务")
public class SDeptController {

	static Logger log = LoggerFactory.getLogger(SDeptController.class);
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取系统部门列表")
	@GetMapping("/list")
	@ApiOperation(value="获取系统部门列表", notes="获取系统部门列表")
	@ApiResponses({
		@ApiResponse( response = DeptDO.class, code = 200, message = "返回结构:DeptDO的list")
	})
	public List<DeptDO> getList( DeptScanVO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
       if(condition!=null&&condition.getName()!=null) params.put("name",condition.getName());//业务的筛选条件
       if(condition!=null&&condition.getSname()!=null) params.put("sname",condition.getSname());//业务的筛选条件
       if(condition!=null&&condition.getParentId()!=null) params.put("parentId",condition.getParentId());//业务的筛选条件
       if(condition!=null&&condition.getDeptId()!=null) params.put("deptId",condition.getDeptId());//业务的筛选条件
       if(condition!=null&&condition.getDelFlag()!=null) params.put("delFlag",condition.getDelFlag());//业务的筛选条件
         
		return deptService.list(params);
	}
	
	@Log("获取系统部门分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取系统部门分页列表", notes="获取系统部门分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, DeptDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
		 if(condition!=null&&condition.getName()!=null) params.put("name",condition.getName());//业务的筛选条件
	       if(condition!=null&&condition.getSname()!=null) params.put("sname",condition.getSname());//业务的筛选条件
	       if(condition!=null&&condition.getParentId()!=null) params.put("parentId",condition.getParentId());//业务的筛选条件
	       if(condition!=null&&condition.getDeptId()!=null) params.put("deptId",condition.getDeptId());//业务的筛选条件
	       if(condition!=null&&condition.getDelFlag()!=null) params.put("delFlag",condition.getDelFlag());//业务的筛选条件
	        
		
		PQuery query = new PQuery(params);
		int total = deptService.count(query);		
		PPageUtils pageUtil = new PPageUtils(deptService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加系统部门")
	@PostMapping("/save")
	@ApiOperation(value="添加系统部门", notes="添加系统部门"
			+ "入参Dept，是DeptDO(系统部门类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  DeptDO dept) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(deptService.save(dept)>0){
			return PR.ok("添加系统部门成功");
		}
		return PR.error("添加系统部门失败");
	}
	
	@Log("修改系统部门信息")
	@PostMapping("/update")
	@ApiOperation(value="修改系统部门", notes="修改系统部门"
		+ "入参Dept，是DeptDO(系统部门类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody DeptDO dept) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (deptService.update(dept) > 0) {
			
			return PR.ok("修改系统部门成功");
		}
		return PR.error("修改系统部门失败");
	}
	
	@Log("删除系统部门信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除系统部门", notes="删除系统部门,入参是系统部门Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", vid.getId());
		if(deptService.count(map)>0) {
			return PR.error("包含下级部门,不允许修改");
		}
		
		if(deptService.checkDeptHasUser(vid.getId())) {
			if (deptService.remove(vid.getId()) > 0) {
				return PR.ok("删除系统部门成功");
			}
		}else {
			return PR.error("部门包含用户,不允许修改");
		}
		return PR.error("删除系统部门失败");
	}
	
//	@Log("批量删除系统部门信息")
//	@PostMapping("/batchRemove")
//	@ApiOperation(value="批量删除系统部门", notes="批量删除系统部门")
//	@ApiResponses({
//		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
//	})
//	public PR remove(@RequestBody BatchRemoveInput bids) {
//		
//		if(deptService.batchRemove(bids.getIds())>0){
//			return PR.ok("批量删除系统部门成功");
//		}
//		return PR.error("批量删除系统部门失败");
//	}
	
}
