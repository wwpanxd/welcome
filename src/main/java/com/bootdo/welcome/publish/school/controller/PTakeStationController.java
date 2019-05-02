package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.StageDO;
import com.bootdo.welcome.domain.StuCollegeDO;
import com.bootdo.welcome.domain.StuHealthyDO;
import com.bootdo.welcome.domain.StuTakeStationDO;
import com.bootdo.welcome.publish.admin.controller.PStageFileController;
import com.bootdo.welcome.service.PStuHealthyService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.DeletedStringId;
import com.bootdo.welcome.vo.StuHealthyListVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/welcome/publish/takestation")
@Api(value = "接站信息配置", description = "接站信息配置")
public class PTakeStationController {
	static Logger log = LoggerFactory.getLogger(PStageFileController.class);

	@Autowired
	private PStuHealthyService pStuHealthyService;

	@Autowired
	ValidateMessage validateMessage;

	@Log("获取接站信息配置")
	@GetMapping("/list")
	@ApiOperation(value = "获取接站信息配置列表", notes = "获取接站信息配置列表")
	@ApiResponses({
			@ApiResponse(response = StuTakeStationDO.class, code = 200, message = "返回结构:StuTakeStationDO的list") })
	public List<StuTakeStationDO> getList(StuTakeStationDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件

		List<StuTakeStationDO> list = new ArrayList<StuTakeStationDO>();
		return list;
	}

	@Log("获取接站信息配置列表分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value = "获取接站信息配置列表分页列表", notes = "获取接站信息配置列表分页列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class") })
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, StuTakeStationDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);// 数据偏移量
		params.put("size", size);// 每页条数
		params.put("sort", "id");// 每页条数
		params.put("order", "asc");// 每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件

//		PQuery query = new PQuery(params);
//		int total = stageService.count(query);
//		PPageUtils pageUtil = new PPageUtils(stageService.list(query), total, page, size);
//		return pageUtil;
		List<StuTakeStationDO> list = new ArrayList<StuTakeStationDO>();
		PPageUtils pageUtil = new PPageUtils(list, 1, page, size);
		return pageUtil;
	}

	@Log("添加接站信息配置信息")
	@PostMapping("/save")
	@ApiOperation(value = "添加接站信息配置信息", notes = "添加接站信息配置信息" + "入参stuTakeStationDO，是StuTakeStationDO类")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR save(@RequestBody StuTakeStationDO stuTakeStationDO) {
		return PR.ok("添加接站信息配置信息成功");
	}

	@Log("删除某学生接站信息配置信息")
	@PostMapping("/remove")
	@ApiOperation(value = "删除某学生接站信息配置信息", notes = "删除某学生接站信息配置信息,入参是学生的唯一编码")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody DeletedStringId vid) {
		return PR.ok("删除某学生接站信息配置信息成功");
	}

	@Log("修改某学生接站信息配置信息")
	@PostMapping("/update")
	@ApiOperation(value = "修改某学生接站信息配置信息", notes = "修改某学生接站信息配置信息" + "入参stuTakeStationDO，是StuTakeStationDO类")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR update(@RequestBody StuTakeStationDO stuTakeStationDO) {
		return PR.ok("修改某学生接站信息配置信息成功");
	}
}
