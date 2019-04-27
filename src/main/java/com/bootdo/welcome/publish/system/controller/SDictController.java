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
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.common.service.DictService;
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
import com.bootdo.common.domain.DictDO;

/**
 * 系统字典表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:05:45
 */
 
@RestController
@RequestMapping("welcome/publish/system/dict")
@Api(value="系统字典表相关服务",description="系统字典表相关服务")
public class SDictController {

	static Logger log = LoggerFactory.getLogger(SDictController.class);
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取系统字典类型")
	@GetMapping("/type")
	@ApiOperation(value="获取系统字典类型", notes="获取系统字典类型")
	@ApiResponses({
		@ApiResponse( response = DictDO.class, code = 200, message = "返回结构:DictDO的list")
	})
	public List<DictDO> listType() {
		return dictService.listType();
	}
	
	@Log("获取具体类型的系统字典数据")
	@GetMapping("/type/list")
	@ApiOperation(value="获取具体系统字典、词库分类等", notes="获取具体类型的系统字典数据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "type", value = "字典类型：90001:词库分类", required = true, dataType = "int",paramType="query"),
  	})
	@ApiResponses({
		@ApiResponse( response = DictDO.class, code = 200, message = "返回结构:DictDO的list")
	})
	public List<DictDO> getTypeLists(String type) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dmode",1);//强制前端只显示类型1的字典
		params.put("type",type);//
		params.put("sort","sort");
		params.put("order","asc");
		// 查询列表数据
		return dictService.list2(params);
	}
	
	
	@Log("获取系统字典列表")
	@GetMapping("/list")
	@ApiOperation(value="获取系统字典列表", notes="获取系统字典列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = DictDO.class, code = 200, message = "返回结构:DictDO的list")
	})
	public List<DictDO> getList(@RequestParam DictDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return dictService.findPageListByMap(params);
	}
	
	@Log("获取系统字典分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取系统字典分页列表", notes="获取系统字典分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, @RequestParam DictDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = dictService.countByMap(query);		
		PPageUtils pageUtil = new PPageUtils(dictService.findPageListByMap(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加系统字典")
	@PostMapping("/save")
	@ApiOperation(value="添加系统字典", notes="添加系统字典"
			+ "入参Dict，是DictDO(系统字典类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  DictDO dict) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(dictService.save(dict)>0){
			return PR.ok("添加系统字典成功");
		}
		return PR.error("添加系统字典失败");
	}
	
	@Log("修改系统字典信息")
	@PostMapping("/update")
	@ApiOperation(value="修改系统字典", notes="修改系统字典"
		+ "入参Dict，是DictDO(系统字典类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody DictDO dict) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (dictService.updateById(dict) > 0) {
			
			return PR.ok("修改系统字典成功");
		}
		return PR.error("修改系统字典失败");
	}
	
	@Log("删除系统字典信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除系统字典", notes="删除系统字典,入参是系统字典Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(dictService.removeById(vid.getId())>0){
			return PR.ok("删除系统字典成功");
		}
		return PR.error("删除系统字典失败");
		
	}
	
	@Log("批量删除系统字典信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除系统字典", notes="批量删除系统字典")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(dictService.batchRemoveByIds(bids.getIds())>0){
			return PR.ok("批量删除系统字典成功");
		}
		return PR.error("批量删除系统字典失败");
	}
	
}
