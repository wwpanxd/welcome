package com.bootdo.welcome.publish.admin.controller;

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
import com.bootdo.welcome.domain.StageDO;
import com.bootdo.welcome.service.StageService;
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
 * 迎新阶段表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:08:26
 */
 
@RestController
@RequestMapping("/welcome/publish/admin/stage")
@Api(value="迎新阶段表相关服务",description="迎新阶段表相关服务")
public class StageController {

	static Logger log = LoggerFactory.getLogger(StageController.class);
	
	@Autowired
	private StageService stageService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取迎新阶段列表")
	@GetMapping("/list")
	@ApiOperation(value="获取迎新阶段列表", notes="获取迎新阶段列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = StageDO.class, code = 200, message = "返回结构:StageDO的list")
	})
	public List<StageDO> getList(@RequestParam StageDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return stageService.list(params);
	}
	
//	@Log("获取迎新阶段分页列表")
//	@GetMapping("/list/page")
//	@ApiOperation(value="获取迎新阶段分页列表", notes="获取迎新阶段分页列表")
//    @ApiImplicitParams({
//		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
//		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
//    })
//	@ApiResponses({
//		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
//	})
//	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam StageDO condition){
//		//查询列表数据
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("page", page);//数据偏移量
//		params.put("size", size);//每页条数
//		params.put("sort", "id");//每页条数
//		params.put("order", "asc");//每页条数
////     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
//		
//		PQuery query = new PQuery(params);
//		int total = stageService.count(query);		
//		PPageUtils pageUtil = new PPageUtils(stageService.list(query), total,page,size);
//		return pageUtil;
//	}
	
	
	@Log("添加迎新阶段")
	@PostMapping("/save")
	@ApiOperation(value="添加迎新阶段", notes="添加迎新阶段"
			+ "入参Stage，是StageDO(迎新阶段类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  StageDO stage) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(stageService.save(stage)>0){
			return PR.ok("添加迎新阶段成功");
		}
		return PR.error("添加迎新阶段失败");
	}
	
	@Log("修改迎新阶段信息")
	@PostMapping("/update")
	@ApiOperation(value="修改迎新阶段", notes="修改迎新阶段"
		+ "入参Stage，是StageDO(迎新阶段类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody StageDO stage) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (stageService.update(stage) > 0) {
			
			return PR.ok("修改迎新阶段成功");
		}
		return PR.error("修改迎新阶段失败");
	}
	
	@Log("删除迎新阶段信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除迎新阶段", notes="删除迎新阶段,入参是迎新阶段Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(stageService.remove(vid.getId())>0){
			return PR.ok("删除迎新阶段成功");
		}
		return PR.error("删除迎新阶段失败");
		
	}
	
	@Log("批量删除迎新阶段信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除迎新阶段", notes="批量删除迎新阶段")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(stageService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除迎新阶段成功");
		}
		return PR.error("批量删除迎新阶段失败");
	}
	
}
