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
import com.bootdo.system.domain.AppDO;
import com.bootdo.system.service.AppService;
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
 * app版本更新表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:45
 */
 
@RestController
@RequestMapping("welcome/publish/system/app")
@Api(value="app版本更新表相关服务",description="服务设置app版本更新表相关服务")
public class SSAppController {

	static Logger log = LoggerFactory.getLogger(SSAppController.class);
	
	@Autowired
	private AppService appService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取app版本列表")
	@GetMapping("/list")
	@ApiOperation(value="获取app版本列表", notes="获取app版本列表")
	@ApiResponses({
		@ApiResponse( response = AppDO.class, code = 200, message = "返回结构:AppDO的list")
	})
	public List<AppDO> getList(AppDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return appService.list(params);
	}
	
	@Log("获取app版本分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取app版本分页列表", notes="获取app版本分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam AppDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = appService.count(query);		
		PPageUtils pageUtil = new PPageUtils(appService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加app版本")
	@PostMapping("/save")
	@ApiOperation(value="添加app版本", notes="添加app版本"
			+ "入参App，是AppDO(app版本类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  AppDO app) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(appService.save(app)>0){
			return PR.ok("添加app版本成功");
		}
		return PR.error("添加app版本失败");
	}
	
	@Log("修改app版本信息")
	@PostMapping("/update")
	@ApiOperation(value="修改app版本", notes="修改app版本"
		+ "入参App，是AppDO(app版本类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody AppDO app) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (appService.update(app) > 0) {
			
			return PR.ok("修改app版本成功");
		}
		return PR.error("修改app版本失败");
	}
	
	@Log("删除app版本信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除app版本", notes="删除app版本,入参是app版本Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(appService.remove(vid.getId())>0){
			return PR.ok("删除app版本成功");
		}
		return PR.error("删除app版本失败");
		
	}
	
	@Log("批量删除app版本信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除app版本", notes="批量删除app版本")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(appService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除app版本成功");
		}
		return PR.error("批量删除app版本失败");
	}
	
}
