package com.bootdo.welcome.publish.school.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.ErArrangementDO;
import com.bootdo.welcome.service.ErArrangementService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;
import com.bootdo.welcome.vo.DeletedIdVO;
import com.bootdo.welcome.vo.BatchRemoveInput;

/**
 * 考场分配表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
 
@RestController
@RequestMapping("/welcome/publish/school/erArrangement")
@Api(value="考场分配表相关服务",description="考场分配表相关服务")
public class ErArrangementController {

	static Logger log = LoggerFactory.getLogger(ErArrangementController.class);
	
	@Autowired
	private ErArrangementService erArrangementService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取考场分配列表")
	@GetMapping("/list")
	@ApiOperation(value="获取考场分配列表", notes="获取考场分配列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = ErArrangementDO.class, code = 200, message = "返回结构:ErArrangementDO的list")
	})
	public List<ErArrangementDO> getList( ErArrangementDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return erArrangementService.list(params);
	}
	
	@Log("获取考场分配分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取考场分配分页列表", notes="获取考场分配分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size,  ErArrangementDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = erArrangementService.count(query);		
		PPageUtils pageUtil = new PPageUtils(erArrangementService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加考场分配")
	@PostMapping("/save")
	@ApiOperation(value="添加考场分配", notes="添加考场分配"
			+ "入参ErArrangement，是ErArrangementDO(考场分配类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  ErArrangementDO erArrangement) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(erArrangementService.save(erArrangement)>0){
			return PR.ok("添加考场分配成功");
		}
		return PR.error("添加考场分配失败");
	}
	
	@Log("修改考场分配信息")
	@PostMapping("/update")
	@ApiOperation(value="修改考场分配", notes="修改考场分配"
		+ "入参ErArrangement，是ErArrangementDO(考场分配类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody ErArrangementDO erArrangement) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (erArrangementService.update(erArrangement) > 0) {
			
			return PR.ok("修改考场分配成功");
		}
		return PR.error("修改考场分配失败");
	}
	
	@Log("删除考场分配信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除考场分配", notes="删除考场分配,入参是考场分配Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(erArrangementService.remove(vid.getId())>0){
			return PR.ok("删除考场分配成功");
		}
		return PR.error("删除考场分配失败");
		
	}
	
	@Log("批量删除考场分配信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除考场分配", notes="批量删除考场分配")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(erArrangementService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除考场分配成功");
		}
		return PR.error("批量删除考场分配失败");
	}
	
}
