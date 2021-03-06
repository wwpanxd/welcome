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
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.admin.YXDictDO;
import com.bootdo.welcome.service.admin.YXDictService;
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
 * 字典表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:07:27
 */
 
@RestController
@RequestMapping("/welcome/publish/admin/dict")
@Api(value="学校字典枚举管理相关服务",description="学校字典枚举管理相关服务")
public class PDictController {

	static Logger log = LoggerFactory.getLogger(PDictController.class);
	
	@Autowired
	private YXDictService dictService;
	
	@Autowired
	ValidateMessage validateMessage;

	@Log("获取学校字典类型")
	@GetMapping("/type")
	@ApiOperation(value="获取学校字典类型", notes="获取学校字典类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "uvcode", value = "学校唯一编号", required = true, dataType = "int",paramType="query"),
	})
	@ApiResponses({
		@ApiResponse( response = YXDictDO.class, code = 200, message = "返回结构:YXDictDO的list")
	})
	public List<YXDictDO> listType(@RequestParam Integer uvcode) {
		return dictService.listType(uvcode);
	}
	
	@Log("获取具体类型的学校字典数据")
	@GetMapping("/type/list")
	@ApiOperation(value="获取具体学校字典、机构级别、宿舍级别等", notes="获取具体类型的学校字典数据")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "uvcode", value = "学校唯一编号", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "type", value = "字典类型", required = true, dataType = "int",paramType="query"),
  	})
	@ApiResponses({
		@ApiResponse( response = YXDictDO.class, code = 200, message = "返回结构:YXDictDO的list")
	})
	public List<YXDictDO> getTypeLists(@RequestParam Integer uvcode,@RequestParam String type) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("code",type);//
		params.put("uvcode",uvcode);
		params.put("sort","order_num");
		params.put("order","asc");
		// 查询列表数据
		return dictService.list(params);
	}
	
	@Log("获取具体类型的学校字典数据")
	@GetMapping("/type/listin")
	@ApiOperation(value="获取具体学校字典、机构级别、宿舍级别等", notes="获取具体类型的学校字典数据,多个获取")
//    @ApiImplicitParams({
//		@ApiImplicitParam(name = "uvcode", value = "学校唯一编号", required = true, dataType = "int",paramType="query"),
//		@ApiImplicitParam(name = "types", value = "字典类型", required = true, dataType = "list",paramType="query"),
//  	})
	@ApiResponses({
		@ApiResponse( response = YXDictDO.class, code = 200, message = "返回结构:YXDictDO的list")
	})
	public Map<Integer,List<YXDictDO>> getTypeInLists(@RequestParam Integer uvcode,@RequestParam List<String> types) {
		// 查询列表数据
		return dictService.getTypeInLists(uvcode, types);
	}
	
	@Log("获取学校字典枚举列表")
	@GetMapping("/list")
	@ApiOperation(value="获取学校字典枚举列表", notes="获取学校字典枚举列表")
//  @ApiImplicitParams({
//		@ApiImplicitParam(name = "", value = "", required = true, dataType = "int",paramType="query"),
//  })
	@ApiResponses({
		@ApiResponse( response = YXDictDO.class, code = 200, message = "返回结构:YXDictDO的list")
	})
	public List<YXDictDO> getList( YXDictDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return dictService.list(params);
	}
	
	@Log("获取学校字典枚举分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取学校字典枚举分页列表", notes="获取学校字典枚举分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, YXDictDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = dictService.count(query);		
		PPageUtils pageUtil = new PPageUtils(dictService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加学校字典枚举")
	@PostMapping("/save")
	@ApiOperation(value="添加学校字典枚举", notes="添加学校字典枚举"
			+ "入参Dict，是YXDictDO(学校字典枚举类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  YXDictDO dict) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(dictService.save(dict)>0){
			return PR.ok("添加学校字典枚举成功");
		}
		return PR.error("添加学校字典枚举失败");
	}
	
	@Log("修改学校字典枚举信息")
	@PostMapping("/update")
	@ApiOperation(value="修改学校字典枚举", notes="修改学校字典枚举"
		+ "入参Dict，是YXDictDO(学校字典枚举类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody YXDictDO dict) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (dictService.update(dict) > 0) {
			
			return PR.ok("修改学校字典枚举成功");
		}
		return PR.error("修改学校字典枚举失败");
	}
	
	@Log("删除学校字典枚举信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除学校字典枚举", notes="删除学校字典枚举,入参是学校字典枚举Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(dictService.remove(vid.getId())>0){
			return PR.ok("删除学校字典枚举成功");
		}
		return PR.error("删除学校字典枚举失败");
		
	}
	
	@Log("批量删除学校字典枚举信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除学校字典枚举", notes="批量删除学校字典枚举")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(dictService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除学校字典枚举成功");
		}
		return PR.error("批量删除学校字典枚举失败");
	}
	
}
