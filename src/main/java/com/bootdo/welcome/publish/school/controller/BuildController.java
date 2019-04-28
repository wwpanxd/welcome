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
import com.bootdo.welcome.domain.BuildDO;
import com.bootdo.welcome.service.BuildService;
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
 * 宿舍楼宇信息表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:06:35
 */
 
@RestController
@RequestMapping("/welcome/publish/school/build")
@Api(value="宿舍楼宇信息表相关服务",description="宿舍楼宇信息表相关服务")
public class BuildController {

	static Logger log = LoggerFactory.getLogger(BuildController.class);
	
	@Autowired
	private BuildService buildService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取宿舍楼宇信息列表")
	@GetMapping("/list")
	@ApiOperation(value="获取宿舍楼宇信息列表", notes="获取宿舍楼宇信息列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = BuildDO.class, code = 200, message = "返回结构:BuildDO的list")
	})
	public List<BuildDO> getList(@RequestParam BuildDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return buildService.list(params);
	}
	
	@Log("获取宿舍楼宇信息分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取宿舍楼宇信息分页列表", notes="获取宿舍楼宇信息分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam BuildDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = buildService.count(query);		
		PPageUtils pageUtil = new PPageUtils(buildService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加宿舍楼宇信息")
	@PostMapping("/save")
	@ApiOperation(value="添加宿舍楼宇信息", notes="添加宿舍楼宇信息"
			+ "入参Build，是BuildDO(XXX类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  BuildDO build) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(buildService.save(build)>0){
			return PR.ok("添加宿舍楼宇信息成功");
		}
		return PR.error("添加宿舍楼宇信息失败");
	}
	
	@Log("修改宿舍楼宇信息信息")
	@PostMapping("/update")
	@ApiOperation(value="修改宿舍楼宇信息", notes="修改宿舍楼宇信息"
		+ "入参Build，是BuildDO(宿舍楼宇信息类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody BuildDO build) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (buildService.update(build) > 0) {
			
			return PR.ok("修改宿舍楼宇信息成功");
		}
		return PR.error("修改宿舍楼宇信息失败");
	}
	
	@Log("删除宿舍楼宇信息信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除宿舍楼宇信息", notes="删除宿舍楼宇信息,入参是宿舍楼宇信息Id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "build", value = "BuildDO房屋建筑类，只需要输入，房屋建筑的Id", required = true, dataType = "DeptDO",paramType="body" ,example= "{'id':165}")
  	})
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(buildService.remove(vid.getId())>0){
			return PR.ok("删除XXX成功");
		}
		return PR.error("删除XXX失败");
		
	}
	
	@Log("批量删除宿舍楼宇信息信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除宿舍楼宇信息", notes="批量删除宿舍楼宇信息")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(buildService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除宿舍楼宇信息成功");
		}
		return PR.error("批量删除宿舍楼宇信息失败");
	}
	
}
