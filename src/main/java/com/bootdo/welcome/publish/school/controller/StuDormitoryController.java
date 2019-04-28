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
import com.bootdo.welcome.domain.StuDormitoryDO;
import com.bootdo.welcome.service.StuDormitoryService;
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
 * 学生宿舍对应表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:08:26
 */
 
@RestController
@RequestMapping("/welcome/stuDormitory")
@Api(value="学生宿舍对应表相关服务",description="学生宿舍对应表相关服务")
public class StuDormitoryController {

	static Logger log = LoggerFactory.getLogger(StuDormitoryController.class);
	
	@Autowired
	private StuDormitoryService stuDormitoryService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取学生宿舍列表")
	@GetMapping("/list")
	@ApiOperation(value="获取学生宿舍列表", notes="获取学生宿舍列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = StuDormitoryDO.class, code = 200, message = "返回结构:StuDormitoryDO的list")
	})
	public List<StuDormitoryDO> getList( StuDormitoryDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return stuDormitoryService.list(params);
	}
	
	@Log("获取学生宿舍分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取学生宿舍分页列表", notes="获取学生宿舍分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, StuDormitoryDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = stuDormitoryService.count(query);		
		PPageUtils pageUtil = new PPageUtils(stuDormitoryService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加学生宿舍")
	@PostMapping("/save")
	@ApiOperation(value="添加学生宿舍", notes="添加学生宿舍"
			+ "入参StuDormitory，是StuDormitoryDO(学生宿舍类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  StuDormitoryDO stuDormitory) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(stuDormitoryService.save(stuDormitory)>0){
			return PR.ok("添加学生宿舍成功");
		}
		return PR.error("添加学生宿舍失败");
	}
	
	@Log("修改学生宿舍信息")
	@PostMapping("/update")
	@ApiOperation(value="修改学生宿舍", notes="修改学生宿舍"
		+ "入参StuDormitory，是StuDormitoryDO(学生宿舍类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody StuDormitoryDO stuDormitory) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (stuDormitoryService.update(stuDormitory) > 0) {
			
			return PR.ok("修改学生宿舍成功");
		}
		return PR.error("修改学生宿舍失败");
	}
	
	@Log("删除学生宿舍信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除学生宿舍", notes="删除学生宿舍,入参是学生宿舍Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(stuDormitoryService.remove(vid.getId())>0){
			return PR.ok("删除学生宿舍成功");
		}
		return PR.error("删除学生宿舍失败");
		
	}
	
	@Log("批量删除学生宿舍信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除学生宿舍", notes="批量删除学生宿舍")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(stuDormitoryService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除学生宿舍成功");
		}
		return PR.error("批量删除学生宿舍失败");
	}
	
}
