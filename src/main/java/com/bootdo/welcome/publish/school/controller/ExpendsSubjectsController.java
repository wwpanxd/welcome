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
import com.bootdo.welcome.domain.ExpendsSubjectsDO;
import com.bootdo.welcome.service.ExpendsSubjectsService;
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
 * 缴费科目表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:07:27
 */
 
@RestController
@RequestMapping("/welcome/expendsSubjects")
@Api(value="缴费科目表相关服务",description="缴费科目表相关服务")
public class ExpendsSubjectsController {

	static Logger log = LoggerFactory.getLogger(ExpendsSubjectsController.class);
	
	@Autowired
	private ExpendsSubjectsService expendsSubjectsService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取缴费科目列表")
	@GetMapping("/list")
	@ApiOperation(value="获取缴费科目列表", notes="获取缴费科目列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = ExpendsSubjectsDO.class, code = 200, message = "返回结构:ExpendsSubjectsDO的list")
	})
	public List<ExpendsSubjectsDO> getList(@RequestParam ExpendsSubjectsDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return expendsSubjectsService.list(params);
	}
	
	@Log("获取缴费科目分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取缴费科目分页列表", notes="获取缴费科目分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam ExpendsSubjectsDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = expendsSubjectsService.count(query);		
		PPageUtils pageUtil = new PPageUtils(expendsSubjectsService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加缴费科目")
	@PostMapping("/save")
	@ApiOperation(value="添加缴费科目", notes="添加缴费科目"
			+ "入参ExpendsSubjects，是ExpendsSubjectsDO(缴费科目类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  ExpendsSubjectsDO expendsSubjects) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(expendsSubjectsService.save(expendsSubjects)>0){
			return PR.ok("添加缴费科目成功");
		}
		return PR.error("添加缴费科目失败");
	}
	
	@Log("修改缴费科目信息")
	@PostMapping("/update")
	@ApiOperation(value="修改缴费科目", notes="修改缴费科目"
		+ "入参ExpendsSubjects，是ExpendsSubjectsDO(缴费科目类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody ExpendsSubjectsDO expendsSubjects) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (expendsSubjectsService.update(expendsSubjects) > 0) {
			
			return PR.ok("修改缴费科目成功");
		}
		return PR.error("修改缴费科目失败");
	}
	
	@Log("删除缴费科目信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除缴费科目", notes="删除缴费科目,入参是缴费科目Id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "build", value = "BuildDO房屋建筑类，只需要输入，房屋建筑的Id", required = true, dataType = "DeptDO",paramType="body" ,example= "{'id':165}")
  	})
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(expendsSubjectsService.remove(vid.getId())>0){
			return PR.ok("删除缴费科目成功");
		}
		return PR.error("删除缴费科目失败");
		
	}
	
	@Log("批量删除缴费科目信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除缴费科目", notes="批量删除缴费科目")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(expendsSubjectsService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除缴费科目成功");
		}
		return PR.error("批量删除缴费科目失败");
	}
	
}
