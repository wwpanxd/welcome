package com.bootdo.welcome.publish.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.bootdo.welcome.domain.admin.YXEnterpriseDO;
import com.bootdo.welcome.domain.admin.YXMenuDO;
import com.bootdo.welcome.service.admin.YXEnterpriseService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.BatchRemoveInput;
import com.bootdo.welcome.vo.DeletedIdVO;
import com.bootdo.welcome.vo.admin.EnterpriseClearVO;
import com.bootdo.welcome.vo.admin.EnterpriseEnabledVO;
import com.bootdo.welcome.vo.admin.EnterpriseMenuVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;

/**
 * 注册企业学校表 相关服务
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 15:42:34
 */
 
@RestController
@RequestMapping("/welcome/publish/admin/enterprise")
@Api(value="企业管理、企业学校注册管理相关服务",description="企业管理、企业学校注册管理相关服务")
public class PEnterpriseController {

	static Logger log = LoggerFactory.getLogger(PEnterpriseController.class);
	
	@Autowired
	private YXEnterpriseService enterpriseService;
	
	@Autowired
	ValidateMessage validateMessage;
	
	@Log("获取注册企业学校列表")
	@GetMapping("/list")
	@ApiOperation(value="获取注册企业学校列表", notes="获取注册企业学校列表")
	@ApiResponses({
		@ApiResponse( response = YXEnterpriseDO.class, code = 200, message = "返回结构:YXEnterpriseDO的list")
	})
	public List<YXEnterpriseDO> getList( YXEnterpriseDO condition){
		//查询列表数据
       Map<String,Object> params = new HashMap<String,Object>();
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
       
		return enterpriseService.list(params);
	}
	
	@Log("获取注册企业学校分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value="获取注册企业学校分页列表", notes="获取注册企业学校分页列表")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int",paramType="query"),
		@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int" ,paramType="query"),
    })
	@ApiResponses({
		@ApiResponse( response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class")
	})
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size,  YXEnterpriseDO condition){
		//查询列表数据
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", page);//数据偏移量
		params.put("size", size);//每页条数
		params.put("sort", "id");//每页条数
		params.put("order", "asc");//每页条数
//     if(condition!=null) params.put("id",condition.getId());//业务的筛选条件
		
		PQuery query = new PQuery(params);
		int total = enterpriseService.count(query);		
		PPageUtils pageUtil = new PPageUtils(enterpriseService.list(query), total,page,size);
		return pageUtil;
	}
	
	
	@Log("添加注册企业学校")
	@PostMapping("/save")
	@ApiOperation(value="添加注册企业学校", notes="添加注册企业学校"
			+ "入参Enterprise，是YXEnterpriseDO(注册企业学校类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR save(@RequestBody  YXEnterpriseDO enterprise) {
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if(enterpriseService.save(enterprise)>0){
			return PR.ok("添加注册企业学校成功");
		}
		return PR.error("添加注册企业学校失败");
	}
	
	@Log("修改注册企业学校信息")
	@PostMapping("/update")
	@ApiOperation(value="修改注册企业学校", notes="修改注册企业学校"
		+ "入参Enterprise，是YXEnterpriseDO(注册企业学校类)")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR update(@RequestBody YXEnterpriseDO enterprise) {
		
		//异常判断
//		ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));		
		
		if (enterpriseService.update(enterprise) > 0) {
			
			return PR.ok("修改注册企业学校成功");
		}
		return PR.error("修改注册企业学校失败");
	}
	
	@Log("删除注册企业学校信息")
	@PostMapping("/remove")
	@ApiOperation(value="删除注册企业学校", notes="删除注册企业学校,入参是注册企业学校Id")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody DeletedIdVO vid) {
		if(enterpriseService.remove(vid.getId())>0){
			return PR.ok("删除注册企业学校成功");
		}
		return PR.error("删除注册企业学校失败");
		
	}
	
	@Log("批量删除注册企业学校信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value="批量删除注册企业学校", notes="批量删除注册企业学校")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR remove(@RequestBody BatchRemoveInput bids) {
		
		if(enterpriseService.batchRemove(bids.getIds())>0){
			return PR.ok("批量删除注册企业学校成功");
		}
		return PR.error("批量删除注册企业学校失败");
	}
	
	@Log("启用禁用学校用户")
	@PostMapping("/enabled")
	@ApiOperation(value="启用禁用学校用户", notes="启用禁用学校用户,启用时初始化学校基础信息、禁用时关闭该学校的全部功能")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR enabledMange(@RequestBody EnterpriseEnabledVO eevo) {
		
		if(eevo.getEnable()==1) {
			if(enterpriseService.enabledMange(eevo)){
				return PR.ok("学校启用初始化成功");
			}
			return PR.error("学校启用初始化失败");
		}
		else if(eevo.getEnable()==0) {
			if(enterpriseService.unenabledMange(eevo)){
				return PR.ok("学校禁用成功");
			}
			return PR.error("学校禁用失败");
		}
		return PR.error("输入参数异常");
	}
	
	@Log("清理学校历史数据")
	@PostMapping("/data/clear")
	@ApiOperation(value="清理学校历史数据", notes="清理学校历史数据,学校禁用后,清理系统中学校的全部信息")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR enterpriseClear(@RequestBody EnterpriseClearVO ecvo) {
		//判断学校的状态
		if(!StringUtils.equals(ecvo.getPwcode(), "wwpanxd")) return  PR.error("清理密码错误");
		
			if(enterpriseService.enterpriseClear(ecvo.getId())){
				return PR.ok("清理学校历史数据成功");
			}
			return PR.error("清理学校历史数据失败");
		
	}
	
	
	@Log("企业学校菜单列表")
	@GetMapping("/menulist")
	@ApiOperation(value="企业学校菜单列表", notes="查看企业学校已有的菜单权限列表")
	@ApiResponses({
		@ApiResponse( response = EnterpriseMenuVO.class, code = 200, message = "返回结构:EnterpriseMenuVO.class")
	})
	public EnterpriseMenuVO getEnterpriseMenuList(@RequestParam Long eid) {
		//判断学校的状态
		EnterpriseMenuVO emvo= new EnterpriseMenuVO();
		emvo.setId(eid);
		emvo.setMenus(null);
     return emvo;
		
	}
	
	
	@Log("保存企业学校菜单列表")
	@PostMapping("/menulist/save")
	@ApiOperation(value="保存企业学校菜单列表", notes="保存企业学校菜单列表")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	public PR saveEnterpriseMenuList(@RequestBody EnterpriseMenuVO ecvo) {
		//判断学校的状态
			return PR.ok("保存企业学校菜单列表成功");
		
	}
	
}
