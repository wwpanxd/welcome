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
import com.bootdo.welcome.domain.LinkDO;
import com.bootdo.welcome.service.LinkService;
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
 * 迎新环节表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:07:27
 */
 
@RestController
@RequestMapping("/welcome/link")
@Api(value="迎新环节表相关服务",description="迎新环节表相关服务")
public class LinkController {

	static Logger log = LoggerFactory.getLogger(LinkController.class);
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取迎新环节列表")
	@GetMapping("/list")
	@ApiOperation(value="获取迎新环节列表", notes="获取迎新环节列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = LinkDO.class, code = 200, message = "返回结构:LinkDO的list")
	})
	public List<LinkDO> getList( LinkDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return linkService.list(params);
	}
	
	@Log("获取迎新环节分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取迎新环节分页列表", notes="获取迎新环节分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, LinkDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = linkService.count(query);		
		PPageUtils pageUtil = new PPageUtils(linkService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加迎新环节")
	@PostMapping("/save")
	@ApiOperation(value="添加迎新环节", notes="添加迎新环节"
			+ "入参Link，是LinkDO(迎新环节类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  LinkDO link) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(linkService.save(link)>0){
			return PR.ok("添加迎新环节成功");
		}
		return PR.error("添加迎新环节失败");
	}
	
	@Log("修改迎新环节信息")
	@PostMapping("/update")
	@ApiOperation(value="修改迎新环节", notes="修改迎新环节"
		+ "入参Link，是LinkDO(迎新环节类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody LinkDO link) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (linkService.update(link) > 0) {
			
			return PR.ok("修改迎新环节成功");
		}
		return PR.error("修改迎新环节失败");
	}
	
	@Log("删除迎新环节信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除迎新环节", notes="删除迎新环节,入参是迎新环节Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(linkService.remove(vid.getId())>0){
			return PR.ok("删除迎新环节成功");
		}
		return PR.error("删除迎新环节失败");
		
	}
	
	@Log("批量删除迎新环节信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除迎新环节", notes="批量删除迎新环节")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(linkService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除迎新环节成功");
		}
		return PR.error("批量删除迎新环节失败");
	}
	
}
