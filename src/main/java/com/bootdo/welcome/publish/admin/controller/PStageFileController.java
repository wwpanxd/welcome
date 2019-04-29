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
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.StageFileDO;
import com.bootdo.welcome.service.StageFileService;
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
 * 迎新阶段文件表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-29 11:42:24
 */
 
@RestController
@RequestMapping("/welcome/publish/admin/stageFile")
@Api(value="学校迎新阶段文件管理相关服务",description="迎新阶段文件管理相关服务")
public class PStageFileController {

	static Logger log = LoggerFactory.getLogger(PStageFileController.class);
	
	@Autowired
	private StageFileService stageFileService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取学校迎新阶段文件列表")
	@GetMapping("/list")
	@ApiOperation(value="获取学校迎新阶段文件列表", notes="获取学校迎新阶段文件列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "uvcode", value = "学校唯一编号", required = true, dataType = "int",paramType="query"),
	})
	@ApiResponses({
		@ApiResponse( response = StageFileDO.class, code = 200, message = "返回结构:StageFileDO的list")
	})
	public List<StageFileDO> getList(@RequestParam Integer uvcode){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
       params.put("uvCode",uvcode);//业务的筛选条件
       
		return stageFileService.list(params);
	}
	
	@Log("获取学校迎新阶段文件分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取学校迎新阶段文件分页列表", notes="获取学校迎新阶段文件分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size,  StageFileDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = stageFileService.count(query);		
		PPageUtils pageUtil = new PPageUtils(stageFileService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加学校迎新阶段文件")
	@PostMapping("/save")
	@ApiOperation(value="添加学校迎新阶段文件", notes="添加学校迎新阶段文件"
			+ "入参StageFile，是StageFileDO(学校迎新阶段文件类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  StageFileDO stageFile) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(stageFileService.save(stageFile)>0){
			return PR.ok("添加学校迎新阶段文件成功");
		}
		return PR.error("添加学校迎新阶段文件失败");
	}
	
	@Log("修改学校迎新阶段文件信息")
	@PostMapping("/update")
	@ApiOperation(value="修改学校迎新阶段文件", notes="修改学校迎新阶段文件"
		+ "入参StageFile，是StageFileDO(学校迎新阶段文件类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody StageFileDO stageFile) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (stageFileService.update(stageFile) > 0) {
			
			return PR.ok("修改学校迎新阶段文件成功");
		}
		return PR.error("修改学校迎新阶段文件失败");
	}
	
	@Log("删除学校迎新阶段文件信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除学校迎新阶段文件", notes="删除学校迎新阶段文件,入参是学校迎新阶段文件Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(stageFileService.remove(vid.getId())>0){
			return PR.ok("删除学校迎新阶段文件成功");
		}
		return PR.error("删除学校迎新阶段文件失败");
		
	}
	
	@Log("批量删除学校迎新阶段文件信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除学校迎新阶段文件", notes="批量删除学校迎新阶段文件")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(stageFileService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除学校迎新阶段文件成功");
		}
		return PR.error("批量删除学校迎新阶段文件失败");
	}
	
}
