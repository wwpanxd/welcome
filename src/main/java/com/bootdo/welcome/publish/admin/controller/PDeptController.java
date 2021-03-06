package com.bootdo.welcome.publish.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.admin.YXDeptDO;
import com.bootdo.welcome.service.admin.YXDeptService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.BatchRemoveInput;
import com.bootdo.welcome.vo.DeletedIdVO;
import com.bootdo.welcome.vo.admin.YXDeptScanVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;

/**
 *  学校组织机构相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:06:36
 */
 
@RestController
@RequestMapping("/welcome/publish/admin/dept")
@Api(value="学校组织机构相关服务",description="学校组织机构相关服务")
public class PDeptController {

	static Logger log = LoggerFactory.getLogger(PDeptController.class);
	
	@Autowired
	private YXDeptService deptService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取学校组织机构列表")
	@GetMapping("/list")
	@ApiOperation(value="获取学校组织机构列表", notes="获取学校组织机构列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = YXDeptDO.class, code = 200, message = "返回结构:YXDeptDO的list")
	})
	public List<YXDeptDO> getList( YXDeptScanVO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
     if(condition!=null) params.put("uvCode",condition.getUvCode());//业务的筛选条件
     if(condition!=null&&StringUtils.isNotBlank(condition.getdName())) params.put("dName",condition.getdName());//业务的筛选条件
     if(condition!=null&&condition.getdFlag()!=null) params.put("dFlag",condition.getdFlag());//业务的筛选条件
       
		return deptService.list(params);
	}
	
	@Log("获取学校组织机构分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取学校组织机构分页列表", notes="获取学校组织机构分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, YXDeptScanVO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
		if(condition!=null) params.put("uvCode",condition.getUvCode());//业务的筛选条件
		if(condition!=null&&StringUtils.isNotBlank(condition.getdName())) params.put("dName",condition.getdName());//业务的筛选条件
		if(condition!=null&&condition.getdFlag()!=null) params.put("dFlag",condition.getdFlag());//业务的筛选条件
		      
		
		PQuery query = new PQuery(params);
		int total = deptService.count(query);		
		PPageUtils pageUtil = new PPageUtils(deptService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加学校组织机构")
	@PostMapping("/save")
	@ApiOperation(value="添加学校组织机构", notes="添加学校组织机构"
			+ "入参Dept，是YXDeptDO(学校组织机构类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  YXDeptDO dept) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(deptService.save(dept)>0){
			return PR.ok("添加学校组织机构成功");
		}
		return PR.error("添加学校组织机构失败");
	}
	
	@Log("修改学校组织机构信息")
	@PostMapping("/update")
	@ApiOperation(value="修改学校组织机构", notes="修改学校组织机构"
		+ "入参Dept，是YXDeptDO(学校组织机构类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody YXDeptDO dept) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (deptService.update(dept) > 0) {
			
			return PR.ok("修改学校组织机构成功");
		}
		return PR.error("修改学校组织机构失败");
	}
	
	@Log("删除学校组织机构信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除学校组织机构", notes="删除学校组织机构,入参是学校组织机构Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(deptService.remove(vid.getId())>0){
			return PR.ok("删除学校组织机构成功");
		}
		return PR.error("删除学校组织机构失败");
		
	}
	
	@Log("批量删除学校组织机构信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除学校组织机构", notes="批量删除学校组织机构")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(deptService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除学校组织机构成功");
		}
		return PR.error("批量删除学校组织机构失败");
	}
	
}
