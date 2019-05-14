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
import com.bootdo.welcome.domain.StuFamilyDO;
import com.bootdo.welcome.service.StuFamilyService;
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
 * 新生家长信息表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:18:57
 */
 
@RestController
@RequestMapping("/welcome/publish/school/stuFamily")
@Api(value="新生家长信息表相关服务",description="新生家长信息表相关服务")
public class StuFamilyController {

	static Logger log = LoggerFactory.getLogger(StuFamilyController.class);
	
	@Autowired
	private StuFamilyService stuFamilyService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取新生家长信息列表")
	@GetMapping("/list")
	@ApiOperation(value="获取新生家长信息列表", notes="获取新生家长信息列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = StuFamilyDO.class, code = 200, message = "返回结构:StuFamilyDO的list")
	})
	public List<StuFamilyDO> getList( StuFamilyDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return stuFamilyService.list(params);
	}
	
	@Log("获取新生家长信息分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取新生家长信息分页列表", notes="获取新生家长信息分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size,  StuFamilyDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = stuFamilyService.count(query);		
		PPageUtils pageUtil = new PPageUtils(stuFamilyService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加新生家长信息")
	@PostMapping("/save")
	@ApiOperation(value="添加新生家长信息", notes="添加新生家长信息"
			+ "入参StuFamily，是StuFamilyDO(新生家长信息类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  StuFamilyDO stuFamily) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(stuFamilyService.save(stuFamily)>0){
			return PR.ok("添加新生家长信息成功");
		}
		return PR.error("添加新生家长信息失败");
	}
	
	@Log("修改新生家长信息信息")
	@PostMapping("/update")
	@ApiOperation(value="修改新生家长信息", notes="修改新生家长信息"
		+ "入参StuFamily，是StuFamilyDO(新生家长信息类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody StuFamilyDO stuFamily) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (stuFamilyService.update(stuFamily) > 0) {
			
			return PR.ok("修改新生家长信息成功");
		}
		return PR.error("修改新生家长信息失败");
	}
	
	@Log("删除新生家长信息信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除新生家长信息", notes="删除新生家长信息,入参是新生家长信息Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(stuFamilyService.remove(vid.getId())>0){
			return PR.ok("删除新生家长信息成功");
		}
		return PR.error("删除新生家长信息失败");
		
	}
	
	@Log("批量删除新生家长信息信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除新生家长信息", notes="批量删除新生家长信息")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(stuFamilyService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除新生家长信息成功");
		}
		return PR.error("批量删除新生家长信息失败");
	}
	
}
