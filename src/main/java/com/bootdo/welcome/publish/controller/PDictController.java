package com.bootdo.welcome.publish.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.welcome.domain.admin.YXDictDO;
import com.bootdo.welcome.service.admin.YXDictService;
import com.bootdo.welcome.vo.disasterVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("welcome/publish/yw/dict")
@Api(value="字典枚举相关",description="字典枚举相关")
public class PDictController extends BaseController{

	
	@Autowired
	private YXDictService dictService;

//	@Log("获取字典类型")
//	@GetMapping("/type")
//	@ApiOperation(value="获取字典类型", notes="获取字典类型")
//	@ApiResponses({
//		@ApiResponse( response = YXDictDO.class, code = 200, message = "返回结构:YXDictDO的list")
//	})
//	public List<YXDictDO> listType() {
//		return dictService.listType();
//	}
//	
//	@Log("获取具体类型的字典数据")
//	@GetMapping("/type/list")
//	@ApiOperation(value="获取具体字典、词库分类等", notes="获取具体类型的字典数据")
//    @ApiImplicitParams({
//		@ApiImplicitParam(name = "type", value = "字典类型：90001:词库分类", required = true, dataType = "int",paramType="query"),
//  	})
//	@ApiResponses({
//		@ApiResponse( response = YXDictDO.class, code = 200, message = "返回结构:YXDictDO的list")
//	})
//	public List<YXDictDO> getTypeLists(String type) {
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("dmode",1);//强制前端只显示类型1的字典
//		params.put("type",type);//
//		params.put("sort","sort");
//		params.put("order","asc");
//		// 查询列表数据
//		return dictService.list2(params);
//	}
}
