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
import com.bootdo.welcome.domain.ExaminationDO;
import com.bootdo.welcome.service.ExaminationService;
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
 * 普教考试任务表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
 
@RestController
@RequestMapping("/welcome/publish/school/examination")
@Api(value="普教考试任务表相关服务",description="普教考试任务表相关服务")
public class ExaminationController {

	static Logger log = LoggerFactory.getLogger(ExaminationController.class);
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取考试任务列表")
	@GetMapping("/list")
	@ApiOperation(value="获取考试任务列表", notes="获取考试任务列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = ExaminationDO.class, code = 200, message = "返回结构:ExaminationDO的list")
	})
	public List<ExaminationDO> getList( ExaminationDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return examinationService.list(params);
	}
	
	@Log("获取考试任务分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取考试任务分页列表", notes="获取考试任务分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size,  ExaminationDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = examinationService.count(query);		
		PPageUtils pageUtil = new PPageUtils(examinationService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加考试任务")
	@PostMapping("/save")
	@ApiOperation(value="添加考试任务", notes="添加考试任务"
			+ "入参Examination，是ExaminationDO(考试任务类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  ExaminationDO examination) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(examinationService.save(examination)>0){
			return PR.ok("添加考试任务成功");
		}
		return PR.error("添加考试任务失败");
	}
	
	@Log("修改考试任务信息")
	@PostMapping("/update")
	@ApiOperation(value="修改考试任务", notes="修改考试任务"
		+ "入参Examination，是ExaminationDO(考试任务类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody ExaminationDO examination) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (examinationService.update(examination) > 0) {
			
			return PR.ok("修改考试任务成功");
		}
		return PR.error("修改考试任务失败");
	}
	
	@Log("删除考试任务信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除考试任务", notes="删除考试任务,入参是考试任务Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(examinationService.remove(vid.getId())>0){
			return PR.ok("删除考试任务成功");
		}
		return PR.error("删除考试任务失败");
		
	}
	
	@Log("批量删除考试任务信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除考试任务", notes="批量删除考试任务")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(examinationService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除考试任务成功");
		}
		return PR.error("批量删除考试任务失败");
	}
	
}
