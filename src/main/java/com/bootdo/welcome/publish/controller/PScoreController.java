package com.bootdo.welcome.publish.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.welcome.domain.ScoreDO;
import com.bootdo.welcome.service.ScoreService;
import com.bootdo.welcome.utils.PR;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("welcome/publish/score")
@Api(value="成绩相关服务",description="考核成绩相关服务")
public class PScoreController extends BaseController{

	@Autowired
	ScoreService scoreservice;
	
	@Autowired
	ValidateMessage validateMessage;
	
	
	@Log("获取用户考核总成绩")
	@GetMapping("/report")
	@ApiOperation(value="获取用户考核总成绩", notes="获取用户考核总成绩,考核次数、最佳时间、最佳成绩")
	@ApiResponses({
		@ApiResponse( response = ScoreDO.class, code = 200, message = "返回结构:ScoreDO.class")
	})
	ScoreDO getScore() {
		return	scoreservice.gettotalscore(getUserId().intValue());
//		return null;
	}
	
	@Log("保存用户考核记录")
	@PostMapping("/save")
	@ApiOperation(value="上传保存用户考核记录", notes="上传保存用户考核记录,"
			+ "入参 ScoreDO类")
	@ApiResponses({
		@ApiResponse( response = PR.class, code = 200, message = "返回结构:PR.class")
	})
	PR saveScore(@RequestBody ScoreDO scoredo) {
		if(scoredo==null)  ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.SCORE_ADD_NULL_INPUT));
		if(scoredo.getUid()==null) scoredo.setUid(getUserId().intValue());
		if(scoredo.getPtime()==null) scoredo.setPtime(System.currentTimeMillis());
		
		if(scoreservice.save(scoredo)>0) {
			return PR.ok("保存考核成绩成功");
		}
		return PR.ok("保存考核成绩失败");
	}
	
	@Log("获取用户全部考核记录")
	@GetMapping("/record/all")
	@ApiOperation(value="获取用户全部考核记录", notes="获取用户全部考核记录,同步用户考核信息使用")
	@ApiResponses({
		@ApiResponse( response = ScoreDO.class, code = 200, message = "返回结构:ScoreDO的list")
	})
	List<ScoreDO> getAllRecord() {
		getUserId();
		Map<String,Object> pmap = new HashMap<String,Object>();
		pmap.put("uid",getUserId());//
		return scoreservice.list(pmap);
	}
}
