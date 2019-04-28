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
import com.bootdo.welcome.domain.RuleDO;
import com.bootdo.welcome.service.RuleService;
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
 * 规则表(批量建班规则、分班规则、分宿规则、学号规则、考试分班规则) 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:08:26
 */
 
@RestController
@RequestMapping("/welcome/rule")
@Api(value="规则表(批量建班规则、分班规则、分宿规则、学号规则、考试分班规则)相关服务",description="规则表(批量建班规则、分班规则、分宿规则、学号规则、考试分班规则)相关服务")
public class RuleController {

	static Logger log = LoggerFactory.getLogger(RuleController.class);
	
	@Autowired
	private RuleService ruleService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取规则列表")
	@GetMapping("/list")
	@ApiOperation(value="获取规则列表", notes="获取规则列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = RuleDO.class, code = 200, message = "返回结构:RuleDO的list")
	})
	public List<RuleDO> getList(@RequestParam RuleDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return ruleService.list(params);
	}
	
	@Log("获取规则分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取规则分页列表", notes="获取规则分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam RuleDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = ruleService.count(query);		
		PPageUtils pageUtil = new PPageUtils(ruleService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加规则")
	@PostMapping("/save")
	@ApiOperation(value="添加规则", notes="添加规则"
			+ "入参Rule，是RuleDO(规则类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  RuleDO rule) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(ruleService.save(rule)>0){
			return PR.ok("添加规则成功");
		}
		return PR.error("添加规则失败");
	}
	
	@Log("修改规则信息")
	@PostMapping("/update")
	@ApiOperation(value="修改规则", notes="修改规则"
		+ "入参Rule，是RuleDO(规则类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody RuleDO rule) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (ruleService.update(rule) > 0) {
			
			return PR.ok("修改规则成功");
		}
		return PR.error("修改规则失败");
	}
	
	@Log("删除规则信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除规则", notes="删除规则,入参是规则Id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "build", value = "BuildDO房屋建筑类，只需要输入，房屋建筑的Id", required = true, dataType = "DeptDO",paramType="body" ,example= "{'id':165}")
  	})
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(ruleService.remove(vid.getId())>0){
			return PR.ok("删除规则成功");
		}
		return PR.error("删除规则失败");
		
	}
	
	@Log("批量删除规则信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除规则", notes="批量删除规则")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(ruleService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除规则成功");
		}
		return PR.error("批量删除规则失败");
	}
	
}
