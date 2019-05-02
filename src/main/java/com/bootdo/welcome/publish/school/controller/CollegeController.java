package com.bootdo.welcome.publish.school.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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
import com.bootdo.common.utils.R;
import com.bootdo.welcome.domain.ClassDO;
import com.bootdo.welcome.domain.CollegeDO;
import com.bootdo.welcome.domain.SchoolDepartmentDO;
import com.bootdo.welcome.domain.SchoolDistrictDO;
import com.bootdo.welcome.domain.SchoolProfessionDO;
import com.bootdo.welcome.service.ClassService;
import com.bootdo.welcome.service.CollegeService;
import com.bootdo.welcome.utils.PPageUtils;
import com.bootdo.welcome.utils.PQuery;
import com.bootdo.welcome.utils.PR;
import com.bootdo.welcome.vo.BatchRemoveInput;
import com.bootdo.welcome.vo.DeletedIdVO;
import com.bootdo.welcome.vo.FindIdVO;
import com.bootdo.welcome.vo.FindStringIdVO;
import com.bootdo.welcome.vo.SchoolDepartmentVO;
import com.bootdo.welcome.vo.SchoolDistrictVO;
import com.bootdo.welcome.vo.SchoolProfessionVO;
import com.bootdo.welcome.vo.admin.CollegeScanVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.bootdo.common.annotation.Log;

/**
 * 学校院系机构 相关服务
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-23 16:06:36
 */

@RestController
@RequestMapping("/welcome/publish/school/college")
@Api(value = "学校院系机构相关服务", description = "学校院系机构相关服务")
public class CollegeController {

	static Logger log = LoggerFactory.getLogger(CollegeController.class);

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private ClassService classService;

	@Autowired
	ValidateMessage validateMessage;

	@Log("获取学校院系机构列表")
	@GetMapping("/list")
	@ApiOperation(value = "获取学校院系机构列表", notes = "获取学校院系机构列表")
	@ApiResponses({ @ApiResponse(response = CollegeDO.class, code = 200, message = "返回结构:CollegeDO的list") })
	public List<CollegeDO> getList(CollegeScanVO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		if (condition != null)
			params.put("uvCode", condition.getUvCode());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getcName()))
			params.put("cName", condition.getcName());// 业务的筛选条件
		if (condition != null && condition.getcLevel() != null)
			params.put("cLevel", condition.getcLevel());// 业务的筛选条件
		if (condition != null && condition.getParentId() != null)
			params.put("parentId", condition.getParentId());// 业务的筛选条件
		if (condition != null && condition.getcCode() != null)
			params.put("cCode", condition.getcCode());// 业务的筛选条件
		return collegeService.list(params);
	}

	@Log("获取学校院系机构分页列表")
	@GetMapping("/list/page")
	@ApiOperation(value = "获取学校院系机构分页列表", notes = "获取学校院系机构分页列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class") })
	public PPageUtils getListPage(@RequestParam int page, @RequestParam int size, CollegeScanVO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);// 数据偏移量
		params.put("size", size);// 每页条数
		params.put("sort", "id");// 每页条数
		params.put("order", "asc");// 每页条数
		if (condition != null)
			params.put("uvCode", condition.getUvCode());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getcName()))
			params.put("cName", condition.getcName());// 业务的筛选条件
		if (condition != null && condition.getcLevel() != null)
			params.put("cLevel", condition.getcLevel());// 业务的筛选条件
		if (condition != null && condition.getParentId() != null)
			params.put("parentId", condition.getParentId());// 业务的筛选条件
		if (condition != null && condition.getcCode() != null)
			params.put("cCode", condition.getcCode());// 业务的筛选条件

		PQuery query = new PQuery(params);
		int total = collegeService.count(query);
		PPageUtils pageUtil = new PPageUtils(collegeService.list(query), total, page, size);
		return pageUtil;
	}

	@Log("添加学校院系机构")
	@PostMapping("/save")
	@ApiOperation(value = "添加学校院系机构", notes = "添加学校院系机构" + "入参College，是CollegeDO(学校院系机构类)")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR save(@RequestBody CollegeDO college) {
		// 异常判断
		// ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.BUILDS_SAVE_SCODE_EXIST));

		if (collegeService.save(college) > 0) {
			return PR.ok("添加学校院系机构成功");
		}
		return PR.error("添加学校院系机构失败");
	}

	@Log("修改学校院系机构信息")
	@PostMapping("/update")
	@ApiOperation(value = "修改学校院系机构", notes = "修改学校院系机构" + "入参College，是CollegeDO(学校院系机构类)")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR update(@RequestBody CollegeDO college) {
		if (collegeService.update(college) > 0) {
			return PR.ok("修改学校院系机构成功");
		}
		return PR.error("修改学校院系机构失败");
	}

	@Log("删除学校院系机构信息")
	@PostMapping("/remove")
	@ApiOperation(value = "删除学校院系机构", notes = "删除学校院系机构,入参是学校院系机构Id")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody DeletedIdVO vid) {
		if (collegeService.remove(vid.getId()) > 0) {
			return PR.ok("删除学校院系机构成功");
		}
		return PR.error("删除学校院系机构失败");

	}

	@Log("批量删除学校院系机构信息")
	@PostMapping("/batchRemove")
	@ApiOperation(value = "批量删除学校院系机构", notes = "批量删除学校院系机构")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR remove(@RequestBody BatchRemoveInput bids) {

		if (collegeService.batchRemove(bids.getIds()) > 0) {
			return PR.ok("批量删除学校院系机构成功");
		}
		return PR.error("批量删除学校院系机构失败");
	}

	@GetMapping("/department/all")
	@ApiOperation(value = "获取所有的院系", notes = "获取所有的院系")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "uvcode", value = "学校唯一编号", required = true, dataType = "int", paramType = "query"), })
	@ApiResponses({
			@ApiResponse(response = SchoolDepartmentDO.class, code = 200, message = "返回结构:SchoolDepartmentDO的list") })
	public List<CollegeDO> getAllDepartment(@RequestParam Integer uvcode) {
		CollegeScanVO csvo = new CollegeScanVO();
		csvo.setUvCode(uvcode);
		csvo.setcLevel(2);// 院系
		return getList(csvo);
	}

	@PostMapping("/department/add")
	@ApiOperation(value = "新增一个院系", notes = "新增一个院系")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public PR addDepartment(@RequestBody CollegeDO college) {
		college.setCLevel(2);
		return save(college);
	}

	@PostMapping("/department/update")
	@ResponseBody
	@ApiOperation(value = "更新某个院系", notes = "更新某个院系")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public PR updateDepartment(@RequestBody CollegeDO college) {
		college.setCLevel(2);
		return update(college);
	}

	@PostMapping("/department/delete")
	@ResponseBody
	@ApiOperation(value = "删除某个院系", notes = "删除某个院系")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "departmentcode", value = "院系编号", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public PR deleteDepartment(DeletedIdVO deletedIdVO) {
		return remove(deletedIdVO);
	}

	@Log("获取班级列表")
	@GetMapping("/class/all")
	@ApiOperation(value = "获取班级列表", notes = "获取班级列表")
	@ApiResponses({ @ApiResponse(response = ClassDO.class, code = 200, message = "返回结构:ClassDO的list") })
	public List<ClassDO> getClassList(ClassDO condition) {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		if (condition != null)
			params.put("uvCode", condition.getUvCode());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getClName()))
			params.put("clName", condition.getClName());// 业务的筛选条件
		if (condition != null)
			params.put("clZy", condition.getClZy());// 业务的筛选条件
		if (condition != null)
			params.put("clYx", condition.getClYx());// 业务的筛选条件
		if (condition != null)
			params.put("clXq", condition.getClXq());// 业务的筛选条件
		if (condition != null)
			params.put("clNj", condition.getClNj());// 业务的筛选条件
		if (condition != null)
			params.put("uId", condition.getUId());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getClCode()))
			params.put("clCode", condition.getClCode());// 业务的筛选条件
		return classService.list(params);
	}

	@Log("获取班级分页列表")
	@GetMapping("/class/list/page")
	@ApiOperation(value = "获取班级分页列表", notes = "获取班级分页列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "分页,当前页", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "分页,每页条数", required = true, dataType = "int", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = PPageUtils.class, code = 200, message = "返回结构:PPageUtils.class") })
	public PPageUtils getClassListPage(@RequestParam int page, @RequestParam int size, ClassDO condition) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (condition != null)
			params.put("uvCode", condition.getUvCode());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getClName()))
			params.put("clName", condition.getClName());// 业务的筛选条件
		if (condition != null)
			params.put("clZy", condition.getClZy());// 业务的筛选条件
		if (condition != null)
			params.put("clYx", condition.getClYx());// 业务的筛选条件
		if (condition != null)
			params.put("clXq", condition.getClXq());// 业务的筛选条件
		if (condition != null)
			params.put("clNj", condition.getClNj());// 业务的筛选条件
		if (condition != null)
			params.put("uId", condition.getUId());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getClCode()))
			params.put("clCode", condition.getClCode());// 业务的筛选条件

		PQuery query = new PQuery(params);
		int total = classService.count(query);
		PPageUtils pageUtil = new PPageUtils(classService.list(query), total, page, size);
		return pageUtil;
	}

	@Log("添加班级")
	@PostMapping("/class/save")
	@ApiOperation(value = "添加班级", notes = "添加班级" + "入参Class，是ClassDO(班级类)")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR saveClass(@RequestBody ClassDO cl) {
		if (classService.save(cl) > 0) {
			return PR.ok("添加班级成功");
		}
		return PR.error("添加班级失败");
	}

	@Log("修改班级信息")
	@PostMapping("/class/update")
	@ApiOperation(value = "修改班级", notes = "修改班级" + "入参Class，是ClassDO(班级类)")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR updateClass(@RequestBody ClassDO cl) {
		if (classService.update(cl) > 0) {
			return PR.ok("修改班级成功");
		}
		return PR.error("修改班级失败");
	}

	@Log("删除班级信息")
	@PostMapping("/class/remove")
	@ApiOperation(value = "删除班级", notes = "删除班级,入参是班级Id")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR removeClass(DeletedIdVO vid) {
		if (classService.remove(vid.getId()) > 0) {
			return PR.ok("删除班级成功");
		}
		return PR.error("删除班级失败");
	}

	@Log("批量删除班级信息")
	@PostMapping("/class/batchRemove")
	@ApiOperation(value = "批量删除班级", notes = "批量删除班级")
	@ApiResponses({ @ApiResponse(response = PR.class, code = 200, message = "返回结构:PR.class") })
	public PR removeClass(@RequestBody BatchRemoveInput bids) {
		if (classService.batchRemove(bids.getIds()) > 0) {
			return PR.ok("批量删除班级成功");
		}
		return PR.error("批量删除班级失败");
	}

	@Log("获取所有的校区")
	@GetMapping(value = "/district/all")
	@ResponseBody
	@ApiOperation(value = "获取所有的校区", notes = "获取所有的校区")
	@ApiResponses({
			@ApiResponse(response = SchoolDistrictDO.class, code = 200, message = "返回结构:SchoolDistrictDO的list") })
	public List<SchoolDistrictDO> getDistrictAll(SchoolDistrictDO condition) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolName()))
			params.put("schoolName", condition.getSchoolName());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolCode()))
			params.put("schoolCode", condition.getSchoolCode());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolAddress()))
			params.put("schoolAddress", condition.getSchoolAddress());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolPhone()))
			params.put("schoolPhone", condition.getSchoolPhone());// 业务的筛选条件

		List<SchoolDistrictDO> list = new ArrayList<SchoolDistrictDO>();
		for (int i = 1; i < 10; i++) {
			SchoolDistrictDO schoolDistrictDO = new SchoolDistrictDO();
			schoolDistrictDO.setId(i);
			schoolDistrictDO.setSchoolName("学校" + i);
			schoolDistrictDO.setSchoolCode("学校编码" + i);
			schoolDistrictDO.setSchoolAddress("山西省太原市");
			list.add(schoolDistrictDO);
		}

		return list;
	}

	@Log("分页获取校区")
	@ResponseBody
	@GetMapping(value = "/district/get")
	@ApiOperation(value = "获取某个校区", notes = "提交校区编号来获取某个校区")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "schoolcode", value = "校区编号", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({
			@ApiResponse(response = SchoolDistrictDO.class, code = 200, message = "返回结构:SchoolDistrictDO的List") })
	public PPageUtils getDistrictList(SchoolDistrictDO condition) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolName()))
			params.put("schoolName", condition.getSchoolName());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolCode()))
			params.put("schoolCode", condition.getSchoolCode());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolAddress()))
			params.put("schoolAddress", condition.getSchoolAddress());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getSchoolPhone()))
			params.put("schoolPhone", condition.getSchoolPhone());// 业务的筛选条件

		SchoolDistrictDO schoolDistrictDO = new SchoolDistrictDO();
		schoolDistrictDO.setId(1);
		schoolDistrictDO.setSchoolName("学校名称");
		schoolDistrictDO.setSchoolCode("学校编码");
		schoolDistrictDO.setSchoolAddress("山西省太原市");
		List<SchoolDistrictDO> list = new ArrayList<SchoolDistrictDO>();
		list.add(schoolDistrictDO);

		PQuery query = new PQuery(params);
		int total = classService.count(query);
		PPageUtils pageUtil = new PPageUtils(list, total, 1, 1);
		return pageUtil;
	}

	@Log("新增校区")
	@ResponseBody
	@PostMapping(value = "/district/add")
	@ApiOperation(value = "新增某个校区", notes = "提交校区编号、校区名字、校区地址来更新校区")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public PR addDistrict(@RequestBody SchoolDistrictDO schoolDistrictDO) {
		return PR.ok("新增成功");
	}

	@Log("更新校区")
	@ResponseBody
	@PostMapping(value = "/district/update")
	@ApiOperation(value = "更新某个校区", notes = "提交校区编号、校区名字、校区地址来更新校区")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public PR update(@RequestBody SchoolDistrictDO schoolDistrictDO) {
		return PR.ok("更新校区成功");
	}

	@Log("删除校区")
	@ResponseBody
	@PostMapping(value = "/district/delete")
	@ApiOperation(value = "删除某个校区", notes = "通过学校编码进行删除某个校区")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "schoolcode", value = "校区编号", required = true, dataType = "String", paramType = "query"), })
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "true为成功，false为失败") })
	public PR deleteDistrict(DeletedIdVO deletedStringIdVO) {
		return PR.ok("删除班级成功");
	}

	@GetMapping("/profession/all")
	@ResponseBody
	@ApiOperation(value = "获取所有的专业", notes = "获取所有的专业")
	@ApiResponses({
			@ApiResponse(response = SchoolProfessionDO.class, code = 200, message = "返回结构:SchoolProfessionDO的list") })
	public List<SchoolProfessionDO> getProfessionAll(SchoolProfessionDO condition) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (condition != null)
			params.put("id", condition.getId());// 业务的筛选条件
		if (condition != null && StringUtils.isNotBlank(condition.getProfessionName()))
			params.put("professionName", condition.getProfessionName());// 业务的筛选条件

		List<SchoolProfessionDO> list = new ArrayList<SchoolProfessionDO>();
		for (int i = 1; i < 10; i++) {
			SchoolProfessionDO schoolProfessionDO = new SchoolProfessionDO();
			schoolProfessionDO.setProfessionName("专业名称" + i);
			list.add(schoolProfessionDO);
		}
		return list;
	}

	@PostMapping("/profession/add")
	@ResponseBody
	@ApiOperation(value = "增加一个专业", notes = "增加一个专业")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public PR addProfession(SchoolProfessionDO schoolProfessionDO) {
		return PR.ok("新增成功!");
	}

	@PostMapping("/profession/update")
	@ResponseBody
	@ApiOperation(value = "更新某个专业", notes = "更新某个专业")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public PR updateProfession(SchoolProfessionDO schoolProfessionDO) {
		return PR.ok("更新成功");
	}

	@PostMapping("/profession/delete")
	@ResponseBody
	@ApiOperation(value = "删除某个专业", notes = "删除某个专业")
	@ApiResponses({ @ApiResponse(response = Boolean.class, code = 200, message = "返回结构:Bool对象") })
	public PR deleteProfession(DeletedIdVO deletedIdVO) {
		return PR.ok("删除成功");
	}
}
