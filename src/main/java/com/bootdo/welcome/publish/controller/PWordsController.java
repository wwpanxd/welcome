package com.bootdo.welcome.publish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.GzipUtils;
import com.bootdo.welcome.domain.WordsDO;
import com.bootdo.welcome.service.WordsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("welcome/publish/words")
@Api(value="具体单词服务",description="具体单词相关服务")
public class PWordsController extends BaseController{

	@Autowired
	WordsService wordsservice;
	
	@Log("获取词库单词")
	@GetMapping("/update/download")
	@ApiOperation(value="获取词库单词", notes="获取最新词库全部单词,可以指定具体单词库,返回数据gzip压缩")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "tcodes", value = "词库分类数组", required = false, allowMultiple=true, dataType = "String",paramType="query"),
//	  	})
	@ApiResponses({
		@ApiResponse( response = String.class, code = 200, message = "返回结构:List<WordsDO>")
	})
	List<WordsDO> getAllWords(@RequestParam(value="tcodes",required=false) @ApiParam(value="词库分类数组") List<String> tcodes) {
//		String getAllWords( @ApiParam(value="词库分类数组") List<String> tcodes) {
//	String getAllWords(String[] tcodes) {
//		return tcodes.length + tcodes.toString();
		List<WordsDO>  wlist= wordsservice.listin(tcodes);
//		return GzipUtils.ReduceEncode(JSONObject.toJSONString(wlist));
		return wlist;
//		return JSONObject.toJSONString(wlist);
	}	
}
