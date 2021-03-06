package com.bootdo.welcome.vo;

import java.util.List;

import com.bootdo.welcome.domain.StuHealthyDO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StuHealthyDO", description = "新增学生健康信息")
public class StuHealthyListVO {
	// 学生唯一编码 sCode
	@ApiModelProperty(value = "学生健康信息列表")
	private List<StuHealthyDO> list;
}
